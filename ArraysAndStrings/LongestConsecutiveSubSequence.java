package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import sun.security.util.Length;

public class LongestConsecutiveSubSequence {
public static void main(String[] args) {
	int n[]= {3, 1, 6, 10, 4, 20, 2};
	find(n);
}
public static void find(int[] n)
{
	Set<Integer> set=new TreeSet<Integer>();
	for(int i=0;i<n.length;i++)
		set.add(n[i]);
	int result=0;
	int start=0;
	for(int i=0;i<n.length;i++)
	{
		if(!set.contains(n[i]-1))
		{
			//System.out.println(n[i]);
			int length=0;
			int j=n[i]+1;
			while(set.contains(j))j++;
			length=j-n[i];
			//System.out.println("j:"+j);
			if(result<length)
				{
				start=n[i];
				result=length;
				}
			
		}
	}
	
	
	System.out.println("start:"+start);
	System.out.println("length:"+result);
	
	System.out.println("new way");
	int newElement=Integer.MIN_VALUE;
	int maxLength=Integer.MIN_VALUE;
	int maxStart=0;
    for(Integer i:set)
    {
    	if(i==newElement+1)
    	{
    		newElement=i;
    		if(i-start+1>maxLength)
    			{
    			maxStart=start;
    			maxLength=i-start+1;
    			}
    		
    	}
    	else start=i;
    	newElement=i;
    	
    }
    System.out.println("start:"+maxStart);
	System.out.println("length:"+maxLength);
	
}
}
