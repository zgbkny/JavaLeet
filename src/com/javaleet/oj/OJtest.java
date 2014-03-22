package com.javaleet.oj;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import com.javaleet.entity.ListNode;
import com.javaleet.entity.TreeNode;



public class OJtest {
	public static void testReverseWords() {
		// TODO Auto-generated method stub
		//String ss = "the sky is blue";
		//String ss = "eqfeabrm.!zibb'lf.vtyu,fa jbxiw,anv";
		String ss = " ";
		StrCode sc = new StrCode();
		System.out.println(sc.reverseWords(ss));
	}
	public static void testLevelOrder() {
		BinaryTreeCode bt = new BinaryTreeCode();
		TreeNode node = new TreeNode(1);
		bt.levelOrder(node);
	}
	public static void testGenerateMatrix() {
		MatrixCode mc = new MatrixCode();
		mc.generateMatrix(3);
	}
	public static void testMaxPoints() {
		GeoCode gc = new GeoCode();
		Point[] points = new Point[5];
		points[0] = new Point(1,1);
		points[1] = new Point(1,1);
		points[2] = new Point(2,2);
		points[3] = new Point(2,2);
		points[4] = new Point(3,3);
	
		System.out.println(gc.maxPoints(points));
	}
	public static void testEvalRPN() {
		ExpCode ec = new ExpCode();
		String []tokens = new String[]{"2", "1", "+", "3", "*"};
		System.out.println(ec.evalRPN(tokens));
	}
	public static void testLRU() {
		LRUCache lc = new LRUCache(2);
		lc.set(2, 1);
		lc.test();
		lc.set(2, 2);
		lc.test();
		lc.get(2);
		lc.test();
		lc.set(1, 1);
		lc.test();
		lc.set(4, 1);
		lc.test();
		System.out.println(lc.get(1));
	}
	public static void testReorderList() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListCode lc = new ListCode();
		lc.reorderList(node1);
	}
	public static void testWordBreak() {
		Set<String> dict = new HashSet<String>();
		dict.add("a");
	//	dict.add("aaa");
	//	dict.add("and");
//		dict.add("sand");
	//	dict.add("dog");
		DicCode dc = new DicCode();
		System.out.println(dc.wordBreak2("a", dict));
	}
	public static void main(String[] args) {
		//testEvalRPN();
		//testMaxPoints();
		//testLRU();
		testWordBreak();
	}
}
