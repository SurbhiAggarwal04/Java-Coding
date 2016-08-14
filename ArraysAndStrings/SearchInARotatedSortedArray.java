package ArraysAndStrings;

/*
 * Complexity O(log n) , similar to binary search
 */
public class SearchInARotatedSortedArray {
	public static void main(String[] args) {
		int n[]={10,15,20,0,5,6,8,9};
		System.out.println(find(n,0,n.length-1,10));
	}
	public static boolean find(int n[],int start,int end,int k)
	{
		if(start>end)return false;
		int mid=(start+end)/2;
		if(k==n[mid])return true;
		if(n[start]<n[mid])
		{
			if(k>=n[start] && k<n[mid])
				return find(n,start,mid-1,k);
			else
				return find(n,mid+1,end,k);
		}
		else if(n[mid]<n[start])
		{
			if(k>=n[mid] && k<=n[end])return find(n,mid+1,end,k);
			else return find(n,start,mid-1,k);
		}
		else 
		{
			if(n[mid]==n[end])
			{
				boolean result=find(n,mid+1,end,k);
				if(!result)
				{
					result=find(n,start,mid-1,k);
				}
				return result;
			}
			else 
			{
				return find(n,mid+1,end,k);
			}
		}
		
		
	}
}
