package ArraysAndStrings;

import java.util.Scanner;

public class StringUniqueCharacters3 {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		String input=scan.nextLine();
		int checker=0;
		int i;
		for(i=0;i<input.length();i++)
		{
			int value=input.charAt(i)-256;
			if((checker & (1<<value))>0)
			{
				System.out.println("Not unique characters");
				break;
			}
			checker|=1<<value;
			
		}
		if(i>=input.length())
		{
			System.out.println("all unique characters");
		}
		
	}
}
