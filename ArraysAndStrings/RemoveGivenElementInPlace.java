package ArraysAndStrings;
import java.util.Arrays;

public class RemoveGivenElementInPlace {
public static void main(String[] args) {
	int []n={1,4,1,2,5,5,8,1,1,1,5};
	remove(n,1);
	System.out.println("new");
	n=new int[]{1,4,1,2,5,5,8,1,1,1,5};
	remove1(n,1);
}
public static void remove1(int n[],int k)
{
	int i=0;
	int index=0;
	while(i<n.length)
	{
		if(n[i]!=k)
		{
			n[index]=n[i];
			i++;
			index++;
		}
		else i++;		
	}
	System.out.println(Arrays.toString(n));
}
public static void remove(int []n,int k)
{
	int index=0;
	for(int i=0;i<n.length;i++)
	{
		System.out.println("n[i]:"+n[i]);
		if(n[i]==k)
		{
			while(i<n.length && n[i]==k)i++;
			if(i<n.length)
			{
				n[index]=n[i];
				index++;
			}
		
			
		}
		else
		{
			  n[index]=n[i];
			  index++;
		}
	    
		System.out.println("n[index]:"+n[index]);
        
		
		
	}
	
	System.out.println(Arrays.toString(n));
	for(int i=0;i<index;i++)
	{
		System.out.print(n[i]+" ");
	}
}
}
