package ArraysAndStrings;

public class SameBirthdayProblem {
	public static double sameBirthday(int n)
	{		
		double np = 1;
 
		for(int i = 0; i < n; i++)
		{
			np*= (365.0-i)/365.0;
			System.out.println(np);
		}
			
 
		return 1-np;
	}
public static void main(String[] args) {
	System.out.println(sameBirthday(300));
}
}
