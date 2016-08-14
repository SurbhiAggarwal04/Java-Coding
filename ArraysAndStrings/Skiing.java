package ArraysAndStrings;

public class Skiing {
	public static void main(String[] args)
	{
		int[][] mountain = new int[][] {{0,0,0,0,0,0,0,0},
				                {0,0,0,1,0,0,0,0},
				                {0,1,0,0,0,1,1,1},
				                {0,1,1,0,0,0,0,0},
				                {0,0,0,0,1,1,0,1},
				                {0,0,1,0,1,0,0,0},
				                {0,0,0,0,1,0,0,0}};
 
		System.out.println(pathExists(mountain,0,0));
	}
 
	public static boolean pathExists(int [][] array, int x, int y)
	{
		if(x == array.length || y ==array[x].length || array[x][y]==1)
			return false;
 
		if(x == array.length -1 && y == array[x].length -1)
			return true;
 
		return pathExists(array,x+1,y) || pathExists(array,x,y+1);
	}

}
