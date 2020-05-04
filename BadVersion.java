
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); 
e.g:
Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
*/

public class Solution extends VersionControl 
{
    public int firstBadVersion(int n) 
    {
        int left=1;
        int right=n;
        while(left<right)
        {
            int mid=(left+right)/2;
            if(isBadVersion(mid))
            {
               right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }
}