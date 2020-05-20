import java.util.*;
class TreeNode 
{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class KthSmallestInBST
{
	ArrayList<Integer> inorder=new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) 
    {
        TreeNode current=root;
        Stack<TreeNode> st=new Stack<TreeNode>();
        while(!st.isEmpty() || current!=null )
        {
            while(current!=null)
            {
                st.push(current);
                current=current.left;
            }
            current=st.pop();
           // System.out.print(current.val+" ");
            inorder.add(current.val);
            current=current.right;
        }
        
        return inorder.get(k-1);
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		KthSmallestInBST k=new KthSmallestInBST();
		TreeNode head=new TreeNode(3);
		head.left=new TreeNode(1);
		head.right=new TreeNode(4);
		head.left.right=new TreeNode(2);
		System.out.println(k.kthSmallest(head,2));
		
	}

}
