/*
Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2
 */
import java.util.*;
public class MajorityElement
{
	public static void main(String args[])
	{
		int nums[]= {2,2,1,1,1,2,2};
		HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(hash.containsKey(nums[i]))
            {
                
                hash.replace(nums[i],hash.get(nums[i])+1);
            }
            else
            {
            	arr.add(nums[i]);
                hash.put(nums[i],1);
            }
        }
        int majorityEle=(nums.length/2);
        
        int res=-1;
        for(int i=0;i<arr.size();i++)
        {
            if(hash.get(arr.get(i))>majorityEle)
            {
                majorityEle=hash.get(arr.get(i));
                res=arr.get(i);
            }
        }
        
        System.out.println(res);
	}

}
