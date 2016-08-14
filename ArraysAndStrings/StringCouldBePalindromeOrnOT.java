package ArraysAndStrings;

import java.util.Arrays;

public class StringCouldBePalindromeOrnOT {
public static void main(String[] args) {
	String str="ababbccdd";
	System.out.println(isPalindrome(str));
	/*if(isPalindrome(str))
	{
		printAllPalindromes(str);
	}*/
	//System.out.println(isPalindromeNew(str));
}
public static void printAllPalindromes(String str)
{
	int freq[]=new int[26];
	for(int i=0;i<str.length();i++)
	{
		freq[str.charAt(i)-'a']++;
	}
	char oddCharacter = 0;
	StringBuffer half=new StringBuffer();
	
		for(int i=0;i<26;i++)
		{
			if(freq[i]%2==1)oddCharacter=(char) ('a'+i);
			//System.out.println("oddCharacter "+oddCharacter);
			for(int j=0;j<freq[i]/2;j++)
			{
				char charcter=(char)('a'+i);
				half.append(charcter);
				System.out.println("test "+half);
				//half+=(char)i+'a';
			}
		}
		String palin=half.toString();
		//System.out.println(half);
		System.out.println("palin "+palin);
		if(str.length()%2==1)palin+=oddCharacter;
		System.out.println("palin "+palin);
		//System.out.println("half reverse "+half.reverse());
		half=half.reverse();
	    System.out.println("palin "+palin);
		palin+=half;
		System.out.println(palin);
	
}
public static boolean isPalindromeNew(String str)
{
	char[] chars=str.toCharArray();
	Arrays.sort(chars);
	int oddCount=0;
	if(chars.length%2==1)oddCount=1;
	char c=chars[0];
	int count=1;
	int oddCountsFound=0;
	char oddChar = 0;
	String half="";
	
	for(int i=1;i<chars.length;i++)
	{
		if(chars[i]==c)count++;
		else
		{
			
			if(count%2==1)
				{
				oddChar=c;
				oddCountsFound++;
				}
			if((oddCount==0 && count%2==1) || (oddCount==1 && oddCountsFound>1))
			{
				System.out.println("not a palindrome");
				return false;
			}
			for(int j=0;j<count/2;j++)
			{
				half+=c;
			}
			c=chars[i];
			count=1;
		}
	}
	if(count%2==1)
		{
		oddChar=c;
		oddCountsFound++;
		}
	if((oddCount==0 && count%2==1) || (oddCount==1 && oddCountsFound>1))
	{
		System.out.println("not a palindrome");
		return false;
	}
	
	for(int j=0;j<count/2;j++)
	{
		half+=c;
	}
		StringBuffer rev=new StringBuffer(half);
		rev=rev.reverse();
		if(oddCount==1)
		half=half+oddChar;
		half=half+rev.toString();
		System.out.println(half);
	
	return true;
}
public static boolean isPalindrome(String str)
{
	int freq[]=new int[26];
	int oddCount=0;
	for(int i=0;i<str.length();i++)
	{
		freq[str.charAt(i)-'a']++;
		if(freq[str.charAt(i)-'a']%2==0)oddCount--;
		else oddCount++;
	}
	
	/*
	for(int j=0;j<26;j++)
	{
		if(freq[j]%2==1)oddCount++;
	}*/
	if((str.length()%2==1 && oddCount==1) || (str.length()%2==0 && oddCount==0))
	{
		return true;
	}
	return false;
	
}
}
