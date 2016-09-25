package ArraysAndStrings;

import java.util.Arrays;
/*
 * Replace every element with the least greater element on its right
Given an array of integers, replace every element with the least greater element on its right side in the array. If there are no greater element on right side, replace it with -1.

Examples:

Input: [8, 58, 71, 18, 31, 32, 63, 92, 
         43, 3, 91, 93, 25, 80, 28]
Output: [18, 63, 80, 25, 32, 43, 80, 93, 
         80, 25, 93, -1, 28, -1, -1]
 */
class ReplaceNode
{
	int data;
	ReplaceNode left;
	ReplaceNode right;
}
public class ReplaceEveryElementWithLeastGreaterOnItsRight {
public static void main(String[] args) {
	int input[]={8, 58, 71, 18, 31, 32, 63, 92, 
	             43, 3, 91, 93, 25, 80, 28};
	replace(input);
	System.out.println(Arrays.toString(input));
}
public static ReplaceNode insert(ReplaceNode root,ReplaceNode replacement,int data)
{
	if(root==null)
		{
	    root=new ReplaceNode();
		root.data=data;
		 
		}
	else
	{
		if(data<root.data)
		{
			replacement.data=root.data;
			//System.out.println(data+" "+replacement.data);
			root.left=insert(root.left,replacement,data);
		}
		else
		{
			root.right=insert(root.right,replacement,data);
		}
	}
	return root;
}
public static void replace(int[] n)
{
	ReplaceNode root=null;
	for(int i=n.length-1;i>=0;i--)
	{
		ReplaceNode replacement=new ReplaceNode();
		replacement.data=-1;
		root=insert(root,replacement,n[i]);
		//System.out.println(root.data);
		//System.out.println("replacement:"+replacement);
		n[i]=replacement.data;
		
	
	}
}
}
