package com.javaleet.oj;

import java.util.ArrayList;
import java.util.Stack;

import com.javaleet.entity.TreeNode;

public class BinaryTreeCode {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		//ArrayList<ArrayList<TreeNode>> tree = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> level = new ArrayList<TreeNode>();
		ArrayList<TreeNode> levelSon = new ArrayList<TreeNode>();
		ArrayList<TreeNode> levelTmp = null;
		levelSon.add(root);
		int i = 0;
		TreeNode tmp = null;
		while (levelSon.size() > 0) {
			levelTmp = level;
			level = levelSon;
			levelSon = levelTmp;
			ArrayList<Integer> val = new ArrayList<Integer>();
			i = 0;
			while ((level.size() > 0) && (tmp = level.get(0)) != null) {
				val.add(tmp.val);
				level.remove(0);
				if (tmp.left != null) {
					levelSon.add(tmp.left);
				}
				if (tmp.right != null) {
					levelSon.add(tmp.right);
				}
			}
			if (val.size() != 0) {
				ret.add(val);
			}
		}
        return ret;
    }
	private void postVisitNode(ArrayList<Integer> list, TreeNode root) {
		if (root.left != null) postVisitNode(list, root.left);
		if (root.right != null) postVisitNode(list, root.right);
		list.add(root.val);
	}
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root != null) {
			if (root.left != null) postVisitNode(ret, root.left);
			if (root.right != null) postVisitNode(ret, root.right);
			ret.add(root.val);
		}
		return ret;
    }
	private void preVisitNode(ArrayList<Integer> list, TreeNode root) {
		list.add(root.val);
		if (root.left != null) preVisitNode(list, root.left);
		if (root.right != null) preVisitNode(list, root.right);
	}
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root != null) {
			ret.add(root.val);
			if (root.left != null) preVisitNode(ret, root.left);
			if (root.right != null) preVisitNode(ret, root.right);
		}
		return ret;
    }
}
