package ArraysAndStrings;

public class MaxProductSubArray {
public static void main(String[] args) {
	//int n[]={-1, -2, -1, 1, 7, -8, -2};
	int n[]={-1}; //output:1
	find(n);
	System.out.println("second");
	System.out.println(findMaxProduct(n, 0, n.length));
}
public static int findMaxProduct(int[] array, int begin, int end) {
	if(begin==array.length)return -1;
	if(begin==end)return array[begin];
	int noNegs = 0; // count of negative numbers in the array
	int zeroIndex = -1; // index where a '0' is present
	for ( int i = begin; i < end; ++i) {
		if (array[i] < 0) {
			++noNegs;
		}
		if (array[i] == 0) {
			zeroIndex = i;
		}
	}
	
	if (zeroIndex > 0) {
		int l = findMaxProduct(array, begin, zeroIndex);
		int r = findMaxProduct(array, zeroIndex+1, end);
		return Math.max(l, r);
	}
	
	if (noNegs % 2 == 0) {
		int product = 1;
		for (int i = begin; i < end; ++i) {
			product *= array[i];
		}
		return product;
	}
	
	int fi, bi; // forward and backward indices
	int fp = 1, bp = 1; // forward and backward products
	for (fi = begin; fi < end; ++fi) {
		fp *= array[fi];
		if (array[fi] < 0) {
			break;
		}
	}
	for(bi = end-1; bi >= begin; --bi) {
		bp *= array[bi];
		if (array[bi] < 0) {
			break;
		}
	}
	
	int product = 1;
	int pbegin = (fp>bp) ? fi+1 : begin;
	int pend = (fp>bp) ? end : bi;
	System.out.println(pbegin+" "+pend);
	if(pbegin==pend)return array[pbegin];
	for (int i = pbegin; i < pend; ++i) {
		product *= array[i];
	}
	System.out.println(product);
	return product;
}
public static int find(int[] n)
{
	int max=1;
	int min=1;
	int finalMax=1;
	int i=0;
	while(i<n.length)
	{
		if(n[i]>0)
		{
			max=Math.max(max*n[i], max);
			min=Math.min(min*n[i], min);
		}
		else if(n[i]==0)
		{
			max=1;
			min=1;
		}
		else
		{
			int temp=max;
			max=Math.max(min*n[i], max);
			min=Math.min(temp*n[i], min);
		}
		if(finalMax<max)finalMax=max;
		i++;
	}
	System.out.println("final value:"+finalMax);
	return finalMax;
}
}
