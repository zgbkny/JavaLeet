package com.javaleet.oj;

import java.util.Stack;

public class ExpCode {
	private int cal(int n1, int n2, String opt) {
		if (opt.equals("+")) return n1 + n2;
		else if (opt.equals("-")) return n1 - n2;
		else if (opt.equals("*")) return n1 * n2;
		else return n1 / n2;
	}
	public int evalRPN(String[] tokens) {
        Stack<Integer> numStk = new Stack<Integer>();
        int n1 = 0, n2 = 0;
        for (int i = 0; i < tokens.length; i++) {
        	String tmp = tokens[i];
        	if ((tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/"))) {
    			n2 = (Integer)numStk.pop(); n1 = (Integer)numStk.pop();
    			numStk.push(cal(n1, n2, tmp));
        	} else numStk.push(new Integer(tmp));
        }
        return numStk.pop();
    }
}
