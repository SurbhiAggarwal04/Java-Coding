package LinkedLists;

public class DeletingParticularNode {
public static void main(String[] args) {
	Node n7=new Node();
	n7.data=1;
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
	n4.data=1;
	n4.next=n3;
	
	Node current=n4;
	Node head=n4;
	int key=1;
	Node previous=null;
	while(current!=null)
	{
		if(current.data==key)
		{
			if(previous==null)head=head.next;
			else
			{
				previous.next=current.next;
			}
		}
		else
		{
			previous=current;
		}
		current=current.next;
	}
	while(head!=null)
	{
		System.out.println(head.data);
		head=head.next;
	}
}
}
