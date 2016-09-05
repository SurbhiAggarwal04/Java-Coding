package StacksAndQueues;

import java.security.acl.LastOwnerException;

public class ArrayToStack {
static int lasElement=100;
static int buffer[]=new int[lasElement*3+1];
static int stackPointers[]={0,0,0};
static void  push(int value)
{
	for(int i=0;i<stackPointers.length;i++)
	{
		if(stackPointers[i]==lasElement)
		{
			System.out.println("No more push please");
			for(int j=0;j<stackPointers.length;j++)
			System.out.println(stackPointers[j]);
			while(true)
			poll();
			//System.exit(1);
		}
		else
		{
			stackPointers[i]=value;
			buffer[i*lasElement+value]=value;
		}
	}
}
static void poll()
{
	for(int i=0;i<stackPointers.length;i++)
	{
		if(stackPointers[i]==0)
		{
			System.out.println("No more removals please");
			System.exit(1);
		}
		else
		{
			int value=buffer[i*lasElement+stackPointers[i]];
			System.out.println("Value deleted"+ value);
			
			buffer[i*lasElement+stackPointers[i]]=0;
			stackPointers[i]--;
		}
	}
}
public static void main(String[] args) {
	int i=1;
	while(true)
	{
		push(i);
		i++;
	}
	
	
}
}
