package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubSequenceInOrder {
public static void main(String[] args) {
	int n[]={10,11,12,13,5,4,14,15,3,16,17,18,1,2,3,4,5,6,7,20,21};
	//int n[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
	System.out.println("Version 1");
	/*
	 * Complexity O(n^2)
	 */
	//findVersion1(n);
	System.out.println("Version 2");
	/*
	 * Complexity O(n^2)
	 */
	//findVersion2(n);
	/*
	 * Complexity O(nLogn)
	 */
	System.out.println("Version 3");
	findVersion3(n);
}
public static int findLargestSmallerThanCurrent(int[] endElements, int start, int end,int k)
{
	while(start<end)
	{
		int m=(start+end)/2;
		if(k>=endElements[m])start=m+1;
		else end=m;
	}
	return end;
}
public static void findVersion3(int n[])
{
	int endElements[]=new int[n.length];
	endElements[0]=n[0];
	int length=1;
	for(int i=1;i<n.length;i++)
	{
		if(n[i]<endElements[0])
		endElements[0]=n[i];
		else if(n[i]>endElements[length-1])
			endElements[length++]=n[i];
		else
		{
			endElements[findLargestSmallerThanCurrent(endElements,0,length-1,n[i])]=n[i];
			
		}
		System.out.println(Arrays.toString(endElements));
		
	}
	System.out.println(length);
}
public static void findVersion1(int n[])
{
	int max=0;
	int[] result=new int[n.length];
	int maxValue=0;
	Arrays.fill(result, 1);
	for(int i=1;i<n.length;i++)
	{
		for(int j=0;j<i;j++)
		{
			if(n[j]<=n[i] && result[i]<result[j]+1)
			{
				result[i]=result[j]+1;
			}
		}
	}
	System.out.println(Arrays.toString(result));
	for(int i=0;i<result.length;i++)
	{
		if(result[i]>max)
			{
			max=result[i];
			maxValue=n[i];
			}
	}
	System.out.println(max);
	
}
public static void findVersion2(int n[])
{
	ArrayList<Integer> []result=new ArrayList[n.length];
	for(int i=0;i<n.length;i++)
	{
		ArrayList<Integer> localResult=new ArrayList<Integer>();
		for(int j=0;j<i;j++)
		{
			if(n[i]>n[j] && result[j].size()>localResult.size())
			{
				localResult.clear();
				localResult.addAll(result[j]);
			}
		}
		localResult.add(n[i]);
		result[i]=localResult;
	}
	System.out.println(Arrays.toString(result));
}

}
