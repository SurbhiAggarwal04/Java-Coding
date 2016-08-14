package ArraysAndStrings;

import java.util.ArrayList;

public class Anagram {
	public static  void permuteWord(char[] c,int size)
	
	{
		if(size==1)return;
	    for(int i=0;i<size;i++)
	    {
	    	permuteWord(c,size-1);
	    	if(size==2)
	    	{
	    	String str=new String(c);
	        System.out.println(str);
	    	}
	    	int position=c.length-size;
	    	char val=c[position];
	    	int j;
	        for(j=position+1;j<c.length;j++)
	        {
	        	c[j-1]=c[j];
	        }
	        c[j-1]=val;
	        System.out.println("after transformation "+new String(c));
	        
	    }
	}
	public static void permuteVersion2(String prefix,String input)
	{
		if(input.length()==0)
		{
			System.out.println(prefix);
		}
		else
		{
			for(int i=0;i<input.length();i++)
			{
				permuteVersion2(prefix+input.charAt(i), input.substring(0, i)+input.substring(i+1));
			}
		}
	}
	public static ArrayList<String> findPermutations(String str)
	{
		ArrayList<String> permutations = new ArrayList<String>();
		permutations.add(new String());
 
		char [] strArray = str.toCharArray();
 
		for(char c : strArray)
		{
			System.out.println(c);
			ArrayList<String> tempList = new ArrayList<String>();
 
			for(String s: permutations)
			{
				for(int i = 0; i < s.length(); i++)
					tempList.add(new String(s.substring(0, i) + c + s.substring(i, s.length() )));
				System.out.println("beforetemp:"+tempList);
				tempList.add(new String(s+c));
				System.out.println("temp:"+tempList);
			}
 
			permutations = tempList;
		}
 
		return permutations;
	}

public static void main(String[] args) {
	permuteWord("cat".toCharArray(),"cat".length());
	System.out.println("Anagram Version 2");
	permuteVersion2("", "cat");
	System.out.println("Anagram Version 3");
    ArrayList<String> result=findPermutations("cat");
    System.out.println(result);
	
}
}
