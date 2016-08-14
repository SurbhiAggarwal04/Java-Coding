package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstringOfAString {
public static void main(String[] args) {
	System.out.println(find("0a1230a45a6"));
}
public static String find(String s)
{
	Set<Character> set=new HashSet<>();
	char[] array=s.toCharArray();
	int maxLength=Integer.MIN_VALUE;
	int start=0;
	int currentStart=0;
	for(int i=0;i<array.length;i++)
	{
		Character c=array[i];
		if(!set.contains(c))
		{
			set.add(c);
		}
		else
		{
			if(i-currentStart>maxLength)
				{
				start=currentStart;
				maxLength=i-currentStart;
				}
			System.out.println(set);
			while(currentStart<array.length && array[currentStart]!=c)
			{
				set.remove(array[currentStart]);
				currentStart++;
			}
			System.out.println(set);
			currentStart=currentStart+1;
		}
	}
	System.out.println(maxLength);
	return s.substring(start, start+maxLength);
}
}
