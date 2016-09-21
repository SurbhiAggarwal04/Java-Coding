package ArraysAndStrings;

public class ContinuousSubArrayWithGivenSum {
public static void main(String[] args) {
	int n[]={3,4,1,2,11,10,1,2,7,8};
	int i=0;
	int sum=13;
	int currentSum=0;
	int length=0;
	//int currentLength=0;
	int start=0;
	while(i<n.length)
	{
		
		System.out.println("n[i]:"+n[i]);
		currentSum+=n[i];
	  if(currentSum>sum)
			{
			while(currentSum>sum && start<i)
			{
				currentSum-=n[start];
				start++;
			}
			System.out.println("greater:"+currentSum);
			}
	  if(currentSum==sum)
		{
			System.out.println("found");
			if(i-start+1>length)length=i-start+1;
		
		}
	
		
	
		
	  System.out.println("currentSum:"+currentSum);
		i++;
			
	}
	System.out.println(length);
	System.out.println("start:"+n[start]);
}
}
