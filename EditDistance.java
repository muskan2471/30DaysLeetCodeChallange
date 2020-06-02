/*
 Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')


Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistance 
{
	int min(int x, int y, int z) 
    { 
        if (x <= y && x <= z) 
            return x; 
        if (y <= x && y <= z) 
            return y; 
        else
            return z; 
    } 
    public int minDistance(String word1, String word2) 
    {
        return (editDist(word1,word2,word1.length(),word2.length()));
    }
    int editDist(String word1, String word2,int m,int n)
    {
        // If first string is empty, the only option is to 
        // insert all characters of second string into first 
        if(m==0)
        {
            return n;
        }
        // If second string is empty, the only option is to 
        // remove all characters of first string 
        if(n==0)
        {
            return m;
        }
        
        // If last characters of two strings are same, nothing 
        // much to do. Ignore last characters and get count for 
        // remaining strings. 
        if(word1.charAt(m-1)==word2.charAt(n-1))
        {
            return(editDist(word1,word2,m-1,n-1));
        }
        
        // If last characters are not same, consider all three 
        // operations on last character of first string, recursively 
        // compute minimum cost for all three operations and take 
        // minimum of three values. 
        return 1+min(editDist(word1,word2,m,n-1),   //insert
                    editDist(word1,word2,m-1,n),	//remove
                    editDist(word1,word2,m-1,n-1));   //replace
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		EditDistance e=new EditDistance();
		System.out.print(e.minDistance("horse","ros"));
	}

}
