package Trees;

import java.util.Stack;

public class PreOrderTraversal {
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
	System.out.println("Recursive Traversal");
	recursivePreorderTraversal(tree.root);
	
	System.out.println("Iterative Traversal");
	iterativePreorderTraversalVersion2(tree.root);
}
public static void recursivePreorderTraversal(Node root)
{
	if(root!=null)
	{
		System.out.println(root.value);
		recursivePreorderTraversal(root.leftChild);
		recursivePreorderTraversal(root.rightChild);
	}
}
public static void iterativePreorderTraversal(Node root)
{
	Stack<Node> stack=new Stack<Node>();
	while(true)
	{
		while(root!=null)
		{
			System.out.println(root.value);
			stack.push(root);
			root=root.leftChild;
		}
		if(stack.isEmpty())break;
		root=stack.pop();
		root=root.rightChild;
	}
}

public static void iterativePreorderTraversalVersion2(Node root)
{
	Stack<Node> stack=new Stack<Node>();
	stack.push(root);
	while(!stack.isEmpty())
	{
	 root=stack.pop();
	 System.out.println(root.value);
	 if(root.rightChild!=null)stack.push(root.rightChild);
	 if(root.leftChild!=null)stack.push(root.leftChild);
	}
}
public static Node nthSmallestElement(Node root, int n)
{
	Stack<Node> stack = new Stack<Node>();
	Node node = root;
	int i = 0;

	while(!stack.isEmpty() || node != null)
	{
		if(node != null)
		{
			stack.push(node);
			node = node.leftChild;
		}
		else
		{
			node = stack.pop();
			if(++i == n)
				return node;
			node = node.rightChild;
		}
	}

	return null;
}

public static Node nthSmallestElement(Node node, int n, int seenSoFar)
    {
	if(node == null)
               return null;

	Node temp = nthSmallestElement(node.leftChild, n, seenSoFar);

	if(temp != null)
               return temp;

	seenSoFar++;

	if(seenSoFar == n)
               return node;

	return nthSmallestElement(node.rightChild, n, seenSoFar);
}
}

