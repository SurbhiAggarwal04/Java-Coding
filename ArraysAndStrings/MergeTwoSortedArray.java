package ArraysAndStrings;

import java.util.Arrays;

public class MergeTwoSortedArray {
public static void main(String[] args) {
	int n1[]={0,21,32,44,55,76,0,0,0,0,0};
	int n2[]={21,22,23,24,54};
	merge(n1,n2);
}
public static void merge(int[] n1,int []n2)
{
	int i=n1.length-n2.length-1;
	int j=n2.length-1;
	int index=n1.length-1;
	while(i>=0 && j>=0)
	{
		if(n1[i]>=n2[j])
		{
			n1[index]=n1[i];
			i--;
		}
		else
		{
			n1[index]=n2[j];
			j--;
		}
		index--;
	}
	if(i<0 && j>=0)
	{
		while(j>=0)
		{
			n1[index]=n2[j];
			j--;
			index--;
		}
	}
	/*if(i>=0 && j<0)
	{
		while(i>=0)
		{
			n1[index]=n1[i];
			i--;
			index--;
		}
	}*/
	System.out.println(Arrays.toString(n1));
}
}
