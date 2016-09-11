package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	Node root;
	int size = 0;
	int[] treeArray;
	public static int small;
	public static int count = 0;
	public static int count1 = 0;
	static int index = 5;
	Node lTail;
	Node rTail;
	

	public BinaryTree() {
		root = null;
	}

	public void insert(int val) {

		if (root == null) {
			root = new Node();
			root.leftChild = null;
			root.rightChild = null;
			root.value = val;
			size++;
		} else {
			Node newNode = new Node();
			newNode.value = val;
			newNode.leftChild = null;
			newNode.rightChild = null;
			Node current = root;
			boolean leftChild = false;
			Node parent = current;
			while (current != null) {
				parent = current;
				if (val <= current.value) {
					leftChild = true;
					current = current.leftChild;
				} else
				{
					current = current.rightChild;
					leftChild=false;
				}
					
			}
			if (leftChild)
				parent.leftChild = newNode;
			else
				parent.rightChild = newNode;
			size++;
		}

	}

	public void displayTree(Node root) {
		if (root == null)
			return;
		System.out.println(root.value);
		displayTree(root.leftChild);
		displayTree(root.rightChild);

	}

	public boolean find(Node root, int key) {
		if (root == null)
			return false;
		if (root.value == key)
			return true;
		boolean res1 = find(root.leftChild, key);
		boolean res2 = find(root.rightChild, key);
		return res1 || res2;
	}

	public void find(int key) {
		if (root == null)
			System.out.println("The tree is empty");
		else {
			int level = 0;
			Node current = root;
			while (current.value != key) {
				if (key < current.value)
					current = current.leftChild;
				else
					current = current.rightChild;
				if (current == null)
					break;
				level++;
			}
			if (current == null) {
				System.out.println("Value not found");

			} else {
				System.out.println("Value found at level" + level);
			}

		}

	}

	public void delete(int key) {
		if (root == null) {
			System.out.println("The tree is empty");
		}

		else {
			boolean leftChild = false;
			Node current = root;
			Node parent = current;
			while (current.value != key) {
				parent = current;
				if (key < current.value) {
					leftChild = true;
					current = current.leftChild;
				} else
					current = current.rightChild;
				if (current == null)
					break;
			}
			if (current == null) {
				System.out.println("Value not found");
			} else {
				if (current.leftChild == null && current.rightChild == null) {
					System.out.println("The key is deleted");

					if (current == root) {
						System.out
								.println("The key is deleted and the tree is empty");
						root = null;
					} else {
						if (leftChild) {

							parent.leftChild = null;
						} else {
							parent.rightChild = null;
						}
					}
				} else if ((current.leftChild != null && current.rightChild == null)
						|| (current.leftChild == null && current.rightChild != null)) {
					if (current == root) {
						if (current.leftChild != null) {
							root = current.leftChild;
						} else
							root = current.rightChild;
					} else if (leftChild) {
						if (current.leftChild != null)
							parent.leftChild = current.leftChild;
						else
							parent.leftChild = current.rightChild;
					} else {
						if (current.leftChild != null)
							parent.rightChild = current.leftChild;
						else
							parent.rightChild = current.rightChild;
					}
				} else {
					Node successor = current.rightChild;
					Node parentSuccessor = current;
					while (successor.leftChild != null) {
						parentSuccessor = successor;
						successor = successor.leftChild;
					}
					if (successor != current.rightChild) {
						parentSuccessor.leftChild = successor.rightChild;
						successor.rightChild = current.rightChild;
					}
					successor.leftChild = current.leftChild;
					if (current == root) {
						root = successor;

					} else if (leftChild)
						parent.leftChild = successor;
					else
						parent.rightChild = successor;

				}
			}
		}
	}

	public Node deleteNew(Node root, int key) {
		if (root == null)
			return null;
		if (key < root.value)
			root.leftChild = deleteNew(root.leftChild, key);
		else if (key > root.value)
			root.rightChild = deleteNew(root.rightChild, key);
		else {
			if (root.leftChild != null && root.rightChild != null) {
				Node successor = root.rightChild;
				while (successor.leftChild != null) {
					successor = successor.leftChild;
				}
				root.value = successor.value;
				root.rightChild = deleteNew(root.rightChild, root.value);
			} else {
				if (root.leftChild != null) {
					root = root.leftChild;
				} else {
					root = root.rightChild;
				}
			}
		}
		return root;
	}

	public int max() {

		if (root == null)
			return 0;
		else {
			Node current = root;
			while (current.rightChild != null) {
				current = current.rightChild;
			}
			return current.value;
		}
	}

	public int min() {
		if (root == null)
			return 0;
		else {
			Node current = root;
			while (current.leftChild != null) {
				current = current.leftChild;
			}
			return current.value;
		}
	}

	public int depth(Node node) {
		if (node == null)
			return 0;
		int l = depth(node.leftChild);
		int r = depth(node.rightChild);
		return l > r ? l + 1 : r + 1;
	}

	public int depthNew(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		int height = 1;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();

			if (temp == null) {
				if (!queue.isEmpty()) {
					height++;
					queue.add(null);
				} else
					return height;

			} else {
				if (temp.leftChild != null)
					queue.offer(temp.leftChild);
				if (temp.rightChild != null)
					queue.offer(temp.rightChild);

			}
		}
		return height;
	}

	public HashMap<Integer, Node> deepest(Node node, int depth) {
		if (node == null)
			return null;
		if (node.leftChild == null && node.rightChild == null) {
			HashMap<Integer, Node> hm = new HashMap<>();
			hm.put(depth, node);
			return hm;
		}

		HashMap<Integer, Node> l = deepest(node.leftChild, depth + 1);
		HashMap<Integer, Node> r = deepest(node.rightChild, depth + 1);
		if (l == null)
			return r;
		else if (r == null)
			return l;
		Iterator itL = (Iterator) l.entrySet().iterator();
		Iterator itR = (Iterator) r.entrySet().iterator();
		Map.Entry pairL = (Entry) itL.next();
		Map.Entry pairR = (Entry) itR.next();
		if ((Integer) pairL.getKey() > (Integer) pairR.getKey())
			return l;
		else
			return r;

	}

	public boolean subTree(Node root, Node subRoot) {
		if (root == null)
			return false;
		if (root.value == subRoot.value) {
			return isIdentical(root, subRoot);
		}
		return subTree(root.leftChild, subRoot)
				|| subTree(root.rightChild, subRoot);

	}

	public int noOfNodes(Node root) {
		if (root == null)
			return 0;
		int l = noOfNodes(root.leftChild);
		int r = noOfNodes(root.rightChild);
		return l + r + 1;

	}

	public void finalAllPaths(Node node, int[] paths, int level) {
		if (node == null)
			return;
		paths[level] = node.value;
		if (node.leftChild == null && node.rightChild == null) {
			System.out.println("path");
			for (int i = 0; i <= level; i++) {
				System.out.print(paths[i] + " ");
			}
		}
		finalAllPaths(node.leftChild, paths, level + 1);

		finalAllPaths(node.rightChild, paths, level + 1);
	}

	public boolean isIdentical(Node root, Node subRoot) {
		if (root == null && subRoot == null)
			return true;
		if (root == null || subRoot == null)
			return false;
		if (root.value == subRoot.value)
			return true;
		return isIdentical(root.leftChild, subRoot.leftChild)
				&& isIdentical(root.rightChild, subRoot.rightChild);
	}

	public void treeToArray() {
		int nodes = depth(root);
		int n = (int) (Math.pow(2, nodes) - 1);
		treeArray = new int[n + 1];
		for (int i = 0; i < treeArray.length; i++)
			treeArray[i] = -1;
		treeToArray(root, 1);
		displayArray();
	}

	public void heapifyDown(int i) {

		if (treeArray[i] != -1) {
			int largest = i;
			int l = 2 * i;
			int r = 2 * i + 1;
			System.out.println("i" + i);
			if (l < treeArray.length && treeArray[i] < treeArray[l]) {
				largest = l;
			}
			if (r < treeArray.length && treeArray[r] > treeArray[largest])
				largest = r;
			System.out.println("largest" + largest);
			if (largest != i) {
				int temp = treeArray[i];
				treeArray[i] = treeArray[largest];
				treeArray[largest] = temp;
				i = largest;
				heapifyDown(largest);
			}
		}

	}

	public void heapify() {
		// for(int i=(treeArray.length-1)/2;i>=1;i--)
		// {
		// heapifyUp(i);
		// }

		for (int i = 0; i < treeArray.length / 5; i++)
			heapifyDown(1);
	}

	public void heapifyUp(int i) {

		if (treeArray[i] != -1) {
			int largest = i;
			int l = 2 * i;
			int r = 2 * i + 1;
			System.out.println("i" + i);
			if (l < treeArray.length && treeArray[i] < treeArray[l]) {
				largest = l;
			}
			if (r < treeArray.length && treeArray[r] > treeArray[largest])
				largest = r;
			System.out.println("largest" + largest);
			if (largest != i) {
				int temp = treeArray[i];
				treeArray[i] = treeArray[largest];
				treeArray[largest] = temp;
				heapifyUp(largest);
			}

		}

	}

	public void treeToArray(Node node, int index) {
		if (node != null) {
			System.out.println("index" + index);
			treeArray[index] = node.value;
			treeToArray(node.leftChild, 2 * index);
			treeToArray(node.rightChild, 2 * index + 1);
		}

	}

	public void displayArray() {
		for (int i = 0; i < treeArray.length; i++) {
			System.out.print(treeArray[i] + " ");
		}
	}

	public boolean isBalanaced(Node root) {
		if (root == null)
			return true;
		int diff = depth(root.leftChild) - depth(root.rightChild);
		if (Math.abs(diff) > 1)
			return false;
		return isBalanaced(root.leftChild) && isBalanaced(root.rightChild);

	}

	public int efficientIsBalanced(Node root) {
		if (root == null)
			return 0;
		int l = efficientIsBalanced(root.leftChild);
		if (l == -1)
			return -1;
		int r = efficientIsBalanced(root.rightChild);
		if (r == -1)
			return -1;
		if (Math.abs(l - r) > 1)
			return -1;
		return Math.max(l, r) + 1;

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

	public boolean printAllAncestor(Node root, int value) {
		if (root == null)
			return false;

		if (root.value == value)
			return true;
		if (printAllAncestor(root.leftChild, value)
				|| printAllAncestor(root.rightChild, value)) {
			System.out.println(root.value);
			return true;
		}
		return false;
	}

	public ArrayList<LinkedList<Node>> createLevelLinkedList() {
		if (root == null)
			return null;
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);

		while (list.size() > 0) {
			result.add(list);
			LinkedList<Node> current = new LinkedList<Node>();
			for (Node n : list) {
				if (n.leftChild != null)
					current.add(n.leftChild);
				if (n.rightChild != null)
					current.add(n.rightChild);
			}

			list = current;
		}
		return result;
	}

	/*
	 * If not like this then copy tree elements to an array and check if its
	 * sorted or not
	 */
	public boolean checkBST(Node n) {

		if (n == null)
			return true;
		if (!checkBST(n.leftChild))
			return false;
		System.out.println("n value " + n.value);
		System.out.println("small " + small);
		if (n.value <= small)
			return false;
		small = n.value;
		if (!checkBST(n.rightChild))
			return false;
		return true;

	}

	public boolean efficientCheckBST(Node n, int min, int max) {
		if (n == null)
			return true;
		if (n.value < min || n.value > max)
			return false;
		if (!efficientCheckBST(n.leftChild, min, n.value)
				|| !efficientCheckBST(n.rightChild, n.value, max))
			return false;
		return true;
	}

	public Node findInorderSuccessor(int value) {
		Node successor = null;

		if (root == null)
			return null;
		Node current = root;
		Node parent = null;
		while (current != null) {
			parent = current;
			if (value < current.value)
				current = current.leftChild;
			if (value > current.value)
				current = current.rightChild;
			else
				break;
		}
		if (current != null) {
			if (current.rightChild != null) {
				successor = current.rightChild;
				while (successor.leftChild != null)
					successor = successor.leftChild;

			}

			/*
			 * if node does not have a right subtree, and if node is the left
			 * child of its parent then successor is parent otherwise traverse
			 * upward till you reach a point where the node becomes the left
			 * subtree and return the parent where the node becomes the left
			 * child, this requires a pointer from child to the parent
			 */
		}
		return successor;

	}

	public void findSum(Node n, int[] path, int sum, int level) {
		if (n == null)
			return;
		path[level] = n.value;
		int temp = 0;

		for (int i = level; i >= 0; i--) {
			temp += path[i];
			// System.out.println("temp"+temp);
			if (temp == sum) {
				System.out.println("Path");
				for (int j = i; j <= level; j++) {
					System.out.println(path[j]);
				}
				break;
			}
		}
		findSum(n.leftChild, path, sum, level + 1);
		findSum(n.rightChild, path, sum, level + 1);
	}

	public void nthSmallestNumber(Node n, int nth) {
		// System.out.println("count "+count);
		if (n.leftChild != null)
			nthSmallestNumber(n.leftChild, nth);
		count++;
		if (count == nth) {
			System.out.println(n.value);
			return;
		}
		if (n.rightChild != null)
			nthSmallestNumber(n.rightChild, nth);

	}

	/* works when two nodes are on the different side of the seravhed node */
	public Node closestCommonAncestor(Node root1, Node a, Node b) {
		if (root1 == null)
			return null;
		if (root1.value == a.value || b.value == root1.value)
			return root1;
		/*
		 * System.out.println("left" + root1.value); //
		 * if(root1.value==8)System.out.println("8 left"+root1.leftChild.value);
		 */
		Node lNode = closestCommonAncestor(root1.leftChild, a, b);
		if (count1 == 2)
			return lNode;
		if (lNode != null)
			count1++;
		System.out.println("right" + root1.value);
		Node rNode = closestCommonAncestor(root1.rightChild, a, b);
		if (count1 == 2)
			return rNode;
		if (rNode != null)
			count1++;
		// else if(lNode!=null || rNode!=null)count1=count1+1;
		System.out.println("count1 " + count1);
		System.out.println(root1.value);
		if (count1 == 2)
			return root1;
		return null;

	}

	public boolean isLeft(Node root, Node a) {
		if (root == null)
			return false;
		if (root.value == a.value)
			return true;
		return isLeft(root.leftChild, a) || isLeft(root.rightChild, a);
	}

	public Node commonAncestor(Node root, Node a, Node b) {
		if (root == null)
			return null;
		if (root.value == a.value || root.value == b.value)
			return root;
		boolean aNodeIsLeft = isLeft(root.leftChild, a);
		System.out.println("a node position " + aNodeIsLeft);

		boolean bNodeIsLeft = isLeft(root.leftChild, b);
		System.out.println("b node position " + bNodeIsLeft);

		if (aNodeIsLeft != bNodeIsLeft) {
			return root;
		} else {
			if (aNodeIsLeft) {
				return commonAncestor(root.leftChild, a, b);
			} else {
				return commonAncestor(root.rightChild, a, b);
			}
		}

	}

	public static Node createTreeFromPostOrderVersion1(int[] array,
			int startIndex, int endIndex) {

		int i = endIndex;
		int root = array[i];
		Node node = null;
		if (startIndex <= endIndex) {
			node = new Node();
			node.value = root;

			i = i - 1;
			int smallEleIndex = i;
			while (i >= 0 && array[i] >= root) {
				i--;
				smallEleIndex = i;
			}
			if (smallEleIndex >= 0) {
				node.leftChild = createTreeFromPostOrderVersion1(array,
						startIndex, smallEleIndex);
				node.rightChild = createTreeFromPostOrderVersion1(array,
						smallEleIndex + 1, endIndex - 1);
			}

		}
		return node;
	}

	public static Node createTreeFromPostOrder(int[] array, int min, int max) {
		if (index == -1)
			return null;
		Node node = null;
		System.out.println("array at index " + array[index]);

		if (index >= 0) {
			if (array[index] >= min && array[index] <= max) {
				node = new Node();
				node.value = array[index];
				index--;
				node.rightChild = createTreeFromPostOrder(array, node.value,
						max);
				node.leftChild = createTreeFromPostOrder(array, min, node.value);

			}
		}
		return node;
	}

	public static void remove(int[] array, int index) {
		if (index < 0 || index > array.length)
			return;
		for (int i = index; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
	}

	public static Map<Node, Integer> maxSubtractedValue(Node root) {

		if (root == null)
			return null;
		if (root.leftChild == null && root.rightChild == null) {
			Map<Node, Integer> map = new HashMap<Node, Integer>();
			map.put(root, 0);
			return map;
		}

		System.out.println("root " + root.value);
		// System.out.println("left"+root.leftChild.value);
		// System.out.println("right"+root.rightChild.value);

		Map<Node, Integer> lmap = maxSubtractedValue(root.leftChild);
		Map<Node, Integer> rmap = maxSubtractedValue(root.rightChild);
		int diff = 0, lMax = 0, rMax = 0, max = 0;
		Node min = null;
		int lValue = 0;
		int rValue = 0;
		if (lmap != null) {
			lValue = lmap.entrySet().iterator().next().getKey().value;
			lMax = lmap.entrySet().iterator().next().getValue();

		}
		if (rmap != null) {
			rValue = rmap.entrySet().iterator().next().getKey().value;
			rMax = rmap.entrySet().iterator().next().getValue();
		}
		if (lmap == null || rValue <= lValue) {
			diff = root.value - rValue;
			min = root.rightChild;

		}

		else if (rmap == null || lValue < rValue) {
			diff = root.value - lValue;
			min = root.leftChild;

		}

		if (root.value < min.value)
			min = root;
		if (lMax > rMax)
			max = lMax;
		if (diff > max)
			max = diff;
		Map<Node, Integer> map = new HashMap<Node, Integer>();
		map.put(min, max);
		return map;

	}

	public void printAllNodesAtALevel(Node root, int level, int key) {
		if (root == null)
			return;
		if (level == key) {
			System.out.println(root.value);
			return;
		}
		printAllNodesAtALevel(root.leftChild, level + 1, key);
		printAllNodesAtALevel(root.rightChild, level + 1, key);
	}

	public Node BST2DLL(Node root) {
		if (root == null) {
			lTail = null;
			return null;
		}
		Node left = BST2DLL(root.leftChild);
		root.leftChild = lTail;
		if (left != null)
			lTail.rightChild = root;

		Node right = BST2DLL(root.rightChild);

		root.rightChild = right;
		if (right == null) {
			lTail = root;
			if (left != null)
				root.rightChild = left;
			else
				root.rightChild = root;

		} else {
			right.leftChild = root;
			Node rightCurrent = right.rightChild;

			while (rightCurrent != null && rightCurrent.rightChild != right) {
				rightCurrent = rightCurrent.rightChild;

			}
			lTail = rightCurrent;
			if (left != null) {
				if (rightCurrent != null)
					rightCurrent.rightChild = left;
				else
					right.rightChild = left;
			} else {
				if (rightCurrent != null)
					rightCurrent.rightChild = root;
				else
					right.rightChild = root;

			}
		}
		if (left != null)
			return left;
		return root;

	}

	public Node BST2DLLEfficient(Node root) {
		if (root == null) {
			lTail = null;
			return null;
		}
		Node left = BST2DLLEfficient(root.leftChild);

		root.leftChild = lTail;
		if (left != null)
			lTail.rightChild = root;

		Node right = BST2DLLEfficient(root.rightChild);
		root.rightChild = right;
		if (right == null) {
			lTail = root;
			rTail = root;
			if (left != null)
				root.rightChild = left;
			else
				root.rightChild = root;

		} else {
			right.leftChild = root;
			lTail = rTail;

			if (left != null)
				rTail.rightChild = left;
			else
				rTail.rightChild = root;
		}
		if (left != null)
			return left;
		return root;

	}

	public static Node sortedDLL2BalancedBST(Node root) {

		if (root == null)
			return null;
		if (root.rightChild == null) {
			root.leftChild = null;
			root.rightChild = null;
			return root;
		}
		Node fast = root, slow = root;
		while (slow != null && fast != null && fast.rightChild != null) {
			slow = slow.rightChild;
			fast = fast.rightChild.rightChild;
		}
		Node treeRoot = new Node();
		treeRoot.value = slow.value;
		fast = slow.rightChild;
		slow.leftChild.rightChild = null;

		treeRoot.leftChild = sortedDLL2BalancedBST(root);
		treeRoot.rightChild = sortedDLL2BalancedBST(fast);

		return treeRoot;

	}

	public int isMaxHeap(Node root) {
		if (root.leftChild == null && root.rightChild == null)
			return 1;
		if (root.leftChild != null && root.rightChild == null
				&& root.value > root.leftChild.value)
			return 2;

		int l = isMaxHeap(root.leftChild);
		int r = isMaxHeap(root.rightChild);
		if (l == -1 || r == -1 || l - r > 1 || l-r<0)
			return -1;
		if (root.value > root.leftChild.value
				&& root.value >= root.rightChild.value)
			return Math.max(l, r)+1;
		return -1;

		
	}
}
