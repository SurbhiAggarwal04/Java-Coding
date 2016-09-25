package Trees;
/*
 * Count BST subtrees that lie in given range
Given a Binary Search Tree (BST) of integer values and a range [low, high], 
return count of nodes where all the nodes under that node (or subtree rooted with that node) 
lie in the given range.

Examples:

Input:
        10
      /    \
    5       50
   /       /  \
 1       40   100
Range: [5, 45]
Output:  1 
There is only 1 node whose subtree is in the given range.
The node is 40 


Input:
        10
      /    \
    5       50
   /       /  \
 1       40   100
Range: [1, 45]
Output:  3 
There are three nodes whose subtree is in the given range.
The nodes are 1, 5 and 40 
 */
class Result
{
	boolean status;
	int count;
	public Result(boolean status,int count)
	{
		this.status=status;
		this.count=count;
	}
}
public class CountBStSubTreesThatLieInGivenRange {
public static void main(String[] args) {
	BinaryTree tree=new BinaryTree();
	tree.insert(10);
	tree.insert(5);
	tree.insert(1);
	tree.insert(50);
	tree.insert(40);
	tree.insert(100);
	int k1=1;
	int k2=45;
	int count=0;
	Result r=find(tree.root,k1,k2,count);
	System.out.println(r.count);
}
public static Result find(Node root,int k1,int k2,int count)
{
	if(root==null)
		{
		return new Result(true,0);
		}
	Result l=find(root.leftChild,k1,k2,count);
	Result r=find(root.rightChild,k1,k2,count);
	Result result=new Result(false, l.count+r.count);
	if(l.status && r.status && root.value>=k1 && root.value<=k2)
	{
		result.status=true;
		result.count+=1;
	}
    return result;
	
}
}
