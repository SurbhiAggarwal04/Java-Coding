package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Passwords {
	public static List<String> getPasswords(String password, Map<Character, Character> map)
	{
		List<String> passwords = new ArrayList<String>();
 
		char [] array = password.toCharArray();
 
		for(int i = 0; i < array.length; i++)
		{
			Character sub = map.get(array[i]);
 
			if(sub != null)
			{
				int length = passwords.size();
 
				for(int j = 0; j < length; j++)
				{
					String str = passwords.get(j);
					passwords.add(new String(str.substring(0,i)+sub+str.substring(i+1)));
				}
 
				passwords.add(new String(password.substring(0,i)+sub+password.substring(i+1)));
			}
		}
 
		return passwords;
	}
	public static void printPasswords(String inputStr, int position, String outputStr,Map<Character, Character> cMap)
	{
		if(position == inputStr.length())
		{
			System.out.println(outputStr);
			return;
		}
			Character sub = cMap.get(inputStr.charAt(position));
			if(sub != null)
			{
				outputStr += sub;
				printPasswords(inputStr, position + 1, outputStr,cMap);
				outputStr = outputStr.substring(0, outputStr.length()-1);
			}
			
			outputStr += inputStr.charAt(position);
			printPasswords(inputStr, position + 1, outputStr,cMap);
 
	}
	public static void main(String[] args) {
		Map<Character, Character> cMap= new HashMap();
        cMap.put('i','!');
        cMap.put('a','@');
        cMap.put('s','$');
        cMap.put('o','0');
        cMap.put('E','3');
        System.out.println(getPasswords("password", cMap));
        printPasswords("password", 0, "", cMap);
	}
}
