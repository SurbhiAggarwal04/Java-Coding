package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSum0 {
	public static void main(String[] args) {
		int n[] = { 6, 2, -1, -2, 1,0, 1, 6, 7 };
		find(n);
	}

	public static void find(int[] n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> maxLengthList = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
			if (sum == 0 || map.containsKey(sum) || n[i]==0) {
				int j;
				int length = 0;
				ArrayList<Integer> newList = new ArrayList<Integer>();
				if (map.containsKey(sum)) {
					System.out.println("sub Array");
					j = map.get(sum) + 1;
					while (j <= i) {
						length++;
						newList.add(n[j]);
						System.out.println(n[j]);
						j++;
					}

				}
			
				else if(sum==0){
					System.out.println("sub Array");
					j = 0;
					while (j <= i) {
						length++;
						newList.add(n[j]);
						System.out.println(n[j]);
						j++;
					}
				}
				else
				{
					newList.add(0);
					length++;
				}
				list.add(newList);
				/*
				 * System.out.println("maxLeng:"+maxLengthList.size());
				 * System.out.println(j-i+1);
				 */
				if (maxLengthList.size() < length) {
					maxLengthList.clear();
					maxLengthList.addAll(newList);
				}
			} else
				map.put(sum, i);
		}
		System.out.println(list);
		System.out.println(maxLengthList);
	}
}
