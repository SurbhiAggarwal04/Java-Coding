package ArraysAndStrings;

import java.util.Scanner;

public class StringUniquecharacter2 {
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	String input=scan.nextLine();
	int checker=0;
	int i;
	for(i=0;i<input.length();i++)
	{
		int value=input.charAt(i)-256;
		System.out.println(value);
		if((checker & (1<<value))>0)
		{
			
			System.out.println("Not unique characters");
			break;
		}
		//System.out.println("test "+ (int)1<<value);
		checker|=1<<value;
		System.out.println(Integer.toBinaryString(checker));
		
	}
	if(i>=input.length())
	{
		System.out.println("all unique characters");
	}
	
}
}
