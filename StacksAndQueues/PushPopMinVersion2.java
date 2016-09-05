package StacksAndQueues;

import java.util.Stack;
class A
{
	public void show(Integer a)
	{
		System.out.println("A");
	}
	public void show(int a)
	{
		System.out.println("A int");
	}
}
class B extends A
{
	public void show(int a,int b)
	{
		System.out.println("B");
	}
}
class NodeWithMin
{
	int value;
	public NodeWithMin(int v)
	{
		value=v;
		
	}
}

class StackWithMin extends Stack<Integer>
{
	Stack<Integer> minStack=new Stack<Integer>();
	
	
	public Integer push(Integer value,Integer s)
	{
		System.out.println("here");
			if(minStack.size()==0 || minStack.peek()>value)minStack.push(value);
				System.out.println(minStack);
		    return super.push(value);
		   
	}
}
public class PushPopMinVersion2 {
	public static void main(String[] args) {
		Stack<Integer> stack=new StackWithMin();
		stack.push(6);
		stack.push(5);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		//System.out.println(stack.minStack);
		
		B obj=new B();
		obj.show(1,2);
		
	}
    
}
