import java.util.*;
public class SortCharByFrequency 
{
	String frequencySort(String s)
    {
       HashMap<Character,Integer> hash=new HashMap<Character,Integer>(); 
       StringBuilder reverseChar=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(!hash.containsKey(s.charAt(i)))
            {
                hash.put(s.charAt(i),1);
            }
            else
            {
               hash.replace(s.charAt(i),hash.get(s.charAt(i))+1); 
            }
        }
        ArrayList<Integer> values=new ArrayList<Integer>(hash.values());
        Collections.sort(values);
        Collections.reverse(values);
        for(int i=0;i<values.size();i++)
        {
        	char key=getKeyOfValue(values.get(i),hash);
        	reverseChar=reverseChar.append(largeStr(key,values.get(i)));
        	hash.remove(key);
        }
       return reverseChar.toString();
        
    }
	char getKeyOfValue(int val,HashMap<Character,Integer> hash)
	{
		char ch='a';
		for(char key:hash.keySet())
		{
			if(hash.get(key)==val)
			{
				ch= key;
				break;
			}
		}
		return ch;
	}
	String largeStr(char c,int noOfTime)
	{
		StringBuilder str=new StringBuilder();
		for(int i=0;i<noOfTime;i++)
		{
			str=str.append(c);
		}
		return str.toString();
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SortCharByFrequency s=new SortCharByFrequency();
		System.out.println(s.frequencySort("Aabb"));
	}

}
