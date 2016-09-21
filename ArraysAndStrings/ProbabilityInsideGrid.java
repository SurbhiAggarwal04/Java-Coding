package ArraysAndStrings;

public class ProbabilityInsideGrid {
	static int total;
	static int favorable;
	public static void findProb(int p,int q,int moves)
	{
		if(moves==0)
		{
			total++;
			if((p>=0 && p<5) && (q>=0 && q<5))favorable++;
			return;
		}
		findProb(p-1,q,moves-1);
		findProb(p+1,q,moves-1);
		findProb(p,q-1,moves-1);
		findProb(p,q+1,moves-1);
	}
public static void main(String[] args) {
	int m=5,n=5;
	int p=3,q=3;
	int moves=3;
	findProb(p,q,moves);
	System.out.println("total "+total+" favoarble "+favorable);
	
	
}
}
