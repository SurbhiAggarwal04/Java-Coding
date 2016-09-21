package ArraysAndStrings;

public class IsCoprime {
	public static boolean isCoprime(int a, int b)
	{
		while(b != 0)
		{
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a == 1;
	}
public static void main(String[] args) {
	System.out.println(isCoprime(3, 5));
}
}
