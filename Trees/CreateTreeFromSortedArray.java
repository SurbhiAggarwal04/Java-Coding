package Trees;

public class CreateTreeFromSortedArray {
public static void main(String[] args) {
	int[] array={1,2,3,4,5,6,7,8,9,10};
	BinaryTree tree=createMinLenBST(array);
	recursivePreorderTraversal(tree.root);
	tree=createMinLenBSTVersion2(array);
}
public static BinaryTree createMinLenBSTVersion2(int arr[])
{
	BinaryTree tree = new BinaryTree();
	Node node = createMinLenBST(arr, Integer.MIN_VALUE,Integer.MAX_VALUE );
	tree.root=node;
	tree.treeArray = arr;
	return tree;
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
public static BinaryTree createMinLenBST(int arr[]) {
	BinaryTree tree = new BinaryTree();
	Node node = createMinLenBST(arr, 0, arr.length - 1);
	tree.root = node;
	tree.treeArray = arr;
	return tree;
}

public static Node createMinLenBST(int arr[], int start, int end) {
	if (start <= end) {
		int mid = (start + end) / 2;
		Node n = new Node();
		n.value = arr[mid];
		n.leftChild = createMinLenBST(arr, start, mid - 1);
		n.rightChild = createMinLenBST(arr, mid + 1, end);
		return n;
	}
	return null;

}
}
