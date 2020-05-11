/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
 */
public class FloddFill
{
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        int color=image[sr][sc];
        if(color!=newColor)
        {
            callMe(image,sr,sc,color,newColor);
        }
        return image;
    }
    
    void callMe(int[][] image, int sr, int sc, int color,int newColor)
    {
        if(image[sr][sc]==color)
        {
            image[sr][sc]=newColor;
            if((sc-1)>=0)//left
            {
                callMe(image,sr,sc-1,color,newColor);
            }
            if((sc+1)<image[0].length)//right
            {
                callMe(image,sr,sc+1,color,newColor);
            }
            if((sr-1)>=0)//up
            {
                callMe(image,sr-1,sc,color,newColor);
            }
            if((sr+1)<image.length)//down
            {
                callMe(image,sr+1,sc,color,newColor);
            }
        }
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		FloddFill f=new FloddFill();
		int image[][]= {{1,1,1},{1,1,0},{1,0,1}};
		image=f.floodFill(image,1,1,2);
		for(int i=0;i<image.length;i++)
		{
			for(int j=0;j<image[i].length;j++)
			{
				System.out.print(image[i][j]+" ");
			}
			System.out.println();
		}

	}

}
