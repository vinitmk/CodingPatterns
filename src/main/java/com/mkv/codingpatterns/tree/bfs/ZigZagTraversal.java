package com.mkv.codingpatterns.tree.bfs;

/*
Given a binary tree, populate an array to represent its zigzag level order traversal.
You should populate the values of all nodes of the first level from left to right,
then right to left for the next level and keep alternating in the same manner for the following levels.

Time complexity #
The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) as we need to return a list containing the level order traversal.
We will also need O(N) space for the queue. Since we can have a maximum of N/2 nodes at any level
(this could happen only at the lowest level), therefore we will need O(N) space to store them in the queue.
*/

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

	private List<List<Integer>> zigzagTraversal(TreeNode root) {
		int level;
		boolean leftToRight = true;
		List<Integer> currentLevel;
		Queue<TreeNode> queue = new ArrayDeque<>();
		List<List<Integer>> list = new LinkedList<>();

		queue.add(root);
		while(!queue.isEmpty()) {
			level = queue.size();
			currentLevel = new LinkedList<>();
			for(int i = 0; i < level; i++) {
				TreeNode n = queue.poll();
				if(null != n) {
					if (leftToRight)
						currentLevel.add(n.val);
					else
						currentLevel.add(0, n.val);

					if(null != n.left)
						queue.add(n.left);
					if(null != n.right)
						queue.add(n.right);
				}
			}
			leftToRight = !leftToRight;
			list.add(currentLevel);
		}
		return list;
	}

	public static void main(String[] args) {

		ZigZagTraversal main = new ZigZagTraversal();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = main.zigzagTraversal(root);
		System.out.println("Zigzag traversal: " + result);
	}
}
