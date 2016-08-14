package ArraysAndStrings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UniqueElementsInTwoLists {
public static void main(String[] args) {
	int list1[]=new int[]{1,1,2,2,2,3,4,4,1};
	int list2[]=new int[]{2,2,4,3,4,2,4,1,3,1,4};
	Map<Integer,Integer> hm=new HashMap<Integer,Integer>();
	int i=0,j=0;
	while(i<list1.length || j<list2.length)
	{
		if(i<list1.length && hm.containsKey(list1[i]))
		{
			//System.out.println("list 1 "+list1[i]);
			int count=hm.get(list1[i]);
			hm.put(list1[i], ++count);
			//System.out.println(hm.get(list1[i]));
		}
		else
		{
			if(i<list1.length)
				{
				//System.out.println("list 1 "+list1[i]);
				//System.out.println(1);
				hm.put(list1[i], 1);
				}
		}
			
		if(j<list2.length && hm.containsKey(list2[j]))
		{
			//System.out.println("list 2 "+list2[j]);
			int count=hm.get(list2[j]);
			hm.put(list2[j], --count);
			//System.out.println(hm.get(list2[j]));
		}
		else
		{
			if(j<list2.length)
				{
				//System.out.println("list 2 "+list2[j]);
				hm.put(list2[j], -1);
				//System.out.println(-1);
				}
		}
		i++;
		j++;
	}
	Iterator<Map.Entry<Integer, Integer>> it =hm.entrySet().iterator();
	System.out.println("map");
	while(it.hasNext())
	{
		Map.Entry<Integer, Integer> entry=it.next();
		int key=entry.getKey();
		int value=entry.getValue();
		//System.out.println(entry.getKey()+" "+entry.getValue());
		if(value!=0)
			{
			if(value<0)value=Math.abs(value);
			for(i=0;i<value;i++)
			System.out.println(key);
			}
	}
	
}
}
