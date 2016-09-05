package LinkedLists;

public class RotateList {
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
	
	Node head=n4;
	int rotateIndex=2;
	Node rotateStart=head;
	Node rotateEnd=head;
	while(rotateIndex>0)
	{
		rotateEnd=rotateEnd.next;
		rotateIndex-=1;
	}
	rotateStart=rotateEnd;
    Node newHead=rotateEnd.next;
    while(rotateStart.next!=null)rotateStart=rotateStart.next;
	rotateEnd.next=null;
	rotateStart.next=head;
	
	while(newHead!=null)
	{
		System.out.println(newHead.data);
		newHead=newHead.next;
	}
	
}

}
