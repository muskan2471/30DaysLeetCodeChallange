/*
Given an arbitrary ransom note string and another string containing letters from all the magazines,
write a function that will return true if the ransom note can be constructed from the magazines ;
otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters. 
e.g:
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/
 
import java.util.*;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine)
    {
        ArrayList<Character> arr=new ArrayList<Character>();
        for(int i=0;i<magazine.length();i++)
        {
            arr.add(magazine.charAt(i));
        }
        int flag=0;
        for(int i=0;i<ransomNote.length();i++)
        {
            if(arr.contains(ransomNote.charAt(i)))
            {
                arr.remove(arr.indexOf(ransomNote.charAt(i)));
            }
            else
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}