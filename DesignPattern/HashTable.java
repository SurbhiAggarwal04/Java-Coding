package DesignPattern;

public class HashTable
{
	private class Node
	{
		public Object key;
		public Object value;
		public Node next;
 
		public Node (Object key, Object value)
		{
			this.key = key;
			this.value = value;
		}
	}
 
	private Node[] buckets;
	private int tableSize;
	private int size;
 
	public HashTable(int tableSize)
	{
		this.tableSize = tableSize;
		buckets = new Node[tableSize];
		size = 0;
	}
 
	public void put(Object key, Object value) throws NullPointerException
        {
		if (key == null)
			throw new NullPointerException("Key cannot be null!");
 
		int location = key.hashCode() % tableSize;
 
		if (buckets[location] == null)
                {
			buckets[location] = new Node(key, value);
		}
                else
                {
			Node n = buckets[location];
			Node p = null;
 
			while (n != null)
                        {
				if (n.key.equals(key))
                                {
					n.value = value;
					return;
				}
 
				p = n;
				n = n.next;
			}
 
			p.next = new Node(key, value);
		}
 
		size++;
	}
 
	public Object get(Object key) throws NullPointerException
	{
		if (key == null)
			throw new NullPointerException("Key cannot be null!");
 
		int location = key.hashCode() % tableSize;
 
		Node n = buckets[location];
 
		while (n != null && !n.key.equals(key))
			n = n.next;
 
		if (n == null)
			return null;
		else
			return n.value;
	}
 
	public Object remove(Object key) throws NullPointerException
	{
		if (key == null)
			throw new NullPointerException("Key cannot be null!");
 
		int location = key.hashCode() % tableSize;
 
		Node n = buckets[location];
		Node p = null;
 
		while (n != null && !n.key.equals(key))
                {
			p = n;
			n = n.next;
		}
 
		if (n == null)
			return null;
 
		size--;
 
		if (p == null)
			buckets[location] = n.next;
		else
			p.next = n.next;
 
		return n.value;
	}
 
	public int size()
	{
		return size;
	}
 
	public boolean isEmpty()
	{
		return size == 0;
	}
}
