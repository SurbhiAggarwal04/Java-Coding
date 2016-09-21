package ArraysAndStrings;

import java.util.Arrays;

public class AlternatingNegativeAndPositive {
	public static void main(String[] args) {
		int[] array = new int[] {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		algoBased(array);
		boolean positive = false;
		int i = 0;
		while (i < array.length) {
			if ((array[i] < 0 && positive) || (array[i] > 0 && !positive)) {
				System.out.println("wrong :"+array[i]);
				int j = i;
				while (j < array.length) {
					if ((positive && array[j] > 0) || (!positive && array[j] < 0))
					{
						positive=!positive;
						break;
					}
					
						j++;
				}
				if(j<array.length)
				{
					System.out.println("correct:"+array[j]);
					int temp=array[j];
					
					for(int k=j;k>i;k--)
					{
						array[k]=array[k-1];				
					}
					array[i]=temp;
					
					System.out.println(Arrays.toString(array));
				}
				
			} else {
				positive=!positive;
				/*if ((array[i] < 0 && !positive))
					positive = true;
				else
					positive = false;*/
				
			}
			System.out.println("positive val:"+positive);
			i++;
		}
		System.out.println(Arrays.toString(array));
	}
	public static void algoBased(int array[])
	{
		int outOfPlace=-1;
		int i=0;
		while(i<array.length)
		{
			if(outOfPlace==-1)
			{
				if((array[i]<0 && i%2!=0) || (array[i]>0 && i%2==0))
				{
					outOfPlace=i;
				}
			}
			if(outOfPlace>=0)
			{
				if((array[i]>0 && array[outOfPlace]<0) || (array[i]<0 && array[outOfPlace]>0))
				{
					int index=i;
					int temp=array[index];
					while(index>outOfPlace)
					{
						array[index]=array[index-1];
						index--;
					}
					array[index]=temp;
					if(i-outOfPlace>2)outOfPlace+=2;
					else outOfPlace=-1;
				}
				
			}
			i++;
		}
		
		System.out.println("Algo based");
		System.out.println(Arrays.toString(array));
	}
}
