package Sorting;

public class MergeSort {
    static int n[];
   
	public void mergesort()
	{
	        domergeSort(0,n.length-1);
	        for(int i=0;i<n.length;i++)
	        {
	        	System.out.print(n[i]);
	        }
	      
	}
	public void domergeSort(int lowerbound, int upperbound)
	{
		if(lowerbound<upperbound)
		{
			
		int center=(lowerbound+upperbound)/2;
		//System.out.println(center);
		domergeSort(lowerbound, center);
		domergeSort(center+1, upperbound);
		merge(lowerbound,center,upperbound);
		}
		
	}
	public void merge(int start,int center,int end)
	{
		for(int i=start;i<=end;i++)
		{
			System.out.println("merge"+n[i]);
		}
		
		int tempn[]=new int[n.length];
		for(int i=0;i<n.length;i++)
		{
			tempn[i]=n[i];
		}
		int beg=start;
		int mid=center+1;
	    int k=start;
		while(beg<=center && mid<=end)
		{
			//System.out.println("hiiiii");
			if(n[beg]<=n[mid])
			{
				tempn[k]=n[beg];
				beg++;
				
			}
			else
			{
				tempn[k]=n[mid];
				mid++;
				
			}
			System.out.println("tempn[k]"+ k+" "+tempn[k]);
			k++;
		}
		if(beg<=center && mid>end)
		{
			for(int i=beg;i<=center;i++)
			{
				tempn[k]=n[i];
				System.out.println("added"+tempn[k]);
				k++;
				
			}
		}
		if(mid<=end && beg>center)
		{
			for(int i=mid;i<=end;i++)
			{
				tempn[k]=n[i];
				System.out.println("added1"+tempn[k]);
				k++;
			}
		}
		for(int i=0;i<n.length;i++)
		{
			n[i]=tempn[i];
		}
		for(int i=start;i<=end;i++)
		{
			System.out.println("merged"+n[i]);
		}
	}
	public static void main(String args[])
	{
		int k[]=new int[]{10,11,9,8,7,12,3,15,11,5};
		n=k;
		MergeSort sort=new MergeSort();
		sort.mergesort();
	}
}
