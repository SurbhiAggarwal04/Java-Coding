package ArraysAndStrings;
/*
 * 2^6= 2^3^2
 */
public class EfficientPower {
	public static int power(int a, int b) //a & b are both positive
	{
		if(b == 0)
			return 1;
 
		if(b == 1)
			return a;
 
		int result = power(a, b/2);
        System.out.println("result:"+result);
		if(b % 2 == 0)
			return result * result;
 
		return result * result * a;		
	}
	public static void main(String[] args) {
		System.out.println(power(2, 6));
	}
}
