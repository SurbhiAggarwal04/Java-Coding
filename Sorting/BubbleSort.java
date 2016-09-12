package Sorting;

public class BubbleSort {
private int[] n;
public BubbleSort(int[] n) {
	// TODO Auto-generated constructor stub
	this.n=n;
}
public int[] sort()
{
	for(int i=0;i<n.length-1;i++)
	{int flag=0;
		for(int j=0;j<(n.length)-1-i;j++)
		{
			//flag=0;
			if(n[j]>n[j+1])
			{
				int temp=n[j];
				n[j]=n[j+1];
				n[j+1]=temp;
				flag=1;
			}
		}
		System.out.println("flag"+flag);
		System.out.println("i"+i);
		if(flag==0)
			break;
	}
	/*for(int i=0;i<n.length;i++)
	{
		System.out.println(n[i]);
	}*/
	return n;
}
}
