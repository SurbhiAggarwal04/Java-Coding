package LinkedLists;

public class InsertionInCircularLinkedList {
public static void main(String[] args) {
	Node n7=new Node();
	n7.data=7;
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
	n2.data=3;
	n2.next=n1;
	Node n3=new Node();
	n3.data=2;
	n3.next=n2;
	Node n4=new Node();
	n4.data=1;
	n4.next=n3;
	n7.next=n4;
	Node current=n4;
	Node start=insert(current,0);
	current=start;
	while(current.next!=start)
	{
		System.out.println(current.data);
		current=current.next;
	}
	System.out.println(current.data);
}
public static Node insert(Node current,int n)
{
	Node newNode=new Node();
	newNode.data=n;
	
	if(current==null)
	{
		newNode.next=newNode;
		return newNode;
	}
	if(n<=current.data)
	{
		newNode.next=current;
		while(current!=null && current.next!=newNode.next)current=current.next;
		current.next=newNode;
		
		//current=newNode;
		return newNode;
	}
		Node previous=null;
		Node temp=current;
		while(temp!=null && temp.next.data<n && temp.next!=current)
		{
			previous=temp;
			temp=temp.next;
		}
		
		newNode.next=temp.next;
		temp.next=newNode;
			return current;
		
		
		
		
	

}
}
