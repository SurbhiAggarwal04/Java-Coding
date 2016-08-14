package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Point
{
	public int x;
	public int y;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
public class DuplicatesWithinKindicesInA2dMatrix {
	
 
	public static boolean containsDuplicates(int[][] array, int k)
	{
		Map<Integer, List<Point>> map = new HashMap<Integer, List<Point>>();
 
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				List<Point> list = map.get(array[i][j]);
				Point p = new Point(i, j);
 
				if(list == null)
				{
					list = new ArrayList<Point>();
					map.put(array[i][j], list);
				}
				else
				{
					for(Point point : list)
						if(Math.abs(point.x-i) <= k && Math.abs(point.y-j) <= k)
							return true;
				}
 
				list.add(p);
			}
		}
 
		return false;
	}

}
