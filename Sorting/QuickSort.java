package Sorting;

public class QuickSort {
	static int n[];

	public void quicksort(int lowerbound, int upperbound) {
		if (lowerbound < upperbound) {
			System.out.println(lowerbound + " , " + upperbound);
			int pivot = n[lowerbound];
			int i = lowerbound + 1;
			int j = upperbound;
			while (i <= j) {
				while (n[i] <= pivot)
					i++;
				while (n[j] > pivot)
					j--;

				if (i < j) {
					int temp = n[i];
					n[i] = n[j];
					n[j] = temp;
					i++;
					j--;
				}

			}

			n[lowerbound] = n[j];
			n[j] = pivot;
			for (int h = 0; h < n.length; h++) {
				System.out.print(n[h]);
			}
			System.out.println();
			// if(j>=lowerbound && j<=upperbound)
			// {
			quicksort(lowerbound, j - 1);

			quicksort(j + 1, upperbound);
			// }

		}
	}

	public static void main(String[] args) {
		int k[] = new int[] { 10, 2, 5, 3, 11, 4, 13, 15, 6, 3, 4, 20 };
		n = k;
		QuickSort quick = new QuickSort();
		quick.quicksort(0, n.length - 1);

		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]);
		}

	}
}
