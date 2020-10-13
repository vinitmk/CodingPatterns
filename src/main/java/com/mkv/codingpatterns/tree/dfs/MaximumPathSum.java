package com.mkv.codingpatterns.tree.dfs;

/*
Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.
A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.

Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) in the worst case.
This space will be used to store the recursion stack.
The worst case will happen when the given tree is a linked list (i.e., every node has only one child).
*/

public class MaximumPathSum {
	
	private int greatestSum;

	private int findMaximumPathSum(TreeNode root) {
		greatestSum = Integer.MIN_VALUE;
		findPathSumRecursive(root);
		return greatestSum;
	}

	private int findPathSumRecursive(TreeNode currentNode) {
		if(currentNode == null)
			return 0;

		int maxSumFromLeft = findPathSumRecursive(currentNode.left);
		int maxSumFromRight = findPathSumRecursive(currentNode.right);

		maxSumFromLeft = Math.max(maxSumFromLeft, 0);
		maxSumFromRight = Math.max(maxSumFromRight, 0);

		int localSum = maxSumFromLeft + maxSumFromRight + currentNode.val;
		greatestSum = Math.max(localSum, greatestSum);

		return Math.max(maxSumFromLeft, maxSumFromRight) + currentNode.val;
	}

	public static void main(String[] args) {

		MaximumPathSum main = new MaximumPathSum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println("Maximum Path Sum: " + main.findMaximumPathSum(root));

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		System.out.println("Maximum Path Sum: " + main.findMaximumPathSum(root));

		root = new TreeNode(-1);
		root.left = new TreeNode(-3);
		System.out.println("Maximum Path Sum: " + main.findMaximumPathSum(root));

	}
}
