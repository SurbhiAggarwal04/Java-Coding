package LinkedLists;

import java.util.LinkedList;

public class TwoListAddition {
public static void main(String[] args) {
	Node n=new Node();
	n.data=3;
	
	Node n1=new Node();
	n1.data=2;
	n1.next=n;
	Node n2=new Node();
	n2.data=1;
	n2.next=n1;
	
	
	/*Node previous=null;
	Node current=n2;
	while(current!=null)
	{
		Node next=current.next;
		current.next=previous;
		previous=current;
		current=next;
		
	}*/
	
	Node n3=new Node();
	n3.data=9;
	
	Node n4=new Node();
	n4.data=9;
	n4.next=n3;
	
	Node n5=new Node();
	n5.data=9;
	n5.next=n4;
	
	/*previous=null;
	current=n5;*/
	
	/*while(current!=null)
	{
		Node next=current.next;
		current.next=previous;
		previous=current;
		current=next;
	}*/
	
	Node current1=n2;
	Node current2=n5;
	int carry=0;
	Node list=null;
    Node start=null;
	while(current1!=null || current2!=null)
	{
		int val=0;
		System.out.println(current1.data + " " + current2.data);
		if(current2!=null)
		{
			val=current2.data + carry;
		}
		if(current1!=null)
		{
			val=current1.data +carry;
		}
		
		
		if(String.valueOf(val).length()>1)
		{
			carry=val/10;
		}
		Node node=new Node();
		if(current1.next==null && current2.next==null)
		{
			node.data=val;
		}
		else
		{
		node.data=val%10;
		}
		if(list==null)
		{
		
		list=node;
		start=list;
		}
		else
		{
			System.out.println(node.data);
			list.next=node;
			list=node;
			
		}
		
		current1=current1.next;
		current2=current2.next;
	}
	while(start!=null)
	{
		System.out.println(start.data);
		start=start.next;
	}
	
	
}
}
