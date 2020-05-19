/*
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger
than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/
import java.util.*;
public class AllAnagramInString
{
	public List<Integer> findAnagrams(String s, String p) 
    {
        List<Integer> list=new ArrayList<Integer>();
        char P[]=p.toCharArray();
        Arrays.sort(P);
        String need=String.valueOf(P);
        for(int i=0;i<=(s.length()-need.length());i++)
        {
            String sub=s.substring(i,(i+need.length()));
            P=sub.toCharArray();
            Arrays.sort(P);
            String SortedStr=String.valueOf(P);
            if(SortedStr.equals(need))
            {
                list.add(i);
            }
        }
        return list;
    }
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		AllAnagramInString a=new AllAnagramInString();
		System.out.println(a.findAnagrams("cbaebabacd","abc"));

	}

}
