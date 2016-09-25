package Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
//Input Format 
//First line of input contains N, number of nodes in tree. Then N lines follow. Here each of ith line (1 <= i <= N) contains two integers, a b, where a is the index of left child, and b is the index of right child of ith node. -1 is used to represent null node. 
//Next line contain an integer, T. Then again T lines follows. Each of these line contains an integer K.
//
//Output Format 
//For each K, perform swap operation as mentioned above and print the inorder traversal of the current state of tree.
public class SwapNodes {
	   public static void main(String[] args) throws Exception{
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        int n=Integer.parseInt(br.readLine());
	        ArrayList<Node> list=new ArrayList();
	        for(int i=1;i<=n;i++)
	            {
	            Node root=new Node();
	            root.value=i;
	            list.add(root);
	        }
	        for(int i=1;i<=n;i++)
	            {
	            String[] arr=br.readLine().split(" ");
	            int l=Integer.parseInt(arr[0]);
	            int r=Integer.parseInt(arr[1]);
	            if(l!=-1)list.get(i-1).leftChild=list.get(l-1);
	            if(r!=-1)list.get(i-1).rightChild=list.get(r-1);
	        }
	        int t=Integer.parseInt(br.readLine());
	        for(int i=0;i<t;i++)
	            {
	            int testCase=Integer.parseInt(br.readLine());
	            int k=testCase;
	            int index=1;
	            while(k*index<n)
	                {
	                changeOrder(list.get(0),1,index*k);
	                index++;
	            }
	            print(list.get(0));
	            System.out.println();
	            
	        }
	    }
	    public static void print(Node root)
	        {
	        if(root!=null)
	          {
	            print(root.leftChild);
	            System.out.print(root.value+" ");
	            print(root.rightChild);
	        }
	    }
	    public static void changeOrder(Node root,int depth,int k)
	        {
	        if(depth>k)return;
	        else if(depth==k)
	            {
	            Node n=root.leftChild;
	            root.leftChild=root.rightChild;
	            root.rightChild=n;
	        }
	        else
	            {
	            if(root.leftChild!=null)
	            changeOrder(root.leftChild,depth+1,k);
	            if(root.rightChild!=null)
	            changeOrder(root.rightChild,depth+1,k);
	        }
	    }
}
