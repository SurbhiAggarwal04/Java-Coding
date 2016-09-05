package LinkedLists;

public class SortingAlternatingAscendingDescending {
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
    Node l1=n4;
    Node l1Start=null;
    l1Start=l1;
    
    Node l2=n4.next;
    Node l2Start=l2;
    current=n4.next.next;
    /* separate ascending and descending list*/
    while(current!=null)
    {
    
    	l1.next=current;
    	l1=l1.next;
    	current=current.next;
    	if(current!=null)
    	{
    		l2.next=current;
    		l2=l2.next;
    		current=current.next;
    	}
    	
    		
    }
    l1.next=null;
    l2.next=null;
    
    /*reverse descending list */
    current=l2Start;
    Node next=null;
    Node previous=null;
    while(current!=null)
    {
    	next=current.next;
    	current.next=previous;
    	previous=current;
    	current=next;
    }
    System.out.println("first");
    current=l1Start;
    while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}    System.out.println("second");
	l2Start=previous;
	current=l2Start;
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	System.out.println("merged");
	current=merge(l1Start,l2Start);
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	
}
static Node merge(Node l1,Node l2)
{
	if(l1==null)return l2;
	if(l2==null)return l1;
	Node temp=null;
	if(l1.data<=l2.data)
	{
	  temp=new Node();
	  temp.data=l1.data;
	  temp.next=merge(l1.next,l2);
	}
	else 
	{
		  temp=new Node();
		  temp.data=l2.data;
		  temp.next=merge(l1,l2.next);		
	}
	return temp;
	
}
}
