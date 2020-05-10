/*
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
Examples:
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 */
public class FirstUniqueInArray 
{
	public int firstUniqChar(String s) 
    {
        int flag=0;
        int res=-1;
       come: for(int i=0;i<s.length();i++)
        {
            flag=0;
            for(int j=0;j<s.length();j++)
            {
                if(i!=j)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        flag=1;
                        continue come;
                    }
                }
            }
           if(flag==0)
           {
               res=i;
               break;
           }
        }
        return res;
    }
	public static void main(String args[])
	{
		FirstUniqueInArray f=new FirstUniqueInArray();
		String str="loveleetcode";
		System.out.print(f.firstUniqChar(str));
	}
}
