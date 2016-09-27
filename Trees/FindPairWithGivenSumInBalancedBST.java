package Trees;

import java.util.Stack;

public class FindPairWithGivenSumInBalancedBST {
public static void main(String[] args) {
	BinaryTree tree=new BinaryTree();
	tree.insert(15);
	tree.insert(10);
	tree.insert(8);
	tree.insert(12);
	tree.insert(20);
	tree.insert(16);	
	tree.insert(25);
	int target=33;
	find(tree.root,target);
}
public static void find(Node root,int target)
{
	if(root==null)return;
	Stack<Node> forwardInorder=new Stack();
	Stack<Node> reverseInorder=new Stack();
	Node forwardCurrent=root;
	Node reverseCurrent=root;
	int val1=0,val2=0;
	boolean forward = false,reverse = false;
	while(true)
	{
		while(!forward)
		{
			while(forwardCurrent!=null){
				forwardInorder.push(forwardCurrent);
				forwardCurrent=forwardCurrent.leftChild;
			}
			if(forwardInorder.isEmpty())forward=true;;
			forwardCurrent=forwardInorder.pop();
			val1=forwardCurrent.value;
			forwardCurrent=forwardCurrent.rightChild;
			forward=true;
		}
		while(!reverse)
		{
			while(reverseCurrent!=null)
			{
				reverseInorder.push(reverseCurrent);
				reverseCurrent=reverseCurrent.rightChild;
			}
			if(reverseInorder.isEmpty())reverse=true;
			reverseCurrent=reverseInorder.pop();
			val2=reverseCurrent.value;
			reverseCurrent=reverseCurrent.leftChild;
			reverse=true;
		}
		if(val1!=val2 && val1+val2==target)
		{
			System.out.println("val:"+val1+" val2:"+val2);
			return;
		}
		else if((val1+val2)<target)
		{
			forward=false;
		}
		else if((val1+val2)>target)
		{
			reverse=false;
		}
		if(val1>=val2)
		{
			System.out.println("No pair exists");
			return;
		}
	}
	
}
}
