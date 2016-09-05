package StacksAndQueues;
import java.util.*;
public class LargestRectangleAreaInAHistogram {
public static void main(String[] args) {
	int[] hist={6,2,5,4,5,1,6};
	System.out.println(getMaxArea(hist));
}
public static int getMaxArea(int[] h)
{
	java.util.Stack<Integer> s=new java.util.Stack<Integer>();
	int i=0;

	int maxArea=0;
	while(i<h.length)
	{
		System.out.println("hist value:"+h[i]);
		System.out.println("stack:"+s);
		if(s.isEmpty() || h[i]>=h[s.peek()])s.push(i++);
		else
		{
			int tp=s.pop();
			maxArea=Math.max(maxArea, h[tp]*(s.isEmpty()?i:i-1-s.peek()));
			System.out.println("local Area:"+ h[tp]*(s.isEmpty()?i:i-1-s.peek()));
			System.out.println("maxArea:"+maxArea);
		}
	}
	while(!s.isEmpty())
	{
		System.out.println("while");
		int tp=s.pop();
		maxArea=Math.max(maxArea, h[tp]*(s.isEmpty()?i:i-1-s.peek()));
		System.out.println("maxArea:"+maxArea);
	}
	return maxArea;
	
}
}
