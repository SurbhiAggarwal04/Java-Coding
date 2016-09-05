package LinkedLists;

public class ReverseLinkedList {
	static Node head;
public static void main(String[] args) {
	Node n8=new Node();
	n8.data=50;
	Node n7=new Node();
	n7.data=10;
	n7.next=n8;
	Node n6=new Node();
	n6.data=6;
	n6.next=n7;
	Node n=new Node();
	n.data=5;
	n.next=n6;
	/*n.next=x;*/
	Node n1=new Node();
	n1.data=4;
	n1.next=n;
	Node n2=new Node();
	n2.data=1;
	n2.next=n1;
	Node n3=new Node();
	n3.data=2;
	n3.next=n2;
	Node n4=new Node();
	n4.data=12;
	n4.next=n3;
	
	Node current=n4;
	Node head1=reverseLinkedList(current);
	current=head1;
	while(head1!=null)
	{
		System.out.println(head1.data);
		head1=head1.next;
		
	}
	
	
	
	System.out.println("version 2");
	Node tail=reverseLinkedListVersion2(current);
	//System.out.println(tail.data);
	tail=head;
	while(tail!=null)
	{
		System.out.println(tail.data);
		tail=tail.next;
	}
	
	
	
	System.out.println("Reveerse Linked list in blocks");

    tail=reverseInBlock(head,3);
    
    while(tail!=null)
	{
		System.out.println(tail.data);
		tail=tail.next;
	}
    
    
	System.out.println("Reverse LinkedList in pairs");
	tail=reverseInpair(head);
	current=tail;
	while(tail!=null)
	{
		System.out.println(tail.data);
		tail=tail.next;
	}

	System.out.println("Recursive Reverse LinkedList in pairs");
	System.out.println("head "+head.data);
    System.out.println("head next"+head.next.data);
	tail=recursiveReverseInpair(current);
	
	while(tail!=null)
	{
		System.out.println(tail.data);
		tail=tail.next;
	}
}
public static Node reverseLinkedList(Node current)
{
	if(current.next==null)return current;
	Node m=reverseLinkedList(current.next);
	Node previous=m;
	while(previous.next!=null)
	{
		previous=previous.next;
		
	}
	previous.next=current;
	current.next=null;
	return m;
}
public static Node reverseLinkedListVersion2(Node current)
{
	if(current.next==null)
		{
		head=current;
	    System.out.println("current null"+current.data);
		return current;
		}
	Node m=reverseLinkedListVersion2(current.next);
    m.next=current;
    current.next=null;
    System.out.println("current "+current.data);
 
	return current;
}
public static Node reverseInBlock(Node current,int k)
{
	int i=0;
	Node temp=current;

	Node next=null;
	Node previous=null;
	while(temp!=null && i<k)
	{
		next=temp.next;
		temp.next=previous;
		previous=temp;
		temp=next;
		i++;
	}
	if(temp!=null)
	current.next=reverseInBlock(temp, k);
	return previous;
}
public static Node reverseInpair(Node current)
{
	Node temp=null,start=null;
	while(current.next!=null)
	{
		//System.out.println("current "+current.data);
		
		if(temp==null)
		{
			temp=current.next;
			start=temp;
		}
			
		else
		{			
			temp.next=current.next;
			temp=temp.next;
		}
		current.next=current.next.next;
		temp.next=current;
		temp=temp.next;
		if(current.next!=null)current=current.next;
		
	}
	return start;
}
public static Node recursiveReverseInpair(Node current)
{
	if(current==null)return null;
	if(current.next==null)return current;
	Node start=current.next;
	current.next=current.next.next;
	start.next=current;

	start.next.next=recursiveReverseInpair(current.next);
	return start;
}
}
