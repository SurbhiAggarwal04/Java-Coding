package ArraysAndStrings;

public class MissingNumber {
	public static Integer missingNumber(int [] array)
	{
		int low = 0;
		int high = array.length -1;
 
		int mid;
 
		while(low<high)
		{
			mid = (low+high)/2;
 
			if(mid-low == array[mid]- array[low])
			{
				if( mid+1< array.length && array[mid]+1 != array[mid+1])
					return array[mid]+1;
				else
					low = mid+1;
			}
			else
			{
				if(mid -1 > -1 && array[mid]-1 != array[mid-1])
					return array[mid]-1;
				else
					high = mid-1;
			}
		}
 
		return null;
	}
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{2,3,5,6,7,8,9,10,11,12,13,14,15 }));
	}

}
