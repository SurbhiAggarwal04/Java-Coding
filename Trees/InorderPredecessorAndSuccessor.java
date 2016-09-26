package Trees;

public class InorderPredecessorAndSuccessor {
	private static class Result
	{
		Node predecessor;
		Node successor;
	}
public static void main(String[] args) {
	BinaryTree tree=new BinaryTree();
	tree.insert(50);
	tree.insert(30);
	tree.insert(20);
	tree.insert(40);
	tree.insert(70);
	tree.insert(60);	
	tree.insert(80);
	int key=60;
	Result r=find(tree.root,key);
	System.out.println("successor:"+r.successor.value);
	System.out.println("predecessor:"+r.predecessor.value);
}
public static Result find(Node root,int k)
{
	if(root==null)throw new NullPointerException("Element not found");
	if(root.value==k)
	{
		Node succesoor=root.rightChild;
		Node predecessor = root.leftChild;
		while(succesoor!=null && succesoor.leftChild!=null)
		{
			succesoor=succesoor.leftChild;
		}
		while(predecessor!=null && predecessor.rightChild!=null)predecessor=predecessor.rightChild;
		Result r=new Result();
		r.successor=succesoor;
		r.predecessor=predecessor;
		return r;
		
	}
	if(k<root.value)
	{
		Result r=find(root.leftChild,k);
		if(r.successor==null)r.successor=root;
		return r;
	}
	else
	{
		Result r=find(root.rightChild,k);
		if(r.predecessor==null)r.predecessor=root;
		return r;
	}
	
}
}
