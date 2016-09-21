package ArraysAndStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompressingString {
public static void main(String[] args) throws IOException {
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	String input=br.readLine();
	int compressedStringLength=findLength(input);
	System.out.println(compressedStringLength);
	if(compressedStringLength>=input.length())
	{
		System.out.println(input);
	}
	else
	{
		char character=input.charAt(0);
		int count=1;
		StringBuffer sbr=new StringBuffer();
		
		for(int i=1;i<input.length();i++)
		{
			if(input.charAt(i)==character)count++;
			else
			{
				sbr.append(character);
				sbr.append(count);
				character=input.charAt(i);
				count=1;
			}
		}
		sbr.append(character);
		sbr.append(count);
		System.out.println(sbr);
		
		
	}
}
static int findLength(String input)
{
	char character=input.charAt(0);
	int count=1;
	int size=0;
	for(int i=1;i<input.length();i++)
	{
		if(input.charAt(i)==character)count++;
		else
		{
			size +=1 + String.valueOf(count).length();
			character=input.charAt(i);
			count=1;
		}
	}
	size +=1 + String.valueOf(count).length();
	return size;
}
}
