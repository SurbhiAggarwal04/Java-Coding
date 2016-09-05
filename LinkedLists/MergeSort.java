package LinkedLists;

public class MergeSort {
public static void main(String[] args) {
	Node n7=new Node();
	n7.data=89;
	Node n6=new Node();
	n6.data=12;
	n6.next=n7;
	Node n=new Node();
	n.data=67;
	n.next=n6;
	/*n.next=x;*/
	Node n1=new Node();
	n1.data=30;
	n1.next=n;
	Node n2=new Node();
	n2.data=53;
	n2.next=n1;
	Node n3=new Node();
	n3.data=40;
	n3.next=n2;
	Node n4=new Node();
	n4.data=10;
	n4.next=n3;
	Node current=n4;
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	current=n4;
	System.out.println("operation");
	mergeSort(current);
	
	
	
	
}
static Node mergeSort(Node current)
{
	System.out.println("mergeSort");
	if(current==null || current.next==null)return current;
	Node slow=current;
	Node fast=current;
	while(slow!=null && fast!=null && fast.next!=null && fast.next.next!=null)
	{
		slow=slow.next;
		fast=fast.next.next;
	}
	fast=slow.next;
	slow.next=null;
	System.out.println("first "+current.data);
	System.out.println("second "+fast.data);
	Node first=mergeSort(current);
	Node second=mergeSort(fast);
	
	Node result=merge(first,second);
	System.out.println("returned");
	Node r=result;
	
	/*while(r!=null)
	{
		System.out.println(r.data);
		r=r.next;
	}*/
	return result;
}
static Node merge(Node a, Node b)
{
	System.out.println("merging");
	Node current=a;
	System.out.println("a");
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	 current=b;
	 System.out.println("b");
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	Node result=null;
	Node resultCurrent=new Node();
	Node aCurrent=a;
	Node bCurrent=b;
	Node r=result;
	while(aCurrent!=null && bCurrent!=null)
	{
		System.out.println("loop");
		
		
		if(aCurrent.data<=bCurrent.data)
		{
			if(resultCurrent!=null)
			resultCurrent.next=aCurrent;
			
			resultCurrent=aCurrent;
			aCurrent=aCurrent.next;
			System.out.println("resultCurrent data"+resultCurrent.data);
			
		}
		else
		{
			if(resultCurrent!=null)
			resultCurrent.next=bCurrent;
			
			resultCurrent=bCurrent;
			bCurrent=bCurrent.next;
			System.out.println("resultCurrent data"+resultCurrent.data);

		}
		if(result==null)result=resultCurrent;
	}

	resultCurrent.next=(aCurrent==null)?bCurrent:aCurrent;
    
	System.out.println("test returned data");
    r=result;
	while(r!=null)
	{
		System.out.println(r.data);
		r=r.next;
	}
	return result;
}
}
