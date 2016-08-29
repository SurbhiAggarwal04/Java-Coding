package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContinuousSubstringsOfAString {
public static void main(String[] args) {
	find("banana");
}
public static void find(String str)
{
	List<String> result=new ArrayList<>();
	Set<String> set=new TreeSet<>();
	//result.add(new String());
	char[] array=str.toCharArray();
	for(int i=0;i<array.length;i++)
	{
		System.out.println(result);
		char ch=array[i];
		int length=result.size();
		result.add(Character.toString(ch));
		for(int j=0;j<length;j++)
		{ 
			String s=result.get(j);
			if(i>0 && s.charAt(s.length()-1)==array[i-1])
			{
				result.add(s+ch);
			}
			
		}
		
	}
	
	set.addAll(result);
	System.out.println(result);
	System.out.println(set);
}
}
