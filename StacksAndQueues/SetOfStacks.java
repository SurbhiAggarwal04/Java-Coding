package StacksAndQueues;

import java.util.ArrayList;

import org.omg.CORBA.SetOverrideTypeHelper;

class Node
{
	int data;
	Node below=null;
	Node above=null;
}

class Stack
{
	Node top=null;
	Node bottom=null;
	private int capacity;
	int size=0;
	public Stack(int capacity)
	{
		this.capacity=capacity;
	}
	void push(int data)
	{
		
		Node node=new Node();
		node.data=data;
		if(top==null)
		{
			top=node;
			bottom=node;
		}
		else
		{
			top.above=node;
			node.below=top;
			top=node;
		}
		size++;
	}
	void pop()
	{
		top=top.below;
		size--;
	}
	boolean isFull()
	{
	    return size==capacity;
	}
	boolean isEmpty()
	{
		if(size==0)
			return true;
		return false;
	}
}
public class SetOfStacks{
ArrayList<Stack> setOfStacks=new ArrayList<Stack>();
int capacity;
public SetOfStacks(int capacity)
{
	this.capacity=capacity;
}
public Stack getLastStack()
{
	if(setOfStacks.size()==0)return null;
	return setOfStacks.get(setOfStacks.size()-1);
}
void push(int data)
{
	Stack lastStack=getLastStack();
	if(lastStack==null)
	{
		Stack stack=new Stack(capacity);
		stack.push(data);
		setOfStacks.add(stack);
	}
	else
	{
		if(lastStack.isFull())
		{
			Stack stack=new Stack(capacity);
			stack.push(data);
			setOfStacks.add(stack);
		}
		else
		{
			lastStack.push(data);
		}
	}
}
void pop()
{
	Stack lastStack=getLastStack();
	if(lastStack==null)
	{
		System.out.println("Nothing to pop-No stack");
	}
	else
	{
		lastStack.pop();
		if(lastStack.isEmpty())
		{
			setOfStacks.remove(lastStack);
		}
	}
	
	
}
public int count()
{
	return setOfStacks.size();
}
public void popatIndex(int index)
{
	
	if(index<=setOfStacks.size())
	{
		System.out.println("removing");
		Stack stack=setOfStacks.get(index-1);
		stack.pop();
		for(int i=index+1;i<=setOfStacks.size();i++)
		{
		Stack stack1=setOfStacks.get(i-1);
		Node bottom=stack1.bottom;
		System.out.println("stack bottom"+stack1.bottom.data);
		stack1.bottom=stack1.bottom.above;
		System.out.println("stack new bottom"+stack1.bottom.data);
		stack.push(bottom.data);
		stack=stack1;
		}
	}
		else
		{
			System.out.println("No pop at index possible");
		}
		
	
	
	
}
void display()
{
	for(int i=0;i<setOfStacks.size();i++)
	{
		System.out.println(setOfStacks.get(i).top.data);
	}
}
public static void main(String[] args) {
	SetOfStacks stacks=new SetOfStacks(20);
	for(int i=0;i<100;i++)
	{
	stacks.push(i);
	}
	System.out.println(stacks.count());
	stacks.display();
	stacks.popatIndex(3);
	stacks.display();
	/*for(int i=0;i<100;i++)
	{
	stacks.pop();
	}
	System.out.println(stacks.count());*/
}
}
