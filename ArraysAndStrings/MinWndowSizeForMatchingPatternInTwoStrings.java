package ArraysAndStrings;

import java.util.Arrays;

public class MinWndowSizeForMatchingPatternInTwoStrings {
public static void main(String[] args) {
	String input="ABBACBAA";
	String pattern="AAB";
	matchPattern(input,pattern);
}
public static void matchPattern(String input,String pattern)
{
	int patternL=pattern.length();
	int inputL=input.length();
	int[] needToFind=new int[256];
	int hasFound[]=new int[256];
	
	for(int i=0;i<patternL;i++)
	{
		needToFind[pattern.charAt(i)]++;
	}
	
	int minSize=Integer.MAX_VALUE;
	int minBeg=0;
	int minEnd=0;
	int count=0;
	for(int beg=0,end=0;end<input.length();end++)
	{
		
		if(needToFind[input.charAt(end)]==0)continue;
		
		hasFound[input.charAt(end)]++;
		if(hasFound[input.charAt(end)]<=needToFind[input.charAt(end)])count++;
		if(count==patternL)
		{
			System.out.println("new");
			while(needToFind[input.charAt(beg)]==0 || hasFound[input.charAt(beg)]>needToFind[input.charAt(beg)])
			{
				//System.out.println("inside");
				//System.out.println("beg:"+beg);
				//System.out.println(input.charAt(beg)+" "+hasFound[input.charAt(beg)]);
				if(hasFound[input.charAt(beg)]>needToFind[input.charAt(beg)])hasFound[input.charAt(beg)]--;
				beg++;
				
				
			}
			if(end-beg+1<minSize)
			{
				minSize=end-beg+1;
				minBeg=beg;
				minEnd=end;
			}
		}
	}
	System.out.println(minSize);
	System.out.println(minBeg);
}
}
