/*
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
import java.util.*;
public class CourseSchedule
{
	boolean canFinish(int numCourses, int[][] prerequisites)
    {
        if(numCourses == 0 || prerequisites.length== 0)
        {
            return true;
        }
        
        HashMap<Integer,ArrayList<Integer>> hash=new HashMap<Integer,ArrayList<Integer>>();
        int visited[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++)
        {
            if(hash.containsKey(prerequisites[i][1]))
            {
                ArrayList<Integer> ls=hash.get(prerequisites[i][1]);
                ls.add(prerequisites[i][0]);
                hash.replace(prerequisites[i][1],ls);
                
            }
            else
            {
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(prerequisites[i][0]);
                hash.put(prerequisites[i][1],temp);
            }
            
        }
        
        for(int i=0;i<numCourses;i++)
        {
        	if(!canFinishDFS(hash,visited,i))
        	{
        		return false;
        	}
        }
        
        return true;
    }
	boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>>map, int[] visit, int i)
	{
		if(visit[i]==-1) 
            return false;
        if(visit[i]==1) 
            return true;
        visit[i]=-1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(!canFinishDFS(map, visit, j)) 
                    return false;
            }
        }
        visit[i]=1;
 
        return true;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		CourseSchedule c=new CourseSchedule();
		int ar[][]= {{1,0}};
		int N=2;
		System.out.println(c.canFinish(N, ar));

	}

}
