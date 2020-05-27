/*
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

	Example 1:
	Input: [0,1]
	Output: 2
	Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
	
	
	Example 2:
	Input: [0,1,0]
	Output: 2
	Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
	Note: The length of the given binary array will not exceed 50,000.
 */
import java.util.*;
public class ContiguousArray 
{
	public int findMaxLength(int[] nums) 
    {
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        int cnt=0;
        int maxLen=0;
        hash.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            cnt=cnt+((nums[i]==1)?1:-1);
            if(hash.containsKey(cnt))
            {
                maxLen=Math.max(maxLen,i-hash.get(cnt));
            }
            else
            {
                hash.put(cnt,i);
            }
        }
        return maxLen;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ContiguousArray c=new ContiguousArray();
		int arr[]= {0,1,0};
		
		System.out.println(c.findMaxLength(arr));

	}

}
