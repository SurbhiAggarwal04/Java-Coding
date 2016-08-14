package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class Entry implements Comparable<Entry>
{
	int val;
	Iterator<Integer> it;
	
	public Entry(int val,Iterator<Integer> it)
	{
		this.val=val;
		this.it=it;
	}

	@Override
	public int compareTo(Entry arg0) {
		
		if(this.val>arg0.val)return 1;
		else if(this.val<arg0.val)return -1;
		else 
		// TODO Auto-generated method stub
		return 0;
	}
	
}

public class MergeNSortedListUsingHelperClass {
	public static  List<Integer> merge(List<List<Integer>> lists)
	{
		Queue<Entry> queue=new PriorityQueue<>();
		List<Integer> result=new ArrayList<>();
		for (List<Integer> list:lists)
		{
			System.out.println(list.size());
			Iterator<Integer> it =list.iterator();
			
			if(it.hasNext())
			{
				Entry entry = new Entry(it.next(),it);
				queue.add(entry);
			}
		}
		System.out.println(queue.size());
		while(!queue.isEmpty())
		{
			Entry e=queue.poll();
			result.add(e.val);
			
			Iterator it=e.it;
			if(it.hasNext())
			{
				Entry entry=new Entry((int)it.next(),it);
				queue.add(entry);
			}
			
		}
		return result;
		
	}
public static void main(String[] args) {
	List<Integer> list1=Arrays.asList(new Integer[]{2,5,8});
	List<Integer> list2=Arrays.asList(new Integer[]{1,3,4,10,11});
	List<Integer> list3=Arrays.asList(new Integer[]{6,7,9});
	List<List<Integer>> finalList=new ArrayList<List<Integer>>();
	finalList.add(list1);
	finalList.add(list2);
	finalList.add(list3);
	List<Integer> result=merge(finalList);
	System.out.println("print");
	System.out.println(result.size());
	System.out.println(Arrays.toString(result.toArray()));
	
}
}
