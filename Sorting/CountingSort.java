package Sorting;

import java.util.Arrays;
/*
 * Time complexity O(n)
 * Space complexity O(n)
 * Works well if the input is from a fixed set and min and  max are known otherwise extra computation
 * to determine min and max and space is wasted if the matrix is too sparse.
 */
public class CountingSort {
public static void main(String[] args) {
	int array[]=new int[]{5,3,0,2,4,1,0,5,2,3,1,4,5,6};
	int min=0;
	int max=6;
	int count[]=new int[max-min+1];
	int aux[]=new int[array.length];
	Arrays.fill(count, 0);
	
	for(int i=0;i<array.length;i++)
	{
		count[array[i]-min]++;
	}
	int z=0;
	for(int i=min;i<=max;i++)
	{
		while(count[i-min]>0)
		{
			aux[z]=i;
			z++;
			count[i-min]--;
		}
	}
	System.out.println(Arrays.toString(aux));
}
}
