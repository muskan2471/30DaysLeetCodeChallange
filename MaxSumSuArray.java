/*
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

Example 1:
Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3

Example 2:
Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

Example 3:
Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

Example 4:
Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3

Example 5:
Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1
 */
public class MaxSumSuArray 
{
	  int maxSubarraySumCircular(int[] a) 
	    {
	        int flag=0;
	        for(int i=0;i<a.length;i++)    //check if all elemnts in array are negative 
	        {
	            if(a[i]>0)
	            {
	                flag=1;
	                break;
	            }
	        }
	        if(flag==0) //if all element in array are negative then find max value and return it
	        {
	            int max=Integer.MIN_VALUE;
	            for(int i=0;i<a.length;i++)
	            {
	                if(a[i]>max)
	                {
	                    max=a[i];
	                }
	            }
	            return max;
	        }
	        else   //otherwise
	        {
	            int max_kadane = kadane(a); 
	           

	            // Case 2: Now find the maximum sum that includes 
	            // corner elements. 
	            int max_wrap = 0; 
	            for (int i = 0; i <a.length; i++) 
	            { 
	                max_wrap += a[i]; // Calculate array-sum 
	                a[i] = -a[i];  // invert the array (change sign) 
	            } 

	            // max sum with corner elements will be: 
	            // array-sum - (-max subarray sum of inverted array) 
	            
	            max_wrap = max_wrap + kadane(a); 
	           

	            // The maximum circular sum will be maximum f two sums 
	            return (max_wrap > max_kadane)? max_wrap: max_kadane; 
	        }
	      }
	    int kadane (int a[])   //find max sum in subArray
	    { 
	        int MaxSum = 0, sum = 0; 
	        for (int i = 0; i <a.length; i++) 
	        { 
	            sum = sum + a[i]; 
	            if (sum < 0) 
	            {
	                sum =0; 
	            }
	            if (MaxSum < sum) 
	            {
	                 MaxSum = sum; 
	            }
	               
	        } 
	        return MaxSum; 
	    } 

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MaxSumSuArray m=new MaxSumSuArray();
		int arr[]= {-1,-2,-3};
	   System.out.println(m.maxSubarraySumCircular(arr));

	}

}
