package com.javaleet.oj;

import java.awt.Point;
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
		Point[] points = new Point[1];
		points[0] = new Point();
		points[0].x = 0;
		points[0].y = 0;
		System.out.println(gc.maxPoints(points));
	}
	public static void main(String[] args) {
		testMaxPoints();
	}
}
