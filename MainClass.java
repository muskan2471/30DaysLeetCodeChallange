/*Given a positive integer, output its complement number. 
The complement strategy is to flip the bits of its binary representation.
e.g:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
*/
import java.util.*;
class Solution {
    public int findComplement(int n) 
    {
        ArrayList<Integer> arr=new ArrayList<Integer>();
		int rem;
		while(n>0)
		{
			rem=n%2;
            n=n/2;
			arr.add(rem);
		}
        Collections.reverse(arr);
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)==1)
            {
                arr.set(i,0);
            }
            else
            {
                arr.set(i,1);
            }
        }
        int res=0;
       int power=0;
       for(int i=arr.size()-1;i>=0;i--)
       {
    	   res=res+(arr.get(i)*(int)Math.pow(2,power));
    	   power++;
       }
       return res;
        
    }
}