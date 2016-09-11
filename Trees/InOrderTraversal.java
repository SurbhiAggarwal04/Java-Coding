package Trees;

import java.util.Stack;

public class InOrderTraversal {
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
	recursiveInorderTraversal(tree.root);
	
	System.out.println("Iterative Traversal");
	iterativeInorderTraversal(tree.root);
	//tree.displayTree(tree.root);
}
public static void recursiveInorderTraversal(Node root)
{
	if(root!=null)
	{
		recursiveInorderTraversal(root.leftChild);
		System.out.println(root.value);
		recursiveInorderTraversal(root.rightChild);
	}
}
public static void iterativeInorderTraversal(Node root)
{
	Stack<Node> stack=new Stack<Node>();
	while(true)
	{
		while(root!=null)
		{
			stack.push(root);
			root=root.leftChild;
		}
		if(stack.isEmpty())break;
	   root=stack.pop();
	   System.out.println(root.value);
	   root=root.rightChild;
	}
}
}
