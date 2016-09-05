package LinkedLists;

import java.util.Hashtable;


public class RemovingDuplicates {
public static void main(String[] args) {
	Node n9=new Node();
	n9.data=3;
	
	Node n8=new Node();
	n8.data=3;
	n8.next=n9;
	Node n=new Node();
	n.data=2;
	n.next=n8;
	Node n1=new Node();
	n1.data=3;
	n1.next=n;
	Node n2=new Node();
	n2.data=1;
	n2.next=n1;
	Node n3=new Node();
	n3.data=5;
	n3.next=n2;
	Node n4=new Node();
	n4.data=3;
	n4.next=n3;
	Node current=n4;
	 Node list=n4;
    Node previous1=null;
     
     while(current!=null)
         {
         
         if(current.data==3)
             {
             if(current==list)list=list.next;
             else previous1.next=current.next;
             
         }
         previous1=current;
         current=current.next;
         
         
     }
     current=list;
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	System.out.println("hi");
	current=n4;
	Node currentPrevious=n4;
	int k=3;
	for(int i=0;i<k-1;i++)
	{
		current=current.next;
	}
	while(current!=null)
	{
		current=current.next;
		currentPrevious=currentPrevious.next;
	}
	System.out.println("nd kth element"+currentPrevious.data);
	
	Hashtable<Integer, Boolean> ht=new Hashtable<>();
	
	current=n4;
	Node previous=null;
	while(current!=null)
	{
		if(ht.containsKey(current.data))
		{
			previous.next=current.next;
		}
		else
		{
			ht.put(current.data, true);
			previous=current;
		}
		
		current=current.next;
	}
	current=n4;
	System.out.println("-------------------");
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	
	
}
}
