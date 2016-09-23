package Sorting;

public class QuickSortNew {
	static int n[];
	public void quicksort(int lowerbound, int upperbound)
	{
		if(lowerbound>upperbound)return;
		int p=partition(lowerbound,upperbound);
		quicksort(lowerbound, p-1);
		quicksort(p+1, upperbound);
		
		
	}
	
	public int partition(int lowerbound,int upperbound)
	{
		int pivot=n[lowerbound];
		int i=lowerbound+1;
		int j=upperbound;
		while(i<=j)
		{
		while(n[i]<=pivot)i++;
		while(n[j]>pivot)j--;
		
		if(i<j)
		{
			int temp=n[i];
			n[i]=n[j];
			n[j]=temp;
			i++;
			j--;
		   
		}
		
		}
		
	   
		n[lowerbound]=n[j];
		n[j]=pivot;
		
		return j;
	}
public static void main(String[] args) {
	int k[]=new int[]{10,2,5,3,11,4,13,15,6,3,4,20};
	n=k;
	QuickSortNew quick=new QuickSortNew();
	quick.quicksort(0, n.length-1);
	
	for (int i=0;i<n.length;i++)
	{
		System.out.print(n[i]);
	}
	
}
}
