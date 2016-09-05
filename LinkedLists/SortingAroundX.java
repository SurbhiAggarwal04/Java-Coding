package LinkedLists;

import java.util.Iterator;
import java.util.LinkedList;



public class SortingAroundX {
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
		n3.data=4;
		n3.next=n2;
		Node n4=new Node();
		n4.data=5;
		n4.next=n3;
		
		Node current=n4;
		Node previous=current;
		int x=4;
		
		Node beforeStart=null;
		Node beforeEnd=null;
		Node afterStart=null;
		Node afterEnd=null;
		Node mid=null;
		
		
		while(current!=null)
		{
			if(current.data<x)
			{
				if(beforeStart==null)
				{
					beforeStart=current;
					beforeEnd=current;
					
				}
				else
					
				{
					beforeEnd.next=current;
					beforeEnd=current;
					
				}
			}
			else if(current.data>x)
			{
				if(afterStart==null)
				{
					afterStart=current;
					afterEnd=afterStart;
					
				}
				else
				{
					afterEnd.next=current;
					afterEnd=current;
					
				}
			}
			else
			{
				mid=current;
			}
			current=current.next;
		}
		Node list;
		if(beforeStart==null)
		{
			if(mid==null)
			{
				list=afterStart;
				
			}
			else
			{
				mid.next=afterStart;
				list=mid;
				
			}
			
		}
		else
		{
			if(mid==null)
			{
				beforeEnd.next=afterStart;
				
			}
			else
			{
				beforeEnd.next=mid;
				mid.next=afterStart;
			}
			list=beforeStart;
		}
		afterEnd.next=null;
		while(list!=null)
		{
			System.out.println(list.data);
			list=list.next;
		}
		/*LinkedList<Integer> before=new LinkedList<>();
		LinkedList<Integer> after=new LinkedList<>();
		
		while(current!=null)
		{
			if(current.data<x)
			{
				before.add(current.data);
			}
			else
			{
				after.add(current.data);
			}
			current=current.next;
		}
		before.addAll(after);
		Iterator<Integer> it=before.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}*/
		
		
}
}
