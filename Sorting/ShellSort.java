package Sorting;

import java.util.Arrays;
/*
 * Shell Sort works by comparing elements separated by a gap of several positions. This way
 *  element takes bigger steps towards its expected position. Comparisons and exchanges are few
 *  as compared to bubble, insertion or selection sort
 *  
 *  Best Case (like bubble, insertion sort): O(n)
 *  Average case depends on gap sequence
 *  Worst case complexity: O(n(logn)^2)
 */
public class ShellSort {
public static void main(String[] args) {
	int array[]=new int[]{5,3,0,2,4,1,0,5,2,3,1,4,5,6,8,9,10,12,13,14};
	int inner,outer;
	int temp;
	 int h=1;
	 while(h<=array.length/3)h=h*3+1;
	 System.out.println(array.length);
	 System.out.println(h);
	 
	 while(h>0)
	 {
		 System.out.println("value of h:"+h);
		 for(outer=h;outer<array.length;outer++)
		 {
			 temp=array[outer];
			 System.out.println("temp :" +temp);
			 inner=outer;
			 while(inner>h-1 && array[inner-h]>=temp)
			 {
				 System.out.println("inner value: "+inner);
				 array[inner]=array[inner-h];
				 inner=inner-h;
			 }
			 array[inner]=temp;
		 }
		 h=(h-1)/3;
	 }
	 System.out.println(Arrays.toString(array));
}
}
