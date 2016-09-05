package StacksAndQueues;
class myStack
{
	public static myStack top=null;
	public static int globalMin;
	public int value;
	public  int min;
	public myStack next=null;
	public void push(int value)
	{
		myStack node=new myStack();
		node.value=value;
		if(top==null)
		{
			top=node;
			globalMin=value;
			top.min=value;
		}
		else
		{
			int min=top.min;
			node.next=top;
			top=node;
			if(value<min)
				top.min=value;
			else
				top.min=min;
			if(top.min<globalMin)
				globalMin=min;
		}
		
	}
	public void pop()
	{
		if(top==null)
		{
			System.out.println("No element can be removed now");
			globalMin=0;
			System.exit(1);
		}
		else
		{
			if(globalMin==top.value)
			{
				System.out.println("yes equal");
				
				if(top.next!=null)
				{
					System.out.println("top.next.min"+top.next.min);
					globalMin=top.next.min;
				}
				else
				{
					
					globalMin=0;
				}
				
			}
			System.out.println("removed element"+top.value);
			top=top.next;
		}
	}
	public void min()
	{
		System.out.println("min"+globalMin);
	}
}
public class PushPopMin extends myStack{
public static void main(String[] args) {
        PushPopMin obj=new PushPopMin();
        obj.push(3);
        obj.min();
        obj.push(7);
        obj.min();
        obj.push(5);
        obj.min();
        obj.push(2);
        obj.min();
        obj.push(1);
        obj.min();
        obj.push(8);
        obj.min();
        
        obj.pop();
        obj.min();
        obj.pop();
        obj.min();
        obj.pop();
        obj.min();
        obj.pop();
        obj.min();
        obj.pop();
        obj.min();
        obj.pop();
        obj.min();
        obj.pop();
        obj.min();
}
}
