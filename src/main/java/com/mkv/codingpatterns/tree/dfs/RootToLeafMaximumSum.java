package com.mkv.codingpatterns.tree.dfs;

/*
Given a binary tree, find the root-to-leaf path with the maximum sum.
*/

import java.util.List;

public class RootToLeafMaximumSum {

	private int findMaxSum(TreeNode root) {
		int maxSum = 0, sum = 0;
		return findSum(root, maxSum, sum);
	}

	private int findSum(TreeNode root, int maxSum, int sum) {
		if(root == null)
			return maxSum;
		sum += root.val;
		System.out.println("sum = "+ sum);
		if(root.left == null && root.right == null) {
			maxSum = Integer.max(maxSum, sum);
			System.out.println("maxSum = "+ maxSum);
		}

		if(null != root.left)
			findSum(root.left, maxSum, sum);
		if(null != root.right)
			findSum(root.right, maxSum, sum);
	//	sum -= root.val;
		return Integer.max(maxSum, sum);
	}

	public static void main(String[] args) {

		RootToLeafMaximumSum main = new RootToLeafMaximumSum();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(100);
		root.right.right = new TreeNode(5);
		int maxSum = main.findMaxSum(root);
		System.out.println("Max Sum is "+ maxSum);
	}


}
