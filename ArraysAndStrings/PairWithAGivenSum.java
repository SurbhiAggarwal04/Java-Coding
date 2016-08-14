package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class PairWithAGivenSum {
public static void main(String[] args) {
	int n[]={1,2,3,4,5,6,7,7,6,5,4,3,2,1,18,-10};
	Map<Integer,Integer> map=new HashMap<>();
	int i=0;
	int sum=8;
	while(i<n.length)
	{
		int target=sum-n[i];
		if(map.containsKey(target))
		{
			System.out.println("Pair "+n[i]+" "+target);
		}
		else
			map.put(n[i], 0);
		i++;
		
	}
}
}
