package ArraysAndStrings;

public class TowerOfHanoi {
public static void doHanoi(int discs, char frompeg, char topeg, char helppeg)
{
	if(discs==1)
	{
		System.out.println(frompeg + "->"+topeg);
	}
	else
	{
		doHanoi(discs-1,frompeg,helppeg,topeg);
		System.out.println(frompeg + "->"+topeg);
		doHanoi(discs-1,helppeg,topeg,frompeg);
	}
}
public static void main(String[] args) {
	doHanoi(3,'A','C','B');
}
}
