package Trees;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/*
 * For top a set can also be used to store the hd, if hd does not exist in the set print the value
 * for bottom up, a map can be used to store hd with the node, everytime same hd is seen, it is replaced with the new value of node in the map
 * in the end, it is the map which is the result
 */
public class Views {
	static int maxLevel=Integer.MIN_VALUE;
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.insert(8);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(9);
		tree.insert(10);
		tree.insert(11);
		tree.insert(12);
		tree.insert(13);
		tree.insert(14);
		tree.insert(15);
		tree.insert(16);
		tree.insert(1);
		System.out.println("Top View Iterative");
	    iterativeTopView(tree.root);
	    System.out.println("Top View Recursive");
	  //  recursiveTopView(tree.root,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
	    System.out.println("Left View Iterative");
	    iterativeLeftView(tree.root);
	    System.out.println("Left View recursive");
	    recursiveLeftView(tree.root,0);
	}
	public static void recursiveLeftView(Node root,int level)
	{
		if(root==null)return;
		if(level>maxLevel)
			{
			System.out.println(root.value);
			maxLevel=level;
			}
		recursiveLeftView(root.leftChild,level+1);
		recursiveLeftView(root.rightChild, level+1);
	}
	public static void iterativeLeftView(Node root)
	{
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		queue.add(null);
		boolean flag=false;
		while(!queue.isEmpty())
		{
		
			Node node=queue.remove();
			if(node!=null && !flag){
				System.out.println(node.value);
				flag=true;
			}
			else if(node==null)
			{
				if(!queue.isEmpty())queue.add(null);
				flag=false;
			}
			if(node!=null && node.leftChild!=null)queue.add(node.leftChild);
			if(node!=null && node.rightChild!=null)queue.add(node.rightChild);
			
		}
	}
	public static void  iterativeTopView(Node root)
	{
		int minHd=Integer.MAX_VALUE;
		int maxHd=Integer.MIN_VALUE;
		Map<Node,Integer> nodeQueue=new LinkedHashMap();
		nodeQueue.put(root,0);
		
		while(!nodeQueue.isEmpty())
		{
			Map.Entry<Node, Integer> value= nodeQueue.entrySet().iterator().next();
			nodeQueue.remove(value.getKey());
			if(value.getValue()<minHd || value.getValue()>maxHd)
			{
				System.out.println(value.getKey().value);
				if(value.getValue()<minHd)minHd=value.getValue();
				if(value.getValue()>maxHd)maxHd=value.getValue();
				
			}
			if(value.getKey().leftChild!=null)nodeQueue.put(value.getKey().leftChild, value.getValue()-1);
			if(value.getKey().rightChild!=null)nodeQueue.put(value.getKey().rightChild, value.getValue()+1);
		}
		
	}
/*	public static void recursiveTopView(Node root,int currentHd,int minHd,int maxHd)
	{
	if(root==null)return;
	if(currentHd<minHd || currentHd>maxHd)
	{
		System.out.println(root.value);
	}
	recursiveTopView(root.leftChild, currentHd-1, currentHd<minHd?currentHd:minHd, currentHd>maxHd?currentHd:maxHd);
	
	recursiveTopView(root.rightChild, currentHd+1, currentHd<minHd?currentHd:minHd, currentHd>maxHd?currentHd:maxHd);
	}*/
}
