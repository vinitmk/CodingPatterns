package com.mkv.codingpatterns.tree.dfs;

/*
Given a binary tree, find the length of its diameter. The diameter of a tree is the number of nodes
on the longest path between any two leaf nodes. The diameter of a tree may or may not pass through the root.

Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) in the worst case.
This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list
(i.e., every node has only one child).
*/


public class TreeDiameter {

	private int maxDiameter = 0;

	private int diameter(TreeNode root) {
		calculateHeight(root);
		return maxDiameter;
	}

	private int calculateHeight(TreeNode currentNode) {
		if(currentNode == null)
			return 0;

		int leftTreeHeight = calculateHeight(currentNode.left);
		int rightTreeHeight = calculateHeight(currentNode.right);

		int diameter = leftTreeHeight + rightTreeHeight + 1;

		maxDiameter = Math.max(diameter, maxDiameter);
		return Math.max(leftTreeHeight, rightTreeHeight) + 1;
	}

	public static void main(String[] args) {
		TreeDiameter main = new TreeDiameter();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println("Tree Diameter: " + main.diameter(root));
		root.left.left = null;
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		root.right.left.right.left = new TreeNode(10);
		root.right.right.left.left = new TreeNode(11);
		System.out.println("Tree Diameter: " + main.diameter(root));
	}
}
