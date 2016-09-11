package Trees;

import java.util.ArrayList;

public class PrintValuesInGivenRange {
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
	ArrayList<Integer> result=new ArrayList<>();
	print(tree.root,5,13,result);
	System.out.println(result);
	System.out.println("new");
	result=print(tree.root,5,13);
	System.out.println(result);
	
}
public static void print(Node root,int k1,int k2,ArrayList<Integer> result)
{
	if(root==null)return;
	if(root.value>=k1)print(root.leftChild,k1,k2,result);
	if(root.value>=k1 && root.value<=k2)
		{
		System.out.print(root.value+" ");
		result.add(root.value);
		//print(root.leftChild,k1,k2);
		//print(root.rightChild,k1,k2);
		}
    if(root.value<=k2)print(root.rightChild,k1,k2,result);
	
		
	
	
}
public static ArrayList<Integer> print(Node root,int k1,int k2)
{
	ArrayList<Integer> result=new ArrayList<>();
	if(root!=null)
	{
	
	if(root.value>=k1)result.addAll(print(root.leftChild,k1,k2));
	if(root.value>=k1 && root.value<=k2)
		{
		System.out.print(root.value+" ");
		result.add(root.value);
		//print(root.leftChild,k1,k2);
		//print(root.rightChild,k1,k2);
		}
    if(root.value<=k2)result.addAll(print(root.rightChild,k1,k2));
	
	}
	return result;
	
	
}
}
