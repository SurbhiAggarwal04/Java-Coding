package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * Convert BST into a Min-Heap
 */
public class ConversionOfBSTtoMinHeap {
public static void main(String[] args) {
	BinaryTree tree=new BinaryTree();
	tree.insert(8);
	tree.insert(4);
	tree.insert(2);
	tree.insert(6);
	tree.insert(12);
	tree.insert(10);
	tree.insert(14);
	System.out.println("BST tree preorder display");
	tree.displayTree(tree.root);
	
	System.out.println("Inorder traversal");
	List<Integer> inorder=new ArrayList();
	
	inorderTraversal(tree.root,inorder);
	System.out.println(inorder);
	System.out.println("Min Heap using inorder traversal");
	Node minHeapRoot=new Node();
	createHeap(minHeapRoot,inorder);
	tree.displayTree(minHeapRoot);
	
	System.out.println("sorted linkedlist created form BST");
	Node linkedlistroot=convertToLinkedList(tree.root);
	Node current=linkedlistroot;
	while(current!=null)
	{
		System.out.println(current.value);
		current=current.rightChild;
	}
	System.out.println("Min Heap using in place conversion, sorted linked list created from BST");
	minHeapRoot=createHeap(linkedlistroot);
	tree.displayTree(minHeapRoot);
	
}

public static Node convertToLinkedList(Node root)
{
	if(root==null)return null;
	Node r=convertToLinkedList(root.rightChild);
	root.rightChild=r;
	Node l=convertToLinkedList(root.leftChild);
	root.leftChild=null;;
	if(l!=null)
		{
		Node temp=l;
		while(temp.rightChild!=null)temp=temp.rightChild;
		temp.rightChild=root;
		return l;
		}
	
	return root;
	
}
public static Node createHeap(Node linkedlistroot)
{
	if(linkedlistroot==null)return null;
	Node root=linkedlistroot;
	linkedlistroot=linkedlistroot.rightChild;
	Queue<Node> queue=new LinkedList();
	queue.offer(root);
	while(!queue.isEmpty())
	{
		Node current=queue.poll();
		current.leftChild=null;
		current.rightChild=null;
		current.leftChild=linkedlistroot;
		if(current.leftChild!=null)
		{
			queue.offer(current.leftChild);
			linkedlistroot=linkedlistroot.rightChild;
		}
		current.rightChild=linkedlistroot;
		if(current.rightChild!=null)
		{
			queue.offer(current.rightChild);
			linkedlistroot=linkedlistroot.rightChild;
		}
	}
	return root;
}
public  static void createHeap(Node root,List<Integer> list)
{
	if(list.isEmpty() || list.size()==0)return;
	int i=0;
	root.value=list.get(i);
	i++;
	Queue<Node> queue=new LinkedList();
	queue.offer(root);
	while(!queue.isEmpty())
	{
		Node n=queue.poll();
		if(i<list.size())
		{
			n.leftChild=new Node();
			n.leftChild.value=list.get(i);
			queue.offer(n.leftChild);
			i++;
		}
		if(i<list.size())
		{
			n.rightChild=new Node();
			n.rightChild.value=list.get(i);
			queue.offer(n.rightChild);
			i++;
		}
	}
	
}
public static void inorderTraversal(Node root,List<Integer> list)
{
	if(root!=null)
	{
		inorderTraversal(root.leftChild,list);
		list.add(root.value);
		inorderTraversal(root.rightChild, list);
	}
}

}
