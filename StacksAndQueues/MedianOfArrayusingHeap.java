package StacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfArrayusingHeap implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1 - o2;

	}
	public static Double median(Integer[] array)
	{
		ArrayList<Integer> list=(ArrayList<Integer>) Arrays.asList(array);
	
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(20,Collections.reverseOrder());
 
		int numOfElements = 0;
        Iterator<Integer> iterator=list.iterator();
		while(iterator.hasNext())
		{	
			maxHeap.add(iterator.next());
 
			if(numOfElements % 2 == 0)
			{
				if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())
				{
					Integer maxHeapRoot = maxHeap.poll();
					Integer minHeapRoot = minHeap.poll();
					maxHeap.add(minHeapRoot);
					minHeap.add(maxHeapRoot);
				}
			}
			else
			{
				minHeap.add(maxHeap.poll());
			}
 
			numOfElements++;
		}
 
		if (numOfElements%2 != 0)
			return  maxHeap.peek().doubleValue();
 
		return (maxHeap.peek() + minHeap.peek()) /2.0;
	}

	public static void main(String[] args) {
		int[] inputArray = new int[] { 1, 9, 2, 0, 5, 6 ,11};
		Queue<Integer> minHeap = new PriorityQueue<>(
				new MedianOfArrayusingHeap());
		Queue<Integer> maxHeap = new PriorityQueue<>(
				Collections.reverseOrder(new MedianOfArrayusingHeap()));
		for (int i = 0; i < inputArray.length; i++) {
			if (maxHeap.size() == 0) {
				maxHeap.add(inputArray[i]);
			} else {

				if (inputArray[i] <= maxHeap.peek()) {
					if (maxHeap.size() > minHeap.size()) {
						minHeap.add(maxHeap.remove());
					}
					maxHeap.add(inputArray[i]);
				}

				else {
					if (minHeap.size() == 0)
						minHeap.add(inputArray[i]);
					else {
						if (inputArray[i] <= minHeap.peek()) {
							if (maxHeap.size() > minHeap.size()) {
								minHeap.add(maxHeap.remove());

							}
							maxHeap.add(inputArray[i]);

						} else {
							if (minHeap.size() == maxHeap.size()) {
								maxHeap.add(minHeap.remove());
							}
							minHeap.add(inputArray[i]);
						}

					}
				}

			}
		}
		System.out.println("maxHeap");
		Iterator<Integer> it=maxHeap.iterator();
		while(it.hasNext())System.out.println(it.next());
		System.out.println("minheap");
		it=minHeap.iterator();
		while(it.hasNext())System.out.println(it.next());
		
		if(maxHeap.size()==minHeap.size())System.out.println("median "+(double)(maxHeap.remove()+minHeap.remove())/2);
		else System.out.println("median "+maxHeap.remove());

	}
}
