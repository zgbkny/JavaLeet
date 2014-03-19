package com.javaleet.oj;

import java.util.ArrayList;
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
}
