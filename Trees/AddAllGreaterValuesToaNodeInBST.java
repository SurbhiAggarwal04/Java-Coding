package Trees;

public class AddAllGreaterValuesToaNodeInBST {
	static int sum=0;
public static void main(String[] args) {
	BinaryTree tree=new BinaryTree();
	tree.insert(50);
	tree.insert(30);
	tree.insert(20);
	tree.insert(40);
	tree.insert(70);
	tree.insert(60);	
	tree.insert(80);
	add(tree.root);
	tree.displayTree(tree.root);
}
public static void add(Node root)
{
	if(root==null)return;
    add(root.rightChild);
    sum+=root.value;
    root.value=sum;
    add(root.leftChild);
}
}
