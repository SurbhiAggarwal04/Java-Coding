package StacksAndQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
class MyComparator implements Comparator<Example>
{

	@Override
	public int compare(Example o1, Example o2) {
		// TODO Auto-generated method stub
		return o1.priority-o2.priority;
	}
	
}
class Example
{
int n;
int priority;
public Example(int n,int p) {
	this.n=n;
	priority=p;
	// TODO Auto-generated constructor stub
}
	/*@Override
	public int compareTo(Example o) {
		// TODO Auto-generated method stub
		//System.out.println("this priority "+this.priority);
		//System.out.println("o priority "+o.priority);
		if(this.priority<o.priority)return 1;
		else if(this.priority>o.priority)return -1;
		else return 0;
	}*/
	
}
public class MiddleEleemntPriorityQueue {
public static void main(String[] args) {
	
	//less priority value, implies more priority
	Queue<Example> Maxqueue=new PriorityQueue<>(new MyComparator());
	Queue<Example> Minqueue=new PriorityQueue<>(Collections.reverseOrder(new MyComparator()));
	Example example1=new Example(5,1);
	Example example2=new Example(4,2);
	Example example3=new Example(6,3);
	Example example4=new Example(2,4);
	Example example5=new Example(1,3);
	Example example6=new Example(7, 3);
	Example example7=new Example(8, 5);
	Example example8=new Example(9, 5);
	Maxqueue.add(example6);
	Maxqueue.add(example1);
	Maxqueue.add(example2);
	Maxqueue.add(example4);
	Maxqueue.add(example5);
	Maxqueue.add(example3);
	Maxqueue.add(example7);
	Maxqueue.add(example8);
	System.out.println("Max heap ");
	Iterator<Example> it=Maxqueue.iterator();
	while(it.hasNext())
	{
		Example e=it.next();
		System.out.println(e.n +" "+e.priority);
	}
	//Minqueue.addAll(Maxqueue);
	
	Minqueue.add(example1);
	Minqueue.add(example2);
	Minqueue.add(example4);
	Minqueue.add(example5);
	Minqueue.add(example3);
	Minqueue.add(example6);
	Minqueue.add(example7);
	Minqueue.add(example8);
	System.out.println("Min Heap");
	it=Minqueue.iterator();
	while(it.hasNext())
	{
		Example e=it.next();
		System.out.println(e.n +" "+e.priority);
	}
	MyComparator comparator = new MyComparator();
	ArrayList<Integer> middleValues=new ArrayList<>();
	while(!Maxqueue.isEmpty())
	{
		Example min=Minqueue.peek();
		Example max=Maxqueue.peek();
		System.out.println("compare "+comparator.compare(min, max));

	 if(comparator.compare(min, max)>0)
	    {
			System.out.println("returned from minqueue "+Minqueue.remove().n);
            Minqueue.remove(max);

			System.out.println("returned from maxqueue "+Maxqueue.remove().n);
			Maxqueue.remove(min);
			
	    }
		else
		{
			break;
		}

		
	}
	System.out.println("Middle priority element");
	if(Minqueue.size()>Maxqueue.size())
	{
		it=Minqueue.iterator();
		while(it.hasNext())
		{
			Example e=it.next();
			System.out.println(e.n +" "+e.priority);
		}
	}
		
	else
	{
		it=Maxqueue.iterator();
		while(it.hasNext())
		{
			Example e=it.next();
			System.out.println(e.n +" "+e.priority);
		}
	}
		
	/*for(int i=0;i<middleValues.size();i++)
	{
		System.out.println(middleValues.get(i));
	}*/
	/*Example middle=Maxqueue.remove();
	System.out.println(middle.n +" priority "+ middle.priority);*/
	
}

}

