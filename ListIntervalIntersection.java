import java.util.*;
public class ListIntervalIntersection 
{
	 public int[][] intervalIntersection(int[][] A, int[][] B) 
	    {
	        int i=0,j=0;
	        ArrayList<int[]> arr=new ArrayList();
	        while(i<A.length && j<B.length)
	        {
	            int start=Math.max(A[i][0],B[j][0]);//strat intercection point
	            int end=Math.min(A[i][1],B[j][1]);//end of  intercection point
	            
	            if(start<=end)          //if it is valid then only add
	            {
	                arr.add(new int[]{start,end});
	            }
	            
	            if(A[i][1]<B[j][1])//
	            {
	                i++;
	            }
	            else                //
	            {
	                j++;
	            }
	        }
	        return arr.toArray(new int[arr.size()][]);
	    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ListIntervalIntersection l=new ListIntervalIntersection();
		int a[][]= {
				{0,2},{5,10},{13,23},{24,25}};
		int b[][]= {{1,5},{8,12},{15,24},{25,26}};
		
		int res[][]=l.intervalIntersection(a,b);
		for(int i=0;i<res.length;i++)
		{
			for(int j=0;j<res[0].length;j++)
			{
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
