package LinkedLists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class NToLastElement {
	static Node head=null;
	static int counter;
public static void main(String[] args) {
	LinkedList<Integer> lin=new LinkedList<>();
	lin.add(1);
	lin.add(2);
	lin.add(3);
	lin.add(4);
	lin.add(5);
	Iterator it=lin.iterator();
/*	Node n8=new Node();
	n8.data=10;*/
	Node n7=new Node();
	n7.data=1;
	//n7.next=n8;
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
	head=n4;
	int count=0;
	int nFromLast=0;
	/*
	 * Binary Search
	 */
	while(true)
	{
		Node slow=current;
		Node fast=current;
		count=0;
		while(slow!=null && fast!=null && fast.next!=null)
		{
			count++;
			slow=slow.next;
			fast=fast.next.next;
			
			
		}


		if(nFromLast>2*count+1)
		{
			System.out.println("N exceeds length of list");
			break;
		}
		else if(count==nFromLast)
		{
			System.out.println("Node value "+slow.data);
			break;
		}
		else if(nFromLast>count)
		{

			slow.next=null;
			nFromLast=nFromLast-count;
			if(current.next==slow)
			{
				if(nFromLast==1)
				{
					System.out.println("Node value "+current.data);
					break;
				}
				if(nFromLast==2)
				{
					System.out.println("Node value "+slow.data);
					break;
				}
			}
		}
		else
		{
			current=slow;
	
			
		}
		
	}
	current=n4;
	System.out.println("recursive serach");
	Node result=recursiveSearch(current,0);
	System.out.println("result "+result.data);
	//System.out.println("Recursive Binary Search");
	//Node n=recursiveBinarySearch(current, nFromLast);
	while(it.hasNext())
	{
		System.out.println(it.next());
	}
	/*Scanner scan=new Scanner(System.in);
	int k=scan.nextInt();
	it=lin.iterator();
	int i=1;
	while(it.hasNext())
	{
		System.out.println("i"+i);
		System.out.println("k"+k);
		if(i>=k)
			{System.out.println(it.next());}
		else
		{
			it.next();
		}
		i++;
	}*/
	
	

}
public static Node recursiveSearch(Node current, int nFromLast)
{
	
	if(current!=null)
	{
		
		Node m=recursiveSearch(current.next, nFromLast);
		counter++;
		if(m!=null)return m;

		if(counter==nFromLast)
			{
			return current;
			}
		

	}
	return null;
	
}
}
