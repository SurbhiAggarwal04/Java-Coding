package StacksAndQueues;

public class ManualMaxHeapAndminHeap {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		buildHeap(arr);
		System.out.println("Heap");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		arr = new int[] { 90, 15, 10, 7, 12, 2 };
		System.out.println("is array heap");
		System.out.println(isHeap(arr));

		System.out.println("kth largest element in a stream");
		arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 5;
		int heapArr[] = new int[k];
		for(int i=0;i<k;i++)
		{
			heapArr[i]=arr[i];
		}
		for (int i = (heapArr.length - 1-1) / 2; i >= 0; i--) {
			percolateDownMinHeap(heapArr, i);
		}
		for (int i = k; i < arr.length; i++) {
			buildHeap(heapArr, arr[i]);
		}
        System.out.println("kth largest element "+heapArr[0]);
	}

	public static void buildHeap(int[] heapArr, int val) {
		if(val>heapArr[0])
		{
			heapArr[0]=val;
			for (int i = (heapArr.length - 1-1) / 2; i >= 0; i--) {
				percolateDownMinHeap(heapArr, i);
			}
		}
		System.out.println("heap array");
		for (int i = 0; i < heapArr.length; i++) {
			System.out.println(heapArr[i]);
		}
	}

	public static boolean isHeap(int[] arr) {

		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			int l = 2 * i + 1;
			int r = 2 * i + 2;
			if (l < arr.length - 1 && arr[i] < arr[l])
				return false;
			if (r < arr.length - 1 && arr[i] < arr[r])
				return false;
		}
		return true;
	}

	public static void buildHeap(int[] arr) {
		if (arr == null)
			return;
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			percolateDown(arr, i);
		}
	}

	public static void percolateDown(int[] arr, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int max = i;
		if (l < arr.length && arr[l] > arr[max])
			max = l;
		if (r < arr.length && arr[r] > arr[max])
			max = r;
		if (max != i) {
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			percolateDown(arr, max);
		}

	}

	public static void percolateDownMinHeap(int[] arr, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int min = i;
		if (l < arr.length && arr[l] < arr[min])
			min = l;
		if (r < arr.length && arr[r] < arr[min])
			min = r;
		if (min != i) {
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			percolateDown(arr, min);
		}

	}
}
