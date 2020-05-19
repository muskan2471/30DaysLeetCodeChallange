/*
 The idea behind this approach is that one string will be a permutation of another string only if both of them
 contain the same characters the same number of times. One string xx is a permutation of other string yy only 
 if sorted(x)=sorted(y)sorted(x)=sorted(y).*/
import java.util.Arrays;
public class PermutationInString
{

	boolean checkInclusion(String s1, String s2) 
    {
       if(s1.length()>s2.length())
       {
    	   return false;
       }
       else
       {
    	   char arr[]=s1.toCharArray();
    	   Arrays.sort(arr);
    	   s1=String.valueOf(arr);
    	   System.out.println(s1);
    	   for(int i=0;i<=s2.length()-s1.length();i++)
    	   {
    		   String subStr=s2.substring(i,i+s1.length());
    		   arr=subStr.toCharArray();
    		   Arrays.sort(arr);
    		   subStr=String.valueOf(arr);
    		   System.out.println(s1);
    		   if(s1.equals(subStr))
    		   {
    			   return true;
    		   }
    	   }
    	   return false;
    	}
    }
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		PermutationInString p=new PermutationInString();
		System.out.println(p.checkInclusion("adc","dcda"));

	}

}
