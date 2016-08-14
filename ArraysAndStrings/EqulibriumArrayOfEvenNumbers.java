package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqulibriumArrayOfEvenNumbers {
	public static List<List<Integer>> makeLists(int [] list)
	{
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
 
		List<Integer> list1 = new ArrayList<Integer>();
		int list1Total = 0;
 
		List<Integer> list2 = new ArrayList<Integer>();
		int list2Total = 0;
 
		Arrays.sort(list);
 
		for(int i = list.length -1; i >= 0; i--)
		{
			if(list1Total < list2Total && list1.size() < list.length/2)
			{
				list1.add(new Integer(list[i]));
				list1Total+=list[i];
			}
			else
			{
				list2.add(new Integer(list[i]));
				list2Total+=list[i];
			}
		}
 
		lists.add(list1);
		lists.add(list2);
 
		return lists;
	}
	public static void main(String[] args) {
		System.out.println(makeLists(new int[]{1000,500,200,1,5,10,50,70,70,100}));
	}

}
