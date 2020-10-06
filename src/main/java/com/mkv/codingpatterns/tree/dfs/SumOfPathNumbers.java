package com.mkv.codingpatterns.tree.dfs;

/*
Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
Find the total sum of all the numbers represented by all paths.

Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) in the worst case.
This space will be used to store the recursion stack.
The worst case will happen when the given tree is a linked list (i.e., every node has only one child).

*/

public class SumOfPathNumbers {

	private int findSumOfTree(TreeNode root) {
		int sum = 0;
		return findSum(root, sum);
	}

	private int findSum(TreeNode root, int sum) {
		if(root != null) {
			sum = sum * 10 + root.val;
			if(root.left == null && root.right == null) {
				return sum;
			}
			else {
				return findSum(root.left, sum) + findSum(root.right, sum);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		SumOfPathNumbers main = new SumOfPathNumbers();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + main.findSumOfTree(root));

	}
}
