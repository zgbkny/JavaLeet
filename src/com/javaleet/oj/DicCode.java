package com.javaleet.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DicCode {
	public boolean wordBreak(String s, Set<String> dict) {
		boolean []flag = new boolean[s.length() + 1];
		for (int i = 0; i < flag.length; i++) flag[i] = false;
		flag[0] = true;
		for (int i = 1; i < flag.length; i++)
			for (int j = i-1; j >= 0; j--) {
				if (flag[j] && dict.contains(s.substring(j, i))) {
					flag[i] = true;
					break;
				}
			}
		return flag[s.length()];
    }
	public ArrayList<String> wordBreak2(String s, Set<String> dict) {
		//第一个整数为起点，后一个集合为可到达的点
		HashMap<Integer, Set<Integer>> hm = new HashMap<Integer, Set<Integer>>();
		Set<Integer> list;
		ArrayList<String> ret = new ArrayList<String>();
		boolean []flag = new boolean[s.length() + 1];
		for (int i = 0; i < flag.length; i++) flag[i] = false;
		flag[0] = true;
		int i, j, k, offset = 0, tmpMin = 0;
		for (i = 1; i < flag.length; i++)
			for (j = i-1, offset = tmpMin, tmpMin = flag.length; j >= offset; j--) {
				if (flag[j] && dict.contains(s.substring(j, i))) {
					System.out.println(s.substring(j, i));
					if (i < tmpMin) tmpMin = i;
					flag[i] = true;
					if (hm.get(j) != null) {
						System.out.println("check");
						hm.get(j).add(i);
					} else {
						System.out.println("init" + j);
						list = new HashSet<Integer>();
						list.add(i);
						hm.put(j, list);
					}
					//break;
				}
			}
		j = 0; i = 0;
		while (dict != null && hm.get(j) != null && hm.get(j).iterator().hasNext()) {
			StringBuffer strb = new StringBuffer();
			//j = hm.get(j).iterator().next();
			System.out.println(j + "" +hm.get(j));
			while (hm.get(j) != null && hm.get(j).iterator().hasNext()) {
				i = hm.get(j).iterator().next();
				strb.append(s.substring(j, i)).append(" ");
				j = i;
			}
			ret.add(strb.substring(0, strb.length() - 1));
			j = 0;
		}
		return ret;
    }
}
