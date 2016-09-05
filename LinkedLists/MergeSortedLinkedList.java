package LinkedLists;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
class TestNode implements Comparable<TestNode>
{
	int data;
	TestNode next;
	@Override
	public int compareTo(TestNode o) {
		// TODO Auto-generated method stub
		if(this.data>o.data)return -1;
		else if(this.data<o.data)return 1;
		return 0;
	}
}
class Entry implements Comparable<Entry>
{
	TestNode n;
//	TestNode next;
	public Entry()
	{
		
	}
	public Entry(TestNode n,TestNode next)
	{
		this.n=n;
		//this.next=next;
	}
	@Override
	public int compareTo(Entry o) {
		// TODO Auto-generated method stub
		if(this.n.data>o.n.data)return -1;
		else if(this.n.data<o.n.data)return 1;
		return 0;
	}
	
}
public class MergeSortedLinkedList {
	
public static void main(String[] args) {
	TestNode n=new TestNode();
	n.data=8;
	/*n.next=x;*/
	TestNode n1=new TestNode();
	n1.data=6;
	n1.next=n;
	TestNode n2=new TestNode();
	n2.data=4;
	n2.next=n1;
	TestNode n3=new TestNode();
	n3.data=2;
	n3.next=n2;
	TestNode n4=new TestNode();
	n4.data=1;
	n4.next=n3;
	
	
	TestNode nn1=new TestNode();
	nn1.data=7;
	TestNode nn2=new TestNode();
	nn2.data=5;
	nn2.next=nn1;
	TestNode nn3=new TestNode();
	nn3.data=3;
	nn3.next=nn2;
	TestNode nn4=new TestNode();
	nn4.data=1;
	nn4.next=nn3;
	
	TestNode firstLinkedList=n4;
	TestNode secondLinkedList=nn4;
	
	TestNode current=firstLinkedList;
	TestNode previous=null;
	TestNode next=null;
	
	while(current!=null)
	{
		next=current.next;
		current.next=previous;
		previous=current;
		current=next;
	}
	System.out.println("First Linked List");
	firstLinkedList=previous;
	current=firstLinkedList;
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	current=secondLinkedList;
	previous=null;
	next=null;
	
	while(current!=null)
	{
		next=current.next;
		current.next=previous;
		previous=current;
		current=next;
	}

	
	System.out.println("Second Linked List");
	secondLinkedList=previous;
	current=secondLinkedList;
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	System.out.println("merging");
	current=merge(firstLinkedList,secondLinkedList);
	while(current!=null)
	{
		System.out.println(current.data);
		current=current.next;
	}
	
	
}
public static TestNode merge(TestNode firstLinkedList,TestNode secondLinkedList)
{
	TestNode result=null;
	TestNode current=null;
//	Queue<Entry> q=new PriorityQueue<>();
	Queue<TestNode> q=new PriorityQueue<>();

	Entry entry=new Entry(firstLinkedList,firstLinkedList.next);
	q.add(firstLinkedList);
	entry=new Entry(secondLinkedList,secondLinkedList.next);
	q.add(secondLinkedList);
	while(!q.isEmpty())
	{
		TestNode n=q.poll();
		//System.out.println(e.n.data);
	//	TestNode n=e.n;
		if(result==null)
			{
			result=n;
			current=n;
			}
		else
			{
			current.next=n;
			current=n;
			}
		if(n.next!=null)
//		q.add(new Entry(n.next,n.next.next));
			q.add(n.next);
		
	}
	
	
	return result;
	
}
}

