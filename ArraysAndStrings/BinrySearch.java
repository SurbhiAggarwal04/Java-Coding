package ArraysAndStrings;

public class BinrySearch {
public static boolean binarySearch(int[] n, int searchKey,int lowerbound,int upperbound)
{

int center=(int)(lowerbound+upperbound)/2;
System.out.println(searchKey +" "+n[center] );
if(searchKey==n[center])
	{
	System.out.println("matched");
	return true;
	}
if(searchKey>n[center])return binarySearch(n,searchKey,center+1,upperbound);
else return binarySearch(n,searchKey,lowerbound,center);



}
public static void main(String[] args) {
	int n[]=new int[]{1,2,3,4,5,6,7,8,9,10};
	System.out.println(binarySearch(n,7,0,n.length-1));
	if(binarySearch(n,7,0,n.length-1))System.out.println("found");
	else System.out.println("not found");
	
}
	
	
	
}
