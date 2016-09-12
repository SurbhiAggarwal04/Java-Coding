package Sorting;

public class SelectionSort {
int[] n;
public SelectionSort(int []n) {
	// TODO Auto-generated constructor stub
this.n=n;
}
public int[] sort()
{
	for(int i=0;i<n.length-1;i++)
	{
		for(int j=i+1;j<n.length;j++)
		{
			if(n[i]>n[j])
			{
				int temp=n[j];
				n[j]=n[i];
				n[i]=temp;
			}
		}
	}
	return n;
}
}
