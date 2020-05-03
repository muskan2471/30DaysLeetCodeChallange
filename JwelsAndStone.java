/*					 Jewels and Stones

You're given strings J representing the types of stones that are jewels, 
and S representing the stones you have.  Each character in S is a type of stone you have. 
You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters.
 Letters are case sensitive, so "a" is considered a different type of stone from "A".
 
 e.g:
 Input: J = "aA", S = "aAAbbbb"
Output: 3
*/
import java.util.*;
public class JwelsAndStone 
{
	public int numJewelsInStones(String J, String S)
    {
        int cnt=0;
        for(int i=0;i<S.length();i++)
        {
            if(J.contains(Character.toString(S.charAt(i))))
            {
                cnt++;
            }
        }
        return cnt;
    }
	public static void main(String[] args)
	{
		
		
		 JwelsAndStone object=new JwelsAndStone(); 
		 String s; String j;
		 Scanner sc=new Scanner(System.in); 
		 System.out.println("Enter String jwels:"); 
		 j=sc.next();
		 System.out.println("Enter String Stone:"); 
		 s=sc.next(); 
		 int res=object.numJewelsInStones(j,s); 
		 System.out.print(res);
		 
	}

}
/* OUTPUT
Enter String jwels:
aA
Enter String Stone:
aAAbbbbb
3
*/
