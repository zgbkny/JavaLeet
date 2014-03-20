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
		StringBuffer ret = new StringBuffer(""), tmp = new StringBuffer("");
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') tmp.append(s.charAt(i));
			else 
				if (tmp.length() != 0) {
					ls.add(tmp.toString());
					tmp.delete(0, tmp.length());
				}
		}
		if (tmp.length() != 0) 	ls.add(tmp.toString());
		for (int i = ls.size(); i > 0; i--) 
			ret.append(ls.get(i - 1)).append(" ");
		if (ret.length() == 0) ret.append(" ");
		return ret.substring(0, ret.length() - 1);
    }
	

}
