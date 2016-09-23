package Sorting;
/*
 * Comlexity:
 * Best Case O(n)
 * Average and Worst O(n^2)
 */
public class InsertionSort {

	int n[];
	public InsertionSort(int n[]) {
		// TODO Auto-generated constructor stub
		this.n=n;
	}
	int[] sort()
	{
		for(int i=1;i<n.length;i++)
		{ 
			int t=n[i];
			int j=i-1;
			/*while(j>=0 && t<=n[j])
			{
				n[j+1]=n[j];
				
				j--;
			}*/
			while(j>=0)
			{
				if(t<=n[j])
				{
					n[j+1]=n[j];
					j--;
				}
				else
				break;
			}
			n[j+1]=t;
		}
		return n;
	}
}
