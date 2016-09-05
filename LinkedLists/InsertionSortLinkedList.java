package LinkedLists;

public class InsertionSortLinkedList {
public static void main(String[] args) {
	Node n7=new Node();
	n7.data=1;
	Node n6=new Node();
	n6.data=4;
	n6.next=n7;
	Node n=new Node();
	n.data=3;
	n.next=n6;
	/*n.next=x;*/
	Node n1=new Node();
	n1.data=5;
	n1.next=n;
	Node n2=new Node();
	n2.data=1;
	n2.next=n1;
	Node n3=new Node();
	n3.data=2;
	n3.next=n2;
	Node n4=new Node();
	n4.data=1;
	n4.next=n3;
	
	Node head=n4;
	Node current=n4;
	current=current.next;

	Node newHead=head;
	Node newTail=newHead;
	newTail.next=null;
	while(current!=null)
	{
		Node next=current.next;
		if(current.data<=newHead.data)
		{
			
			current.next=newHead;
			newHead=current;
			
		}
		else
		{
			
			if(current.data>=newTail.data)
			{
				newTail.next=current;
				newTail=newTail.next;
				newTail.next=null;
			}
			
			else
			{
			Node currentNewHead=newHead;
			while(currentNewHead.next!=null)
			{
				if(current.data>currentNewHead.data && current.data<=currentNewHead.next.data)
				{
					current.next=currentNewHead.next;
					currentNewHead.next=current;
					break;
				}
				currentNewHead=currentNewHead.next;
			}
			}
			
		}

		current=next;
	}
	while(newHead!=null)
	{
		System.out.println(newHead.data);
		newHead=newHead.next;
	}
	
}
}
