package ArraysAndStrings;

public class AllCurlyBraces {
	public static void printBraces(int n)
	{
		printBraces(new String(), n, n);
	}
 
	public static void printBraces(String str, int start, int end)
	{
		if(start == 0 && end == 0)
		{
			System.out.println(str);
			return;
		}
 
		if(start > 0)
		{
			printBraces(str+"{", start-1, end);
		}
 
		if(start < end)
		{
			printBraces(str+"}", start, end-1);
		}
	}
public static void main(String[] args) {
	printBraces(4);
}
}
