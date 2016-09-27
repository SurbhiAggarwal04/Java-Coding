package Trees;

public class ConvertBSTtoDLL {
	private static class Result
	{
		Node head;
		Node tail;
		public Result(Node head,Node tail)
		{
			this.head=head;
			this.tail=tail;
		}
	}
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
	System.out.println("DLL");
	
	
	Result r=convert(tree.root);
	while(r.head!=null)
	{
		System.out.println(r.head.value);
		r.head=r.head.rightChild;
	}
}
public static Result convert(Node root)
{
	if(root==null)return new Result(null,null);
	Result l=convert(root.leftChild);
	root.leftChild=l.tail;
	if(l.tail!=null)
	l.tail.rightChild=root;
	Result r=convert(root.rightChild);
	root.rightChild=r.head;
	if(r.head!=null)r.head.leftChild=root;
	if(l.head!=null)
	{
		if(r.tail!=null)
			return new Result(l.head,r.tail);
		else
			return new Result(l.head,root);
	}
	else
	{
		if(r.tail!=null)
			return new Result(root,r.tail);
		else return new Result(root,root);
	}
			
}
}
