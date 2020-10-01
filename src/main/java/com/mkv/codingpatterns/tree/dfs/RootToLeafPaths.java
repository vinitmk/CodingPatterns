package com.mkv.codingpatterns.tree.dfs;

/*
Given a binary tree, return all root-to-leaf paths.
*/

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {

	private List<List<Integer>> findPaths(TreeNode root) {
		List<List<Integer>> allPathsList = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		allPaths(root, allPathsList, currentPath);
		return allPathsList;
	}

	private void allPaths(TreeNode root, List<List<Integer>> allPaths, List<Integer> currentPath) {
		if(root == null)
			return;
		currentPath.add(root.val);
		if(root.left == null && root.right == null)
			allPaths.add(new ArrayList<>(currentPath));

		if(null != root.left)
			allPaths(root.left, allPaths, currentPath);
		if(null != root.right)
			allPaths(root.right, allPaths, currentPath);

		currentPath.remove(currentPath.size() - 1);
	}

	public static void main(String[] args) {

		RootToLeafPaths main = new RootToLeafPaths();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = main.findPaths(root);
		for(List<Integer> l: result)
			System.out.println(l);
	}
}
