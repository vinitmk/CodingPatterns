package com.mkv.codingpatterns.tree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

	private List<List<Integer>> reverseLevelOrder(TreeNode root) {
		int levelSize;
		List<List<Integer>> list = new LinkedList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			levelSize = queue.size();
			List<Integer> currentList = new ArrayList<>();
			for(int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				if(null != node) {
					currentList.add(node.val);
					if(null != node.left)
						queue.add(node.left);
					if(null != node.right)
						queue.add(node.right);
				}

			}
			list.add(0, currentList);
		}
		return list;
	}

	public static void main(String[] args) {
		ReverseLevelOrderTraversal main = new ReverseLevelOrderTraversal();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		List<List<Integer>> result = main.reverseLevelOrder(root);
		System.out.println("Reverse level order traversal: " + result);
	}
}
