package ArraysAndStrings;

public class SubArrayWithMaxSum {
public static void main(String[] args) {
	//int n[]={-11,-1,-2,-3,-5,-4,-6,-10,-1,-1};
	int n[]={-2, 1, -3, 4, -1, 2, 1, -5, 4};
	find(n);
}
public static void find(int n[])
{
	int currentSum=n[0];
	int maxSum=n[0];
	int startIndex=0,endIndex=0,index=0;
	for(int i=1;i<n.length;i++)
	{
		if(currentSum+n[i]<n[i])
		{
			index=i;
			
			currentSum=n[i];
		}
		else
		{
			currentSum+=n[i];
			
		}
		if(currentSum>maxSum)
			{
			startIndex=index;
			endIndex=i;
			maxSum=currentSum;
			}
		
	}
	System.out.println(maxSum);
	System.out.println("startIndex:"+startIndex);
	System.out.println("endIndex:"+endIndex);
}
}
