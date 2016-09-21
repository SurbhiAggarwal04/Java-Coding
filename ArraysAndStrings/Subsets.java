package ArraysAndStrings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
	public static Set<Set<Object>> getSubsets(Set<Object> set)
	{
		Set<Set<Object>> subsets = new HashSet<Set<Object>>(); 
 
		subsets.add(new HashSet<Object>());
 
		for(Object o : set)
		{
			Set<Set<Object>> temp = new HashSet<Set<Object>>();
			for(Set<Object> s: subsets)
				temp.add(new HashSet<Object>(s));
 
			for (Set<Object> s : temp)
				s.add(o);
 
			subsets.addAll(temp);
		}		
 
		return subsets;
	}
	public static Set<Set<Object>> getSubsets(List<Object> list)
	{
		Set<Set<Object>> subsets = new HashSet<Set<Object>>();
 
		for(int i = 0; i < Math.pow(2, list.size()); i++)
		{
			Set<Object> subset = new HashSet<Object>();
 
			int j = 1;
			for(int k = 0; k < list.size(); k++ )
			{
				if((j & i) != 0)
				{
					subset.add(list.get(k));
				}
				j = j << 1;
			}
 
			subsets.add(subset);
		}
 
		return subsets;
	}

}
