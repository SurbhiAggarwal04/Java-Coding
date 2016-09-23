package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
 * The asymptotic complexity of bucket sort is O(m * C(n/m)), where n is size of the input array, m is 
 * the number of buckets and C(x) is the complexity of the inner sorting algorithm.
 * 
 * Bucket sort can be used for distributed sorting – each bucket can be ordered by a different thread 
 * or even by a different computer. Another use case is a sorting of huge input data, which cannot be 
 * loaded into the main memory by an ordinary O(n\\cdot \\log(n)) algorithm. This problem can be solved 
 * by dividing the data into sufficiently small buckets, sorting them one by one by appropriate 
 * algorithm, while storing rest of the data in the external memory (e.g. hard drive).
 */
public class BucketSort {
	public static void main(String[] args) {
		int n[]=new int[]{15,3,0,2,4,11,0,25,2,3,21,4,35,6};
		sort(n,5);
		System.out.println(Arrays.toString(n));
	}
	public static void sort(int[] array,int bucketCount)
	{
		if (bucketCount <= 0) throw new IllegalArgumentException("Invalid bucket count");
		if (array.length <= 1) return; //trivially sorted
		int high = array[0];
		int low = array[0];
		for (int i = 1; i < array.length; i++) { //find the range of input elements
		if (array[i] > high) high = array[i];		
		if (array[i] < low) low = array[i];
		}
		double interval = ((double)(high - low + 1))/bucketCount; //range of one bucket

		ArrayList<Integer> buckets[] = new ArrayList[bucketCount];
	
		for (int i = 0; i < bucketCount; i++) { //initialize buckets
		buckets[i] = new ArrayList();
		}

		for (int i = 0; i < array.length; i++) { //partition the input array
	
		buckets[(int)((array[i] - low)/interval)].add(array[i]);
		
		}
	
		 
		
		int pointer = 0;
	
		for (int i = 0; i < buckets.length; i++) {
		
		Collections.sort(buckets[i]); //mergeSort
		
		for (int j = 0; j < buckets[i].size(); j++) { //merge the buckets
		
		array[pointer] = buckets[i].get(j);
		
		pointer++;
		
		}
		
		}
	}
}
