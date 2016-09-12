package Sorting;

import java.util.Arrays;

/*
 * Maxheap
 */
public class HeapSort {
	static int arr[]={10,1,3,7,12,-1,2,50,0};
	static int n=arr.length;
public static void main(String[] args) {
	sort();
	System.out.println(Arrays.toString(arr));
}
public static void sort()
{
	heapify();
	System.out.println(Arrays.toString(arr));
	heapSort();
}
public static void heapSort()
{
	
	for(int i=n-1;i>0;i--)
	{
		int t=arr[0];
		arr[0]=arr[i];
		arr[i]=t;
		System.out.println("arr[0] & arr[i] "+arr[0]+" "+i+" "+arr[i]);
		n=n-1;
		
		heapifyUp(0);
		System.out.println(Arrays.toString(arr));
	}
}
public static void heapify()
{
	for(int i=(arr.length-1)/2;i>=0;i--)
	{
		heapifyUp(i);
	}
}
public static void heapifyUp(int i)
{
	if(i<n)
	{
		int max=arr[i];
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		if(l<n && arr[l]>max)
		{
			largest=l;
			max=arr[l];
		}
		if(r<n && arr[r]>max)
		{
			largest=r;
			max=arr[r];
		}
		if(largest!=i)
		{
			int temp=arr[i];
			arr[i]=max;
			arr[largest]=temp;
			heapifyUp(largest);
		}
	}
}
}
