package Trees;

public class FloorAndCeilFromaBST {
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);	
		tree.insert(80);
		int key=75;
        Node ceil=ceil(tree.root,key);
        System.out.println("ceil value for key:"+key+" is:"+ceil.value);
        Node floor=floor(tree.root,key);
        System.out.println("floor value for key:"+key+" is:"+floor.value);
        }

	public static Node ceil(Node root, int key) {
		if (root == null)
			return root;
		if (key == root.value)
			return root;
		if (key > root.value)
			return ceil(root.rightChild, key);
		Node l = ceil(root.leftChild, key);
		return l != null && l.value >= key ? l : root;
	}
	public static Node floor(Node root,int key)
	{
		if(root==null || root.value==key)return root;
		if(key<root.value)return floor(root.leftChild,key);
		Node r=floor(root.rightChild,key);
		return r!=null && r.value<=key?r:root;
	}
}
