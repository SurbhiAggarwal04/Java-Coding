package LinkedLists;

public class DetectingCircularList {
public static void main(String[] args) {
	Node n=new Node();
	n.data=1;
	
	Node n1=new Node();
	n1.data=2;
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
	
	n.next=n2;
	Node n5=new Node();
	n5.data=10;
	n5.next=n4;
	Node slow=n5;
	Node fast=n5;
	
	while(slow!=null && fast!=null && fast.next!=null)
	{
		/*System.out.println(slow.data + " "+fast.data);*/
		slow=slow.next;
		
		fast=fast.next.next;
		
		if(slow==fast)
		{
			System.out.println("length of loop");
			int length=1;
			while(fast.next!=slow)
			{
				System.out.println(" fast "+fast.data);
				length++;
				fast=fast.next;
			}
			System.out.println("length "+length);
			System.out.println("loop detected");
		/*	System.out.println(slow.data + " "+fast.data);*/
			Node ptr1=n4;
			while(ptr1!=null)
			{
				System.out.println("ptr1"+ptr1.data);
				Node ptr2=slow;
				while(ptr2.next!=ptr1 && ptr2.next!=slow)
				{
					ptr2=ptr2.next;
				}
				
				if(ptr2.next==ptr1)
				{
					System.out.println("ptr2 when matched"+ptr2.data);
					ptr2.next=null;
					System.out.println(ptr2.next);
					break;
				}
				ptr1=ptr1.next;
			}
			
			break;
			
		}
		
	}
	
	Node current=n5;
	while(current!=null)
	{
		System.out.println(current.data);
		System.out.println(current.next);
		current=current.next;
	}

}
}
