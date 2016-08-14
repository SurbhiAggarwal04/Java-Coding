package ArraysAndStrings;

public class PatternMatching {
	public static boolean isMatch(String string, String pattern)
	{
		if((pattern==null || pattern.length()==0) && string.length()!=0)
				{
			return false;
			
				}
		if((pattern.length()==1 && string.length()==1 && pattern.equals(".")) || pattern.equals(string)|| (pattern.equals("*")))
		{
			return true;
		}
		char first = pattern.charAt(0);
		
		if (first!='.' && first!='*')
		{
			if(first==string.charAt(0))return isMatch(string.substring(1),pattern.substring(1));
			else return isMatch(string,pattern.substring(1));
		}
		else if(first=='*')
		{
			int i=0;
		   char second=pattern.charAt(1);
			while(string.charAt(i)!=second)i++;
			if(i>string.length())return false;
			else return isMatch(string.substring(i+1), pattern.substring(2));
		}
		else if(first=='.')
		{
			return isMatch(string.substring(1),pattern.substring(1));
		}
		return false;
	}
public static void main(String[] args) {
	System.out.println(isMatch("aa", "a"));

System.out.println(isMatch("aa", "aa"));

System.out.println(isMatch("aaa", "aa"));

System.out.println(isMatch("aa", "a*"));

System.out.println(isMatch("aab", "c*a*b"));
}
}
