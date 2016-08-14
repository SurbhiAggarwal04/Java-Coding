package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestKIntegersInAnArray {
	public static List<Integer> smallestKIntegers()
	{
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> arrayList=Arrays.asList(new Integer[]{5,6,100,1,7,102,103,106,0});
		Iterator<Integer> stream=arrayList.iterator();
		int k=2;
		Queue<Integer> minHeap = new PriorityQueue<Integer>(k);
 
		while(stream.hasNext())
		{
			minHeap.add(stream.next());
			System.out.println(minHeap);
		}
 
		for(int i = 0; i < k; i++)
		{
			if(minHeap.isEmpty())
			{
				break;
			}
 
			list.add(minHeap.poll());
		}
 
		return list;
	}
	public static void main(String[] args) {
		System.out.println(smallestKIntegers());
	}
}
