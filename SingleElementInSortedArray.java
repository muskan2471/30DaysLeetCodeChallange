/*
 You are given a sorted array consisting of only integers where every element appears exactly twice, 
 except for one element which appears exactly once. Find this single element that appears only once.
 
Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
 */
import java.util.*;
public class SingleElementInSortedArray 
{
	 public int singleNonDuplicate(int[] nums)
	  {
		 int res=0;
	       HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
	        for(int i=0;i<nums.length;i++)
	        {
	            if(!hash.containsKey(nums[i]))
	            {
	                hash.put(nums[i],1);
	            }
	            else
	            {
	                hash.replace(nums[i],hash.get(nums[i])+1);
	            }
	        }
	        if(hash.containsValue(1))
	        {
	            for(int key:hash.keySet())
	            {
	                if(hash.get(key)==1)
	                {
	                    res=key;
	                }
	            }
	        }
	        
	        return res;
	    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SingleElementInSortedArray s=new SingleElementInSortedArray();
		int nums[]= {3,3,7,7,10,11,11};
		System.out.print(s.singleNonDuplicate(nums));

	}

}
