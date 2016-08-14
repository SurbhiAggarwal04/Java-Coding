package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeNSortedLists {
	public static List<Integer> mergeLists(List<List<Integer>> lists)
	{
		if(lists.size() == 1)
			return lists.get(0);
 
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		List<List<Integer>> list2 = new ArrayList<List<Integer>>();
 
		for(int i = 0; i < lists.size()/2; i++)
			list1.add(lists.get(i));
 
		for(int i = lists.size()/2; i < lists.size(); i++)
			list2.add(lists.get(i));
 
		List<Integer> mergedList1 = mergeLists(list1);
		List<Integer> mergedList2 = mergeLists(list2);
 
		List<Integer> mergedOutput = new ArrayList<Integer>();
 
		int index1 = 0;
		int index2 = 0;
 
		while(index1 < mergedList1.size() && index2 < mergedList2.size())
			if(mergedList1.get(index1)<mergedList2.get(index2))
				mergedOutput.add(mergedList1.get(index1++));
			else
				mergedOutput.add(mergedList2.get(index2++));
 
		while(index1 < mergedList1.size())
			mergedOutput.add(mergedList1.get(index1++));
 
		while(index2 < mergedList2.size())
			mergedOutput.add(mergedList2.get(index2++));
 
		return mergedOutput;
	}
	public static void main(String[] args) {
		List<Integer> list1=Arrays.asList(new Integer[]{2,5,8});
		List<Integer> list2=Arrays.asList(new Integer[]{1,3,4,10,11});
		List<Integer> list3=Arrays.asList(new Integer[]{6,7,9});
		List<List<Integer>> finalList=new ArrayList<List<Integer>>();
		finalList.add(list1);
		finalList.add(list2);
		finalList.add(list3);
		List<Integer> result=mergeLists(finalList);
		System.out.println("print");
		System.out.println(result.size());
		System.out.println(Arrays.toString(result.toArray()));
		
	}
}
