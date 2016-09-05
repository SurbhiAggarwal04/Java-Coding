package LinkedLists;
class Result
{
	Node node;
	boolean status;
	Result()
	{
		
	}
	Result(Node node,boolean status)
	{
		this.node=node;
		this.status=status;
	}
}
public class LinkedListPalindrome {
public static void main(String[] args) {
	
	/*Node x=new Node();
	x.data=1;
	x.next=null;*/
	Node n=new Node();
	n.data=2;
	/*n.next=x;*/
	Node n1=new Node();
	n1.data=1;
	n1.next=n;
	Node n2=new Node();
	n2.data=2;
	n2.next=n1;
	Node n3=new Node();
	n3.data=1;
	n3.next=n2;
	Node n4=new Node();
	n4.data=2;
	n4.next=n3;
	System.out.println("recursive");
	int length=0;
	Node slow=n4;
	while(slow!=null)
	{
		slow=slow.next;
		length++;
	}
	System.out.println((recursive(n4,length)).status);
	System.out.println("------------------");
	slow=n4;
	Node fast=n4;
	while(slow!=null && fast!=null && fast.next!=null)
	{
	if(fast.next.next==null)
	{
	break;
	}
		slow=slow.next;
		fast=fast.next.next;
	
		
	}
	
	System.out.println("slow"+slow.data);
	Node head=n4;
	Node ptr=slow;
	ptr=ptr.next;
	Node current=ptr;
	Node next=null;
	Node previous=null;
	while(current!=null)
	{
		ptr=current;
		next=current.next;
		current.next=previous;
		previous=current;
		current=next;
		
	}
	slow.next=ptr;
	while(head!=null)
	{
		System.out.println(head.data);
		head=head.next;
	}
	head=n4;
	ptr=slow.next;
   while(head!=slow.next && ptr!=null)
    {
    	System.out.println("head"+head.data);
    	if(head.data!=ptr.data)
    	{
    		System.out.println("Not palindrome");
    		System.exit(1);
    	}
    	head=head.next;
    	ptr=ptr.next;
    }
	
    System.out.println("palindrome");
	
	/*Node current=n4;
	Node previous=null;
	Node next=null;
	Node reverseStartNode=null;
	
	while(current!=null)
	{
		
		
		next=current.next;
		current.next=previous;
		previous=current;
		current=next;
	}
	*/
	
}
public static Result recursive(Node head,int length)
{
	if(head==null || length==0)return new Result(null,true);
	if(length==1)return new Result(head.next,true);
	if(length==2)
	{
		return new Result(head.next.next,head.data==head.next.data);
	}
	Result result=recursive(head.next, length-2);
	if(result.status==false && result.node==null)return result;
	result.status=head.data==result.node.data;
	result.node=result.node.next;
	return result;
}
}
