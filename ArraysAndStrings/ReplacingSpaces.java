package ArraysAndStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplacingSpaces {
	public static void main(String[] args) throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String input=br.readLine();
	input=input.trim();
	System.out.println("input "+input);
	/*char[] array=input.toCharArray();
	int newJ=array.length-1;
	int j=array.length-1;
	while(j>=0)
	{
		if(array[j]!=' ')
		{
			
		}
	}*/
	
	
	int newLength=input.length();
//	System.out.println(input.toCharArray());
	for(int i=0;i<input.length();i++)
	{
		if(input.charAt(i)==' ')
		{
			newLength+=2;
			System.out.println("newLength"+newLength);
		}
	}
	char[] inputArray=input.toCharArray();
//	System.out.println(inputArray.length);
	char[] outputArray=new char[newLength];
	
	for(int i=(inputArray.length)-1;i>=0;i--)
	{
		
		if(inputArray[i]==' ')
		{
			outputArray[newLength-1]='0';
			outputArray[newLength-2]='2';
			outputArray[newLength-3]='%';
			newLength-=3;
		}
		else
		{
			outputArray[newLength-1]=inputArray[i];
			newLength-=1;
		}
	}
	System.out.println(outputArray);
	StringBuffer sb=new StringBuffer(input);
	for(int i=0;i<sb.length();i++)
	{
		if(sb.charAt(i)==' ')
		{
			sb.replace(i,i+1,"%20");
			i+=3;
//			sb.insert(i,"%20");
			
		}
		
	}
	System.out.println(sb);

	
	}
}
