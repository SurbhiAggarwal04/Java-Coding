package ArraysAndStrings;

import java.util.Arrays;
//QuickSelect is a better approach
public class KthSmallestElementUsingArray {
public static void main(String[] args) {
	int n[]=new int[]{15,3,0,2,4,11,0,25,2,3,21,4,35,6,7,10,15};
    //[0, 0, 2, 2, 3, 3, 4, 4, 6, 7,10, 11, 15,15, 21, 25, 35]
	int k=3;
	/*System.out.println(n.length);
	Arrays.sort(n);
	System.out.println(Arrays.toString(n));
	
	System.out.println(n[7]);*/
	smallestElement(n,0,n.length-1, k);
	System.out.println("main:"+Arrays.toString(n));
	//System.out.println(smallestElement(n,k));
}
public static void smallestElement(int []n,int start,int end,int k)
{
	int length=end;
	int medPosition=0;
	while(length>0)
	{
		medPosition=recursiveSort(n,start,length);
		System.out.println("retruned:"+medPosition);
		System.out.println("after sort:"+Arrays.toString(n));
		length=length/5;
	}
	int position=partition(n,medPosition);
	System.out.println("position:"+position);
	System.out.println("after partioning:"+Arrays.toString(n));
	if(k-1==position)System.out.println("found:"+n[k-1]);
	else if(k-1<position)smallestElement(n, 0, position-1, k);
	else smallestElement(n, position+1, n.length-1, k);
	
}
public static int partition(int n[],int position)
{
	int temp=n[0];
	n[0]=n[position];
	n[position]=temp;
	int pivot=n[0];
	System.out.println("inside partition:"+Arrays.toString(n));
	int i=1;
	int j=n.length-1;
	while(i<j)
	{
		while(n[i]<=pivot)i++;
		while(n[j]>pivot)j--;
		if(i<=j)
		{
			temp=n[i];
			n[i]=n[j];
			n[j]=temp;
			i++;
			j--;
		}
	}
	n[0]=n[j];
	n[j]=pivot;
	return j;
	
}
public static int recursiveSort(int []n,int start,int end)
{
	System.out.println("end:"+end);
	if(end-start+1<=5)
	{
		Arrays.sort(n,start,end+1);
		int med=(end-start+1)/2;
		System.out.println("med:"+n[start+med]);
		return start+med;
	}
	int i=1;
	int l=start;
	int r=start+4;
	while(r<end)
	{
		//if(r>end)r=end;
	
		System.out.println("new");
		System.out.println("l:"+l+" r:"+r);
		int medPosition=recursiveSort(n, l, r);
		int temp=n[i];
		n[i]=n[medPosition];
		n[medPosition]=temp;
		l=r+1;
		r=l+4;
	}
	return i-1;
}
}
