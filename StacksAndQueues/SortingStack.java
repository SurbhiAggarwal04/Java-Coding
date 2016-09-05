package StacksAndQueues;

import java.util.Iterator;
import java.util.Stack;

public class SortingStack {
public static void main(String[] args) {
	java.util.Stack<Integer> stackToBeSorted=new java.util.Stack<>();
	stackToBeSorted.push(3);
	stackToBeSorted.push(2);
	stackToBeSorted.push(10);
	stackToBeSorted.push(1);
	
	sort(stackToBeSorted);
	System.out.println("final");
	Iterator<Integer> it=stackToBeSorted.iterator();
	while(it.hasNext())
	{
		System.out.println(it.next());
	}
	
	System.out.println("Recursive sort");
	recursiveSort(stackToBeSorted);
	it=stackToBeSorted.iterator();
	while(it.hasNext())
	{
		System.out.println(it.next());
	}
	
}
public static void recursiveSort(java.util.Stack<Integer> stackToBeSorted)
{
	if(stackToBeSorted.isEmpty())return;
	int temp=stackToBeSorted.pop();
	recursiveSort(stackToBeSorted);
	
	insertRecursively(stackToBeSorted, temp);
	
	
}
public static void insertRecursively(java.util.Stack<Integer> stackToBeSorted,int data)
{
	
	if(stackToBeSorted.isEmpty() || stackToBeSorted.peek()>data)
	{
		stackToBeSorted.push(data);
		return;
	}
	else
	{
		int temp=stackToBeSorted.pop();
		insertRecursively(stackToBeSorted, data);
		stackToBeSorted.push(temp);
	}


}
public static void sort(java.util.Stack<Integer> stackToBeSorted)
{
	java.util.Stack<Integer> stackTemp=new Stack<>();
	while(!stackToBeSorted.isEmpty())
	{
		int temp=stackToBeSorted.pop();
		while(!stackTemp.isEmpty() && stackTemp.peek()>temp)
		{
			stackToBeSorted.push(stackTemp.pop());
		}
		stackTemp.push(temp);
	}
	stackToBeSorted.addAll(stackTemp);
}
}
