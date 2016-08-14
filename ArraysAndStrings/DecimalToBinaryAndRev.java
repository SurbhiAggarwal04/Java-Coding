package ArraysAndStrings;

public class DecimalToBinaryAndRev {
	public static String decimalToBinary(int n)
	{
		StringBuilder sb = new StringBuilder();
 
		while(n != 0)
		{
			sb.insert(0, n%2);
			n/=2;
		}
 
		return sb.toString();
	}
 
	public static int binaryToDecimal (String input)
	{
		int i = 0;
 
		int j = 1;
 
		for(int k = input.length()-1; k >= 0; k--)
		{
			if(input.charAt(k) == '1')
			{
				i += j;
			}
			j*=2;
		}
 
		return i;
	}

}
