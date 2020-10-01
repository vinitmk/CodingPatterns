package com.mkv.codingpatterns.tree.dfs;

/*
Given a binary tree and a number ‘S’, find all paths from root-to-leaf
such that the sum of all the node values of each path equals ‘S’.
*/

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {

	private List<List<Integer>> findPaths(TreeNode root, int sum) {
		List<List<Integer>> pathList = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		findPathRecursive(root, sum, currentPath, pathList);
		return pathList;
	}

	private void findPathRecursive(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> pathList) {
		if(root == null)
			return;
		currentPath.add(root.val);
		if(root.val == sum && root.left == null && root.right == null)
			pathList.add(new ArrayList<>(currentPath));
		else {
			if(null != root.left)
				findPathRecursive(root.left, sum - root.val, currentPath, pathList);
			if(null != root.right)
				findPathRecursive(root.right, sum - root.val, currentPath, pathList);
		}
		currentPath.remove(currentPath.size() - 1);
	}

	public static void main(String[] args) {

		FindAllTreePaths main = new FindAllTreePaths();
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int sum = 23;
		List<List<Integer>> result = main.findPaths(root, sum);
		System.out.println("Tree paths with sum " + sum + ": " + result);
	}
}
