package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
public static void main(String[] args) {
	BinaryTree tree=new BinaryTree();
	tree.insert(0);
	tree.insert(-7);
	tree.insert(-8);
	/*tree.insert(-6);
	tree.insert(-9);
	tree.insert(-5);
	tree.insert(val);
	tree.insert(5);;
	tree.insert(15);
	tree.insert(2);
	tree.insert(10);*/
	tree.insert(50);
	tree.insert(60);
	tree.displayTree(tree.root);
	tree.find(100);
	tree.find(0);
	tree.find(50);
	System.out.println("find recursive");
	System.out.println(tree.find(tree.root,50));
	/*
	 * Binary Search Tree to Circular DLL
	 */
	/*System.out.println("Circular DLL result");
	Node DLLNode=tree.BST2DLLEfficient(tree.root);
	Node DLLCurrent=DLLNode;
	Node DLLNewNode=DLLNode.rightChild;
	while(true)
	{
		System.out.println(DLLCurrent.value);
		DLLCurrent=DLLCurrent.rightChild;
		if(DLLCurrent==DLLNode)break;
		
	}
	System.out.println("circular "+DLLCurrent.value);*/
	
	/*
	 * No of nodes in a tree
	 */
    System.out.println("No of nodes "+tree.noOfNodes(tree.root));
   
	/*
	 * Max value of a tree
	 */
	System.out.println(tree.max());
	
	/*
	 * Min valueof a tree
	 */
	System.out.println(tree.min());
	
	/*
	 * Print all paths from root to leaves
	 */
	System.out.println("all paths");
	int paths[]=new int[tree.depth(tree.root)];
	tree.finalAllPaths(tree.root,paths,0);
	/*
	 * deth of  a tree
	 */
	System.out.println("depth");
	System.out.println(tree.depth(tree.root));
	System.out.println(tree.depthNew(tree.root));
	/*
	 * Deepest node in the tree
	 */
	System.out.println("tree deepest Node ");
	HashMap<Integer,Node> hm=tree.deepest(tree.root, 0);
	Iterator it=(Iterator)hm.entrySet().iterator();
	Map.Entry pair=(Entry)it.next();
	Node node=(Node)pair.getValue();
	System.out.println(node.value);
	
	/*
	 * Tree to array
	 */
	tree.treeToArray();
	
	/*
	 * heapify after Tree to Array Conversion
	 */
	tree.heapify();
	tree.displayArray();
	
	/*
	 * Tree Balance check
	 */
	System.out.println("Balanced or not");
	System.out.println(tree.isBalanaced(tree.root));
	if(tree.efficientIsBalanced(tree.root)!=-1)
	System.out.println("balanced");
	else
		System.out.println("not balanced");
	
	/*
	 * subtree check
	 */
	
	System.out.println("Subtree check");
	BinaryTree  subTree=new BinaryTree();
	subTree.insert(50);
	subTree.insert(60);
	System.out.println(tree.subTree(tree.root,subTree.root));
    System.out.println("No of nodes "+subTree.noOfNodes(subTree.root));

	
	/*
	 * Minimum length Binary Search Tree from a sorted Array
	 */
	System.out.println("Minimum length BST");
	int arr[]=new int[]{1,2,3,4,5,6,7,8,9,10};
	BinaryTree t=BinaryTree.createMinLenBST(arr);
    t.displayTree(t.root);
    
    
    /*
     * recursive deletion
     */
  /*  System.out.println("recursive deletion");
    Node deleted=t.deleteNew(t.root, 8);
    t.displayTree(t.root);
    System.out.println("after insert");
    t.insert(8);
    t.displayTree(t.root);*/

    /*
     * Print all ancestors
     */
    System.out.println("Printing all ancestor of a node");
    t.printAllAncestor(t.root,4);
    /*
     * Linked list of nodes at each level of a tree
     */
    ArrayList<LinkedList<Node>> result=t.createLevelLinkedList();
    int i=0;
    System.out.println("size"+result.size());
    while(result.size()!=i)
    {
    	System.out.println("new");
    	LinkedList<Node> list=result.get(i);
    	i++;
    	for(int j=0;j<list.size();j++)
    	{
    		System.out.print(list.get(j).value);
    		System.out.print(" ");
    	}
    }
    /*
     * print all node values at a level through recursion
     */
    System.out.println("all nodes at a level through recursion");
    t.printAllNodesAtALevel(t.root,0,4);
    /*
     * Checks A tree is a BST
     */
    System.out.println("BST check");
    boolean res=t.checkBST(t.root);
    System.out.println(res);
    System.out.println("Efficient BST check");
    System.out.println(t.efficientCheckBST(t.root, -1, 100));
    System.out.println(tree.efficientCheckBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    
    
    /*
     * Finds Successor of a Node
     */
    System.out.println("Successor of a node");
    System.out.println(t.findInorderSuccessor(5).value);
    
    /*
     * Finds path in a tree with the specified sum
     */
    System.out.println("The path for the respective sum");
    int deth=t.depth(t.root);
    int [] path=new int[deth];
    t.findSum(t.root,path , 7, 0);
    
    /*
     * Nth smallest element in the tree
     */
    System.out.println("Nth smallest element");
    t.nthSmallestNumber(t.root, 7);
    
    /*
     * Closest Common ancestor of a tree
     */
    System.out.println("lowest Common Ancestor");
    Node a=new Node();
    a.value=6;
    Node b=new Node();
    b.value=9;
    Node n=t.closestCommonAncestor(t.root,a , b);
    System.out.println(n.value);
    
    System.out.println("Efficient Common Ancestor");
    a=new Node();
    a.value=6;
    b=new Node();
    b.value=7;
    n=t.commonAncestor(t.root, a, b);
    System.out.println(n.value);
    
    /*
     * Creates Tree from a postorder representation
     */
    System.out.println("Create Tree from Postoredr");
    int array[]=new int[]{1,7,5,50,40,10};
    Node postRoot=BinaryTree.createTreeFromPostOrderVersion1(array, 0, array.length-1);
  // Node postRoot=BinaryTree.createTreeFromPostOrder(array, Integer.MIN_VALUE, Integer.MAX_VALUE);
    BinaryTree postTree=new BinaryTree();
    postTree.root=postRoot;
    result=postTree.createLevelLinkedList();
    i=0;
   
    while(result.size()!=i)
    {
    	LinkedList<Node> list=result.get(i);
    	i++;
    	for(int j=0;j<list.size();j++)
    	{
    		System.out.print(list.get(j).value);
    		System.out.print(" ");
    	}
    	System.out.println();
    }
    
    
    /*
     * Finds Max value of subtraction(ancestor value-child value)
     */
    System.out.println("Max of subtraction");
   
    Map<Node,Integer> mapResult=BinaryTree.maxSubtractedValue(postTree.root);
    System.out.println(mapResult.entrySet().iterator().next().getValue());
    
    
    /*
     * Balanced Binary Search Tree from DLL
     */
    
    System.out.println("Tree from DLL");
    Node DLL1=new Node();
    DLL1.value=5;
    DLL1.rightChild=null;
   
    Node DLL2=new Node();
    DLL2.value=4;
    DLL2.rightChild=DLL1;
    
    Node DLL3=new Node();
    DLL3.value=3;
    DLL3.rightChild=DLL2;
    
    Node DLL4=new Node();
    DLL4.value=2;
    DLL4.rightChild=DLL3;
    
    Node DLL5=new Node();
    DLL5.value=1;
    DLL5.rightChild=DLL4;
    
    DLL5.leftChild=null;
    DLL4.leftChild=DLL5;
    DLL3.leftChild=DLL4;
    DLL2.leftChild=DLL3;
    DLL1.leftChild=DLL2;
    
    Node treeNode=BinaryTree.sortedDLL2BalancedBST(DLL5);
    BinaryTree treeFromDLL=new BinaryTree();
    treeFromDLL.root=treeNode;
    result=treeFromDLL.createLevelLinkedList();
    i=0;
    System.out.println("size"+result.size());
    while(result.size()!=i)
    {
    	System.out.println("new");
    	LinkedList<Node> list=result.get(i);
    	i++;
    	for(int j=0;j<list.size();j++)
    	{
    		System.out.print(list.get(j).value);
    		System.out.print(" ");
    	}
    }
    
    /*
     * To check if a binary tree is a heap or not
     */
    System.out.println("Tree max heap check");
    BinaryTree heapTree=new BinaryTree();
    Node heapTreeRoot=null;
    Node root=new Node();
    root.value=97;
    heapTreeRoot=root;
    root.leftChild=new Node();
    root.leftChild.value=46;

    root.rightChild=new Node();
    root.rightChild.value=37;
    
   Node rootL=root.leftChild;
   Node rootR=root.rightChild;
   
   rootL.leftChild=new Node();
   rootL.rightChild=new Node();
   rootL.leftChild.value=12;
   rootL.rightChild.value=3;
   
   rootL=rootL.leftChild;
   rootL.leftChild=new Node();
   rootL.rightChild=new Node();
   rootL.leftChild.value=6;
   rootL.rightChild.value=9;
   
   rootR.leftChild=new Node();
   rootR.rightChild=new Node();
   rootR.leftChild.value=7;
   rootR.rightChild.value=31;
   
   heapTree.root=heapTreeRoot;
   result=heapTree.createLevelLinkedList();
   i=0;
   System.out.println("size"+result.size());
   while(result.size()!=i)
   {
   	System.out.println("new");
   	LinkedList<Node> list=result.get(i);
   	i++;
   	for(int j=0;j<list.size();j++)
   	{
   		System.out.print(list.get(j).value);
   		System.out.print(" ");
   	}
   }
   if(heapTree.isMaxHeap(heapTree.root)!=-1)System.out.println("tree is a max heap");
   else System.out.println("tree is not a max heap");
   
   System.out.println("Tree max heap check");
   heapTree=new BinaryTree();
   heapTreeRoot=null;
   root=new Node();
   root.value=97;
   heapTreeRoot=root;
   root.leftChild=new Node();
   root.leftChild.value=46;

   root.rightChild=new Node();
   root.rightChild.value=37;
   
  rootL=root.leftChild;
  rootR=root.rightChild;
  
  rootL.leftChild=new Node();
  rootL.rightChild=new Node();
  rootL.leftChild.value=12;
  rootL.rightChild.value=3;
  
  rootL=rootL.rightChild;
  rootL.leftChild=new Node();
  rootL.rightChild=new Node();
  rootL.leftChild.value=2;
  rootL.rightChild.value=4;
  
  rootR.leftChild=new Node();
  rootR.rightChild=new Node();
  rootR.leftChild.value=7;
  rootR.rightChild.value=31;
  
  heapTree.root=heapTreeRoot;
  result=heapTree.createLevelLinkedList();
  i=0;
  System.out.println("size"+result.size());
  while(result.size()!=i)
  {
  	System.out.println("new");
  	LinkedList<Node> list=result.get(i);
  	i++;
  	for(int j=0;j<list.size();j++)
  	{
  		System.out.print(list.get(j).value);
  		System.out.print(" ");
  	}
  }
  if(heapTree.isMaxHeap(heapTree.root)!=-1)System.out.println("tree is a max heap");
  else System.out.println("tree is not a max heap");
   
    
    
}

}
