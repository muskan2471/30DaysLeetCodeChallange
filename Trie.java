/*
 =====================Refer for more info :https://medium.com/@saurav.agg19/implement-trie-prefix-tree-692560ea448a========================
Implement a trie with insert, search, and startsWith methods.

Example:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
class TrieNode
{

    // R links to node children
     TrieNode[] links;
     boolean isEnd;

    TrieNode() 
    {
        links = new TrieNode[26];
    }
    
}
class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    Trie()
    {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word)
    {
        TrieNode current=root;
        for(int i=0;i<word.length();i++)
        {
            if(current.links[word.charAt(i)-'a']==null)
            {
                current.links[word.charAt(i)-'a']=new TrieNode();
                current=current.links[word.charAt(i)-'a'];
            }
            else
            {
                current=current.links[word.charAt(i)-'a'];
            }
        }
        current.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode current=root;
        int flag=0;
        for(int i=0;i<word.length();i++)
        {
            if(current.links[word.charAt(i)-'a']==null)
            {
               flag=1;
                break;
            }
            else
            {
                current=current.links[word.charAt(i)-'a'];
            }
        }
        if(flag==0)
        {
            if(current!=null && current.isEnd==true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
        
    }
   
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix)
    {
        TrieNode current=root;
        int flag=0;
        int i=0;
        for(i=0;i<prefix.length();i++)
        {
            if(current.links[prefix.charAt(i)-'a']==null)
            {
                flag=1;
                break;
            }
            else
            {
                current=current.links[prefix.charAt(i)-'a'];
            }
        }
        if(flag==1)
        {
            return false;
        }
        else
        {
            if(current!=null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
    }
    public static void main(String args[])
    {
    	Trie t=new Trie();
    	t.insert("apple");
    	System.out.println(t.search("apple"));
    	System.out.println(t.search("app"));
    	System.out.println(t.startsWith("app"));
    }
}

