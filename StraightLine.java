/*
 You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 */
public class StraightLine
{
	float slope(int p1[],int p2[])
	{
		
		if ((p1[0] - p2[0]) == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

	
	
	public static void main(String args[])
	{
		StraightLine s=new StraightLine();
		int coordinates[][]= {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
		
		int flag=0;
		float slopeFirst=s.slope(coordinates[1],coordinates[0]);
		
		for(int i=1;i<coordinates.length;i++)
		{
			int p1[]=coordinates[i];
			int p2[]=coordinates[0];
			float tempSlope=s.slope(p1,p2);
			if(tempSlope!=slopeFirst)
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		
	}
}
