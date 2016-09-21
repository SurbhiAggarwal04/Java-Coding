package ArraysAndStrings;

import java.util.Scanner;

public class PalindromeUsingBitOperators {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
    int input=scan.nextInt();
    int l=0;
    int r=31;
    while(l<r)
    {
    	if((input&(1<<l))!=(input&(1<<r)))
    	{
    		System.out.println("Not palindrome");
    		break;
    	}
    	l++;
    	r--;
    }
    if(l>=r)
    	System.out.println("Palindrome");
    
}
}
