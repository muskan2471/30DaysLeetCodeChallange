/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        Queue<TreeNode> q=new LinkedList<>();
       // Queue<Integer> que=new LinkedList<>();
        q.add(root);
        TreeNode current;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(0);
        arr.add(root.val);
        while(!q.isEmpty())
        {
             current=q.remove();
            if(current!=null)
            {
               
                if(current.left!=null)
                {
                    q.add(current.left);
                    arr.add(current.left.val);
                }
                else
                {
                    q.add(null);
                    arr.add(0);
                }
                if(current.right==null)
                {
                    q.add(null);
                    arr.add(0);
                }
                else
                {
                    arr.add(current.right.val);
                    q.add(current.right);
                   
                }
            }
            else
            {
                q.add(null);
                q.add(null);
                arr.add(0);
                arr.add(0);
            }
            
        }
        System.out.print(arr);
        int indexOfChild1=arr.indexOf(x);
        int indexOfchild2=arr.indexOf(y);
        int parent1=indexOfChild1/2;
        int parent2=indexOfchild2/2;
        if(parent1==0 || parent2==0 || arr.get(parent1)==0 ||arr.get(parent2)==0)
        {
            return false;
        }
        else
        {
            if(arr.get(parent1)!=arr.get(parent2))
            {
                if((parent1/2)==(parent2/2))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        
    }
    
}