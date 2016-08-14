package ArraysAndStrings;

public class DuplicatesWithinKIndices {
	public static boolean containsDuplicates(String str, int k)
	{
		char[] array = str.toCharArray();
 
		boolean[] set = new boolean[256];
 
		for(int i = 0; i < array.length; i++)
		{
			char c = array[i];
 
			if(set[c])
				return true;
 
			set[c] = true;
 
			if(i - k >= 0)
				set[array[i -k]] = false;
		}
		return false;
 

}
	public static void main(String[] args) {
		System.out.println(containsDuplicates("abacda",2));
	}
}