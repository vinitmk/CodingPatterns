package com.mkv.codingpatterns.tree.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumBinaryTreeDepth {

	private  int findDepth(TreeNode root) {
		int minDepth = 0, level;
		Queue<TreeNode> queue = new ArrayDeque<>();

		queue.add(root);
		while(!queue.isEmpty()) {
			minDepth++;
			level = queue.size();
			for(int i = 0; i < level; i++) {
				TreeNode n = queue.poll();
				if(null != n && n.left == null && n.right == null)
					return minDepth;
				if(null != n && null != n.left)
					queue.add(n.left);
				if(null != n && null != n.right)
					queue.add(n.right);
			}
		}
		return minDepth;
	}

	public static void main(String[] args) {

		MinimumBinaryTreeDepth main = new MinimumBinaryTreeDepth();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + main.findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + main.findDepth(root));

	}

}
