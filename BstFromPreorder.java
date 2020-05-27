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
public class BstFromPreorder 
{
	TreeNode bstFromPreorder(int[] preorder)
    {
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++)
        {
            insert(preorder[i],root);
        }
        return root;
    }
    void insert(int val,TreeNode root)
    {
        TreeNode current=root;
            int flag=0;
            while(flag==0)
            {
                if(val<current.val)
                {
                    if(current.left==null)
                    {
                        current.left=new TreeNode(val);
                        flag=1;
                    }
                    else
                    {
                        current=current.left;
                    }
                }
                else
                {
                    if(current.right==null)
                    {
                        current.right=new TreeNode(val);
                        flag=1;
                    }
                    else
                    {
                        current=current.right;
                    }
                }
            }
        
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BstFromPreorder b=new BstFromPreorder();
		int preorder[]= {8,5,1,7,10,12};
		TreeNode t=b.bstFromPreorder(preorder);
		Queue<TreeNode> q=new LinkedList();
		TreeNode current=t;
		q.add(current);
		while(!q.isEmpty())
		{
			TreeNode removed=q.remove();
			if(removed==null)
			{
				System.out.print("null ");
				
			}
			else
			{
				System.out.print(removed.val+" ");
				q.add(removed.left);
				q.add(removed.right);
			}
			
			
		}
	}

}
