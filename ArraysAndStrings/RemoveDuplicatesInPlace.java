package ArraysAndStrings;

import java.util.Arrays;

public class RemoveDuplicatesInPlace {
public static void main(String[] args) {
	int n[]=new int[]{1,1,1,2,3,3,3,4,4,5,6,6,6,6,6};
	//1,
	int index=removeDuplicates(n);
	
	for(int i=0;i<index;i++)
	{
		System.out.print(n[i]+" ");
	}
}
public static int removeDuplicates(int[] n)
{
	int value=n[0];
	int index=1;
	for(int i=1;i<n.length;i++)
	{
		if(n[i]!=value)
		{
			n[index]=n[i];
			index++;
			value=n[i];
		}
	}
	System.out.println(Arrays.toString(n));
	System.out.println(index);
	return index;
}
}
