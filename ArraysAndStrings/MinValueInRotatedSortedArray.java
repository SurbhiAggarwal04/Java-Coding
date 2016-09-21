package ArraysAndStrings;

public class MinValueInRotatedSortedArray {
public static void main(String[] args) {
	int n[]={7,8,9,10,11,12,13,14,15, 0,1, 2,3,4,5,6};
	find(n,0,n.length-1);	
}
public static void find(int[] n,int start,int end)
{
	int min=0;
	while(start<end)
	{
		System.out.println("start:"+n[start]);
		System.out.println("end:"+n[end]);
		int mid=start+(end-start)/2;
		System.out.println("mid :"+n[mid]);
		if(n[mid+1]<n[mid])
			{
			min=n[mid+1];
			break;
			}
		else
		{
			if(n[mid]<n[end])			
				end=mid;
			else
				start=mid+1;
		}
		/*if(n[mid-1]<=n[mid] && n[mid]<=n[mid+1]){
			
		}*/
	}
	System.out.println(min);
}
}
