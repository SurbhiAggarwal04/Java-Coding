package ArraysAndStrings;

import java.util.Arrays;
import java.util.Stack;

public class MidElementGreaterThanSurrounding {
public static void main(String[] args) {
	int n[]=new int[]{1,1,1,2,2,3,4,5,5,6,7,7,8,9};
	// 1,2,1,1
	// 1,2,1,1,2
	// 1,2,1,2,1,4,3,6,5,7,5,8,7
	arrange(n);
	System.out.println("using stack");
	n=new int[]{1,1,1,2,2,3,4,5,5,6,7,7,8,9};
	//wiggleUsingStack(n);
	System.out.println("wiggle");
	wiggleSort(n); // [4, 9, 3, 8, 2, 7, 2, 7, 1, 6, 1, 5, 1, 5]
	n=new int[]{1,1,1,2,2,3,4,5,5,6,7,7,8,9};
	System.out.println("wiggle sort but in place");
	inPlaceWiggle(n);
	
}
public static void inPlaceWiggle(int n[])
{
	for(int i=1;i<n.length;i++)
	{
		if(i%2==0 && n[i]>n[i-1])
		{
			int temp=n[i];
			n[i]=n[i-1];
			n[i-1]=temp;
		}
		if(i%2==1 && n[i]<n[i-1])
		{
			int temp=n[i];
			n[i]=n[i-1];
			n[i-1]=temp;
		}
	}
	System.out.println(Arrays.toString(n));
}
//wrong cannot guarantee correct answer
public static void wiggleUsingStack(int[] n)
{
	Stack<Integer> stack1=new Stack<>();
	Stack<Integer> stack2=new Stack<>();
	stack1.push(n[0]);
	boolean greater=true;
	int i=1;
	while(i<n.length){
		System.out.println("stack1:"+stack1);
		System.out.println("stack2:"+stack2);
		
		if(!stack2.isEmpty() && (greater && stack1.peek()<stack2.peek()) || (!greater && stack1.peek()>stack2.peek()))
		{
			stack1.push(stack2.pop());
			greater=!greater;
		}
		else if((greater && n[i]>stack1.peek()) || (!greater && n[i]<stack1.peek()))
			{
			stack1.push(n[i]);
			greater=!greater;
			i++;
			}
	
		else
		{
			stack2.push(n[i]);
			i++;
		}
			
		
		
			
	}
	System.out.println(stack1);
	
}
public static void wiggleSort(int[] nums) {
    if (nums == null || nums.length <= 1) {
        return;
    }
     
    Arrays.sort(nums);
    int n = nums.length;
     
    int[] temp = new int[n];
    int left = (n - 1) / 2;
    int right = n - 1;
     
    for (int i = 0; i < n; i++) {
        if ((i & 1) == 0) {
            temp[i] = nums[left];
            left--;
        } else {
            temp[i] = nums[right];
            right--;
        }
    }
     
    System.arraycopy(temp, 0, nums, 0, n);
    System.out.println(Arrays.toString(nums));
}
public static void arrange(int[] n)
{
	int index=1;
	int value=n[0];
	boolean swap=false;
	for(int i=1;i<n.length;i+=2)
	{
		System.out.println("value:"+value);
		if(i+1<n.length)
		{
			if(swap)
			{
				int temp=n[i];
				n[i]=n[index];
				n[index]=temp;
				swap=false;
				
			}
			if(n[i+1]>n[i])
			{
				int temp=n[i+1];
				n[i+1]=n[i];
				n[i]=temp;
				
			}
			else
			{
				swap=true;
				index=i;
			}
		}
		
	}
	System.out.println("Final:"+Arrays.toString(n));
}
}
