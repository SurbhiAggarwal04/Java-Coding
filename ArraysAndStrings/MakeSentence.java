package ArraysAndStrings;

import java.util.Set;

public class MakeSentence {
	public static String makeSentence(String str, Set<String> dictionary)
	{
		char [] array = str.toCharArray();
 
		StringBuilder prefix = new StringBuilder();
 
		for(int i = 0; i < array.length; i++)
		{
			prefix.append(array[i]);
 
			if(dictionary.contains(prefix.toString()))
			{
				if (prefix.length() == array.length)
					return prefix.toString();
 
				String suffix = makeSentence(new String(array,prefix.length(),array.length-prefix.length()), dictionary);
 
				if(suffix != null)
				{
					prefix.append(" ");
					prefix.append(suffix);
					return prefix.toString();
				}
			}
		}
 
		return null;
	}

}
