package ArraysAndStrings;

import java.util.Arrays;

public class SwapStringStartEnd {
public static void main(String[] args) {
	String str="I am Surbhi Aggarwal";
	int i=0;
	String[] strArray=str.split(" ");
	System.out.println(Arrays.toString(strArray));
	String result="";
	while(i<strArray.length)
	{
		String s=strArray[i];
		char[] array=s.toCharArray();
		for(int j=0,k=array.length-1;j<=k;j++,k--)
		{
			char temp=array[j];
			array[j]=array[k];
			array[k]=temp;
		}
		result+=" "+new String(array);
		i++;
	}
	System.out.println(result);
}
}
