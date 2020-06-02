import java.util.*;
public class PossibleBiparition
{
	List<List<Integer>> graph=new ArrayList<>();
	HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
	public boolean possibleBipartition(int N, int[][] dislikes) 
    {
        for(int i=1;i<=N+1;i++)
        {
        	graph.add(new ArrayList());
        	
        }
        
        for(int i=0;i<dislikes.length;i++)
        {
        	graph.get(dislikes[i][0]).add(dislikes[i][1]);
        	graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        
        for(int node=1;node<=N;node++)
        {
        	if(!hash.containsKey(node) && !dfs(node,0))
        	{
        		return false;
        	}
        }
        return true;

    
    }
	
	boolean dfs(int node,int color)
	{
		if(this.hash.containsKey(node))
		{
			return (this.hash.get(node)==color);
		}
		
		hash.put(node,color);
		
		for(int neighbour:graph.get(node))
		{
			if(!dfs(neighbour,color^1))
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		PossibleBiparition p=new PossibleBiparition();
		
		int N=10;
		int dislikes[][]= {
				{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}
		};
		System.out.println(p.possibleBipartition(N, dislikes));
		

	}

}
