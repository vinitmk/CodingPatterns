package com.mkv.codingpatterns.tree.bfs;

/*
Given a binary tree, populate an array to represent the averages of all of its levels.

Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) which is required for the queue.
Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level),
therefore we will need O(N) space to store them in the queue.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelAverage {



	private List<Double> findLevelAverages(TreeNode root) {
		int level;
		List<Double> levelAvg = new ArrayList<>();

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
	//
		while(!queue.isEmpty()) {
			double sum = 0;
			level = queue.size();
			for(int i = 0; i < level; i++) {
				TreeNode n = queue.poll();
				if(null != n) {
					sum += n.val;
					if(null != n.left)
						queue.add(n.left);
					if(null != n.right)
						queue.add(n.right);
				}
			}
			levelAvg.add(sum/level);
		}
		return  levelAvg;
	}

	public static void main(String[] args) {
		LevelAverage main = new LevelAverage();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Double> result = main.findLevelAverages(root);
		System.out.print("Level averages are: " + result);
	}

}
