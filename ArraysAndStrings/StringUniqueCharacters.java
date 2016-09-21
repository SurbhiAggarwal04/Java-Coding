package ArraysAndStrings;

import java.util.Scanner;

public class StringUniqueCharacters {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	String input=scan.next();
	
	
	/* bubble sort checks the adjacent letters not one letter with all other letters*/
	/* bad strategy as the time complexity is n^2
	for(int i=0;i<input.length()-1;i++)
	{
		for(int j=i+1;j<input.length();j++)
		{
			if(input.charAt(i)==input.charAt(j))
			{
				System.out.println(input.charAt(i)+" "+input.charAt(j));
				System.out.println("duplicate found");
				System.exit(0);
			}
		}
	}
	
	System.out.println("No duplicates");
	*/
	
	boolean[] charStatus=new boolean[256];
	if(input.length()>256)
	{
		System.out.println("duplicates");
		System.exit(0);
	}
	for(int i=0;i<input.length();i++)
	{
		int index=input.charAt(i);
		if(charStatus[index])
		{
			System.out.println("duplicates");
			System.exit(0);
		}
		charStatus[index]=true;
	}
	System.out.println("No duplicates");
	
}
}
