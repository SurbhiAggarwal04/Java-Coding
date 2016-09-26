package Trees;

public class RemoveBSTkeysOutsideGivenRange {
public static void main(String[] args) {
	BinaryTree tree=new BinaryTree();
	tree.insert(6);
	tree.insert(-13);
	tree.insert(-8);
	tree.insert(14);
	tree.insert(13);
	tree.insert(7);	
	tree.insert(15);
	int k1=-10;
	int k2=13;
	System.out.println("Preorder traversal of a tree");
	tree.displayTree(tree.root);
	System.out.println("After replacing values lying outside range");
	Node root=replace(tree.root,k1,k2);
	tree.displayTree(root);
}
public static Node replace(Node root,int k1,int k2)
{
	if(root==null)return null;
	
	root.leftChild=replace(root.leftChild,k1,k2);
	root.rightChild=replace(root.rightChild, k1, k2);
	if(root.value<k1)return root.rightChild;
	else if(root.value>k2)return root.leftChild;
	return root;
	
}
}
