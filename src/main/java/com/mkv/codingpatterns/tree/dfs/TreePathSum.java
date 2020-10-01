package com.mkv.codingpatterns.tree.dfs;

public class TreePathSum {

	private boolean hasPath(TreeNode root, int sum) {
		if(null == root)
			return false;

		if(root.val == sum && root.left == null && root.right == null)
			return true;
		return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
	}

	public static void main(String[] args) {

		TreePathSum main = new TreePathSum();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + main.hasPath(root, 23));
		System.out.println("Tree has path: " + main.hasPath(root, 16));
	}

}
