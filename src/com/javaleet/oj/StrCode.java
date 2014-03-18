package com.javaleet.oj;

import java.util.ArrayList;
import java.util.List;

public class StrCode {
	
	/***
	 * 问题：1、""；2、"a";3:" "
	 * @param 
	 * @return
	 */
	public String reverseWords(String s) {
		List<String> ls = new ArrayList<String>();
		StringBuffer ret = new StringBuffer("");
		StringBuffer tmp = new StringBuffer("");
		int i = 0, index = 0;
		while (i < s.length()) {
			/*last string won't be added into the list, we need add it to list later*/
			if (s.charAt(i) != ' ') {
				tmp.append(s.charAt(i));
			} else {
				if (tmp.length() != 0) {
					ls.add(tmp.toString());
					tmp.delete(0, tmp.length());
				}
			}
			/*if (s.charAt(i) != ' ') {
				ret.insert(index, s.charAt(i));
				index++;
			} else {
				if (ret.charAt(0) != ' ') {
					ret.insert(0, ' ');
				}
				index = 0;
			}*/
			/*if (s.charAt(i) != ' ' && !flag) { 
				flag = true;
				startIndex = i;
			} else if ((s.charAt(i) == ' ' && flag) || i == s.length() - 1) {
				if (i == s.length() - 1) i++;
				ret.insert(0, s.substring(startIndex, i) + " ");
				flag = false;
			}*/
			i++;
		}
		if (tmp.length() != 0) {
			ls.add(tmp.toString());
		}
		i = ls.size();
		while (i > 0) {
			ret.append(ls.get(i - 1)).append(" ");
			i--;
		}
		if (ret.length() == 0) {
			ret.append(" ");
		}
		return ret.substring(0, ret.length() - 1);
       // return s.length() > 0 ? ret.substring(0, ret.length() - 1) : s;
    }
	

}
