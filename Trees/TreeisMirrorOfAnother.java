package Trees;
/*class Node
{
	int data;
	Node left;
	Node right;
}*/
public class TreeisMirrorOfAnother {
	public static boolean isMirror(Node n1, Node n2)
	{
		if(n1 == null && n2 == null)
			return true;
 
		if(n1 == null || n2 == null)
			return false;
 
		if(n1.value != n2.value)
			return false;
 
		return isMirror(n1.leftChild,n2.rightChild) && isMirror(n1.rightChild, n2.leftChild);
	}

}
