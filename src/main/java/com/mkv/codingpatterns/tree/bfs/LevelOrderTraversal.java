package com.mkv.codingpatterns.tree.bfs;

/*
Given a binary tree, populate an array to represent its level-by-level traversal.
You should populate the values of all nodes of each level from left to right in separate sub-arrays.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LevelOrderTraversal {

	private List<List<Integer>> traversal(TreeNode root) {
		TreeNode tempNode;
		Queue<TreeNode> queue = new ArrayDeque<>();
		List<List<Integer>> list = new ArrayList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> tempList = new ArrayList<>();
			//list.add(Arrays.asList(tempNode.val));
			for(int i = 0; i < levelSize; i++) {
				tempNode = queue.poll();
				if(null != tempNode) {
					tempList.add(tempNode.val);
					if (null != tempNode.left)
						queue.add(tempNode.left);
					if (null != tempNode.right)
						queue.add(tempNode.right);
				}
			}
				list.add(tempList);
		}
		return list;
	}


	public static void main(String[] args) {
		LevelOrderTraversal main = new LevelOrderTraversal();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = main.traversal(root);
		System.out.println("Level order traversal: " + result);
	}



}
