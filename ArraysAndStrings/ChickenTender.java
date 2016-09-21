package ArraysAndStrings;

public class ChickenTender {
	public static boolean chicken (int n)
	{
		if(n < 0)
			return false;
 
		if(n % 6 == 0 || n % 9 == 0 || n % 20 == 0)
			return true;
 
		return chicken(n-6) || chicken(n-9) || chicken(n-20);
	}

}
