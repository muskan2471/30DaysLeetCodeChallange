/*
 Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:

Input: matrix =
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.


Example 2:
Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 */
public class CountSquareSubMatrix
{
	 public int countSquares(int[][] matrix)
	    {
	        int cnt=countNoOfOneInMatrix(matrix);
	        int size=2;
	        while(size<=matrix.length)
	        {
	            for(int i=0;i<=matrix.length-size;i++)
	            {
	                for(int j=0;j<=matrix[0].length-size;j++)
	                {
	                    if(matrix[i][j]==1)
	                    {
	                        int res=CheckSubSquare(i,j,size,matrix);
	                        if(res==1)
	                        {
	                            cnt++;
	                        }
	                    }
	                }
	            }
	            size++;
	            
	        }
	        return cnt;
	        
	    }
	    int CheckSubSquare(int i1,int j1,int size,int matrix[][])
	    {
	        int flag=0;
	        for(int i=i1;i<(i1+size);i++)
	        {
	            for(int j=j1;j<(j1+size);j++)
	            {
	                if(matrix[i][j]!=1)
	                {
	                    flag=1;
	                    break;
	                }
	            }
	            if(flag==1)
	            {
	                break;
	            }
	        }
	        if(flag==1)
	        {
	            return 0;
	        }
	        else
	        {
	           return 1; 
	        }
	    }
	    int countNoOfOneInMatrix(int[][] matrix)
	    {
	        int cnt=0;
	        for(int i=0;i<matrix.length;i++)
	        {
	            for(int j=0;j<matrix[0].length;j++)
	            {
	                if(matrix[i][j]==1)
	                {
	                    cnt++;
	                }
	            }
	        }
	        return cnt;
	    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		CountSquareSubMatrix c=new CountSquareSubMatrix();
		int arr[][]= {
				{0,1,1,1},
				{1,1,1,1},
				{0,1,1,1}};
		System.out.println(c.countSquares(arr));

	}

}
