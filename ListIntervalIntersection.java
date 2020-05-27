/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:
Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
*/
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
