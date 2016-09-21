package ArraysAndStrings;

public class ASCIIToINTandRev {
	public static int asciiToInt(String str)
	{
		int result = 0;
 
		for(int i = 0; i < str.length();i++)
		{
			result*= 10;
			result+= str.charAt(i)-'0';
		}
 
		return result;
	}
 
	public static String intToAscii(int i)
	{
		StringBuilder sb = new StringBuilder();
 
		while(i != 0)
		{
			char c = (char) ('0'+(i%10));
			sb.insert(0,c);
			i/= 10;
		}
 
		return sb.toString();
	}

}
