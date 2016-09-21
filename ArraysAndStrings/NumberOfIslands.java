package ArraysAndStrings;

import java.util.Arrays;

public class NumberOfIslands {
	public static void main(String[] args)
	{
		int[][] map = new int[][] {{0,0,0,0,0,0,1,0},
                		           {0,0,1,1,0,0,1,0},
                                   {0,0,0,0,0,1,1,1},
                                           {1,1,1,0,0,0,0,0},
                                           {0,1,1,0,1,1,0,1},
                                           {0,0,0,0,1,0,0,1},
                                           {0,1,0,0,1,0,0,0}};
		
		System.out.println(numberOfIslands(map));
	}
 
	public static int numberOfIslands(int [][] map)
	{
		int number = 0;
 
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				if(map[i][j] == 1)
				{
					number++;
					turnToZero(map, i, j);
					for(int k=0;k<map.length;k++)
					System.out.println(Arrays.toString(map[k]));
					System.out.println("new");
				}
			}
		}
 
		return number;
	}
 
	public static void turnToZero(int [][] map, int x, int y)
	{
		if(x >= map.length || x < 0 || y >= map[x].length || y < 0 || map[x][y] == 0)
			return;
 
		map[x][y] = 0;
		turnToZero(map, x+1, y);
		turnToZero(map, x, y+1);
		turnToZero(map, x-1, y);
		turnToZero(map, x, y-1);
	}

}
