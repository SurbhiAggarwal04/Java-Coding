package ArraysAndStrings;

import java.util.Arrays;
import java.util.Hashtable;

public class PairWithGivenDifference {
public static void main(String[] args) {
	//int n[]=new int[]{5,20,3,2,50,80};
	//int n[]=new int[]{90, 70, 20, 80, 50};
	int n[]=new int[]{-1,-2,-3,-4,-5,-6,-7};
	int diff=4;
	Hashtable<Integer,Integer> table=new Hashtable<>();
	for(int i=0;i<n.length;i++)
	{
		int diff1=n[i]-diff;
		int diff2=diff+n[i];
		table.put(n[i], 0);
		//System.out.println("answer");
		if(table.containsKey(diff1))
		{
			System.out.println(n[i]+" "+diff1);
		}
		if(table.containsKey(diff2))System.out.println(n[i]+" "+diff2);
	}
	System.out.println("--------------");
	Arrays.sort(n);
	/*for(int i=0;i<n.length;i++)
	{
		System.out.println(n[i]);
	}*/
	int i=0;
	int j=1;
	while(i<n.length && j<n.length)
	{
		if(n[j]-n[i]==diff)
		{
			System.out.println(n[j]+" "+n[i]);
			j++;
			//break;
		}
		else if(n[j]-n[i]<diff)j++;
		else i++;
	}
}
}
