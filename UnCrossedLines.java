/*
We write the integers of A and B (in the order they are given) on two separate horizontal lines.
Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
Return the maximum number of connecting lines we can draw in this way.

 
Example 1:

Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
Example 2:

Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3
Example 3:

Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
Output: 2
 */
public class UnCrossedLines 
{

	public int maxUncrossedLines(int[] A, int[] B) 
    {
       /* ArrayList<Integer> aList=new ArrayList<Integer>();
        ArrayList<Integer> bList=new ArrayList<Integer>();
        for(int i=0;i<A.length;i++)
        {
              aList.add(A[i]);  
        }
        for(int i=0;i<B.length;i++)
        {
              bList.add(B[i]);  
        }
        int cnt=0;
        int prevIndex=-1;
        int index=-1;
        for(int i=0;i<aList.size();i++)
        {
            prevIndex=index;
            int flag=0;
                while(flag==0)
                {
                    if(bList.contains(aList.get(i)))
                    {
                        index=bList.indexOf(aList.get(i));
                        if( index>prevIndex)
                        {
                            cnt++;
                            bList.set(index,0); 
                            flag=1;
                           // bList.add(index,0);
                        }
                        else
                        {
                            bList.set(index,0); 
                        }
                     }
                    else
                    {
                        flag=1;
                    }
                }
         }
        System.out.println(bList);
        return cnt;*/
        
        int[][] matrix=new int[A.length+1][B.length+1];
        
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]){
                    matrix[i+1][j+1]=matrix[i][j]+1;
                }
                else{
                    matrix[i+1][j+1]=Math.max(matrix[i+1][j],matrix[i][j+1]);
                }
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }
    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		UnCrossedLines u=new UnCrossedLines();
		int a[]= {2,5,1,2,5};
		int b[]= {10,5,2,1,5,2};
		System.out.println(u.maxUncrossedLines(a,b));
		
		 
	}

}
