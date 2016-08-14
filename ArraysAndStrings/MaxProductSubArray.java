package ArraysAndStrings;

public class MaxProductSubArray {
public static void main(String[] args) {
	int n[]={-1, -2, -1, 1, 7, -8, -2};
	find(n);
}
public static int find(int[] n)
{
	int max=1;
	int min=1;
	int finalMax=1;
	int i=0;
	while(i<n.length)
	{
		if(n[i]>0)
		{
			max=Math.max(max*n[i], max);
			min=Math.min(min*n[i], min);
		}
		else if(n[i]==0)
		{
			max=1;
			min=1;
		}
		else
		{
			int temp=max;
			max=Math.max(min*n[i], max);
			min=Math.min(temp*n[i], min);
		}
		if(finalMax<max)finalMax=max;
		i++;
	}
	System.out.println("final value:"+finalMax);
	return finalMax;
}
}
