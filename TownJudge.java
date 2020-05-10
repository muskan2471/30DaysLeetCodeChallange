/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 */
import java.util.*;
public class TownJudge 
{
	public int findJudge(int N, int[][] trust)
    {
        if(trust.length==0)
        {
            return 1;
        }
        else if(trust.length==1)
        {
            return trust[0][1];
        }
        else
        {
            ArrayList<Integer> either=new ArrayList<Integer>();
            ArrayList<Integer> judge=new ArrayList<Integer>();
            HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
            for(int i=0;i<trust.length;i++)
            {
                if(!either.contains(trust[i][0]))
                {
                    either.add(trust[i][0]);
                }
                if(!hash.containsKey(trust[i][1]))
                {
                    hash.put(trust[i][1],1);
                }
                else
                {
                    hash.replace(trust[i][1],hash.get(trust[i][1])+1);
                    judge.add(trust[i][1]);
                }


            }

            for(int i=0;i<judge.size();i++)
            {
                int val=judge.get(i);
                if(!either.contains(val) && hash.get(val)==N-1)
                {
                    return val;
                }
            }
            return -1;

        }
        
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		TownJudge j=new TownJudge();
		int trust[][]= {{1,3},{1,4},{2,3},{2,4},{4,3}};
		int N=4;
		System.out.println(j.findJudge(N,trust));

	}

}
