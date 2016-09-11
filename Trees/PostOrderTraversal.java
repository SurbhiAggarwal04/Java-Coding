package Trees;

import java.util.Stack;

public class PostOrderTraversal {
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
	recursivePostorderTraversal(tree.root);
	
	System.out.println("Iterative Traversal");
	iterativePostorderTraversal(tree.root);
	

}
public static void recursivePostorderTraversal(Node root)
{
	if(root!=null)
	{
		
		recursivePostorderTraversal(root.leftChild);
		recursivePostorderTraversal(root.rightChild);
		System.out.println(root.value);
	}
}
public static void iterativePostorderTraversal(Node root)
{
	Stack<Node> stack=new Stack<Node>();
	while(true)
	{
		
		if(root!=null){
		//	System.out.println("root.value:"+root.value);
		if(root.rightChild!=null)
		{
			stack.push(root.rightChild);
			stack.push(root);
		//	System.out.println("stack:"+root.rightChild.value+" "+root.value);
			root=root.leftChild;
		}
		else
		{
		stack.push(root);
		root=root.leftChild;
		}
		}
		else
		{
			root=stack.pop();
			
			if(root.rightChild!=null && !stack.isEmpty() && root.rightChild==stack.peek())
			{
				Node temp=stack.pop();
				stack.push(root);
				root=root.rightChild;
			}
			else
			{
				System.out.println(root.value);
				root=null;
			}
			
		}
		if(stack.isEmpty())break;
		
	}
	
	}

}

