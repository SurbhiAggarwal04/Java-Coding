package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringAnagramOrNot {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	String input=scan.nextLine();
	String inputanag=scan.nextLine();
	if(input.length()!=inputanag.length())
	{
		System.out.println("Not anagrams");
	}
	else
	{
		Map<Character, Integer> map=new HashMap<>();
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			if(map.containsKey(ch))
			{
				int count=map.get(ch);
				map.put(ch, ++count);
			}
			else
				map.put(ch, 1);
		}
		for(int i=0;i<inputanag.length();i++)
		{
			char ch=inputanag.charAt(i);
			if(map.containsKey(ch))
			{
				int count=map.get(ch);
				if(count==1)map.remove(ch);
				else map.put(ch, --count);
			}
			else
			{
				System.out.println("Not anagrams");
				System.exit(1);
			}
		}
		if(map.isEmpty())System.out.println("Anagrams");
		else System.out.println("Not anagrams");
		char[] inputArray=input.toCharArray();
		char[] inputanagArray=inputanag.toCharArray();
		Arrays.sort(inputArray);
		Arrays.sort(inputanagArray);
		if(Arrays.equals(inputArray, inputanagArray))
		{
			System.out.println("Anagrams");
		}
		else
		{
			System.out.println("Not anagrams");
		}
	}
}
}
