package Trees;

public class TreeFromPreOrderAndInOrder {
	static int index=0;
public static void main(String[] args) {
	int pre[]={8,2,3,4,5,6,7,9,10,11,12};
	int in[]={2,3,4,5,6,7,8,9,10,11,12};
	Node node=formTree(pre,0,pre.length-1,in,0,in.length-1);
	recursivePreorderTraversal(node);
	
	System.out.println("only from preorder");
	node=formTreeFromPree(pre, 0, pre.length-1);
	recursivePreorderTraversal(node);
	System.out.println("only from preorder");
	node=formTreeFromPreev1(pre,Integer.MIN_VALUE, Integer.MAX_VALUE);
	recursivePreorderTraversal(node);
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
public static Node formTreeFromPreev1(int[] array, int min, int max) {
	if (index>=array.length)
		return null;
	Node node = null;
	System.out.println("array at index " + array[index]);

	if (index <= array.length-1) {
		if (array[index] > min && array[index] < max) {
			node = new Node();
			node.value = array[index];
			index++;
			node.leftChild = formTreeFromPreev1(array, min, node.value);
			node.rightChild = formTreeFromPreev1(array, node.value,
					max);
			

		}
	}
	return node;
}
public static Node formTreeFromPree(int[] pre,int start,int end)
{
	Node node =null;
	if(start<=end)
	{
		node =new Node();
		node.value=pre[start];
		int i=start+1;
		while(i<=end && pre[i]<node.value)
		{
			i++;
		}
		
		if(i>=0)
		{
			//System.out.println(node.value+" "+pre[i]);
		node.leftChild=formTreeFromPree(pre, start+1, i-1);
		node.rightChild=formTreeFromPree(pre, i, end);
		}
		
	}
	return node;
}
public static Node formTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn)
{
	if(startPre>endPre || startIn>endIn)return null;
	Node root=new Node();
	root.value=pre[startPre];
	System.out.println("root value:"+root.value);
	int i=startIn;
	int rootIndex=-1;
	while(i<=endIn)
	{
		if(in[i]==root.value)rootIndex=i;
		i++;
	}
	System.out.println("index value:"+in[rootIndex]);
	//System.out.println("mid1-1:"+(rootIndex-startIn1));

	root.leftChild=formTree(pre, startPre+1, rootIndex+startPre-startIn, in,startIn, rootIndex-1);
	root.rightChild=formTree(pre, rootIndex+startPre-startIn+1, endPre, in, rootIndex+1, endIn);
	return root;
}
}
