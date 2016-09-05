package StacksAndQueues;

import java.util.Iterator;
import java.util.Stack;

public class RemovingAdjacentDuplicate {
	public static void main(String[] args) {
		int array[]=new int[]{1,5,6,8,8,8,0,1,1,0,6,5};
		int index=-1;
		int i=0;
		while(i<array.length)
		{
			if(index==-1 || array[index]!=array[i])
			{
				index++;
				array[index]=array[i];
				i++;
			}
			else
			{
				while(i<array.length && array[i]==array[index])i++;
				index--;
			}
		}
		System.out.println("result");
		for(i=0;i<=index;i++)
		{
			System.out.println(array[i]);
		}
		
		System.out.println("another result");
		java.util.Stack<Integer> stack = removeDuplicates(array);
		Iterator it=stack.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	/*	stack.push(1);
		stack.push(5);
		stack.push(6);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(0);
		stack.push(1);
		stack.push(1);
		stack.push(0);
		stack.push(6);
		stack.push(5);*/
		

	}
	public static java.util.Stack<Integer> removeDuplicates(int[] array)
	{
		java.util.Stack<Integer> stack=new Stack<>();
		int i=0;
		while(i<array.length)
		{
			if(stack.isEmpty() || stack.peek()!=array[i])
			{
				stack.push(array[i]);
				i++;
			}
			else 
			{
				while(i<array.length && array[i]==stack.peek())
				i++;
				stack.pop();
			}
		}
		return stack;
	}
}
