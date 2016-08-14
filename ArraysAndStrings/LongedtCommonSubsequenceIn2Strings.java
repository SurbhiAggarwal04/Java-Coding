package ArraysAndStrings;

public class LongedtCommonSubsequenceIn2Strings {
public static void main(String[] args) {
	System.out.println(find("BDCABA","ABCBDAB"));
	System.out.println(longestCommonSubstring("BDCABA","ABCBDAB"));
}
public static String find(String A,String B)
{
	int m=A.length();
	int n=B.length();
	if(m==0 || n==0)return "";
	if(A.charAt(m-1)==B.charAt(n-1))
	{
		return find(A.substring(0,m-1),B.substring(0, n-1))+A.charAt(m-1);
	}
	
	String y=find(A.substring(0, m-1),B);
	String x=find(A,B.substring(0,n-1));
	/*if(x.length()>y.length())System.out.println(x);
	else System.out.println(y);*/
	return x.length()>y.length()?x:y;
	
}
private static String longestCommonSubstring(String s1, String s2)
{
    int start = 0;
    int length = 0;

    for (int i = 0; i < s1.length(); i++)
    {
        for (int j = 0; j < s2.length(); j++)
        {
            int x = 0;

            while (s1.charAt(i + x) == s2.charAt(j + x))
            {
                x++;
                if (((i + x) >= s1.length()) || ((j + x) >= s2.length())) break;
            }
            if (x > length)
            {
                length = x;
                start = i;
            }
         }
    }
    return s1.substring(start, (start + length));
}

}
