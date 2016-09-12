package Sorting;

public class ArrayClass extends BubbleSort{
private static int[] num;

public ArrayClass(int[] n) {
	// TODO Auto-generated constructor stub
super(n);
this.num=n;

}

public static void main(String args[])
{
ArrayClass array=new ArrayClass(new int[]{1,2,3,4,5,6,7,8,10,9,4});
int n[]=array.sort();
for(int i=0;i<n.length;i++)
{
	System.out.println(n[i]);
}
//System.out.println(n.length);
}
}
