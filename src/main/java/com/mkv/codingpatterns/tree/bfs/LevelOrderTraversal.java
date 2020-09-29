package com.mkv.codingpatterns.tree.bfs;

/*
Given a binary tree, populate an array to represent its level-by-level traversal.
You should populate the values of all nodes of each level from left to right in separate sub-arrays.

Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) as we need to return a list containing the level order traversal.
We will also need O(N) space for the queue. Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level),
therefore we will need O(N) space to store them in the queue.

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class LevelOrderTraversal {

	private List<List<Integer>> traversal(TreeNode root) {
		TreeNode tempNode;
		Queue<TreeNode> queue = new ArrayDeque<>();
		List<List<Integer>> list = new ArrayList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> tempList = new ArrayList<>();
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

	private void levelOrderUsingHashMap(TreeNode root, int level, Map<Integer, List<Integer>> map) {
		if(null != root) {
			map.putIfAbsent(level, new ArrayList<>());
			map.get(level).add(root.val);
			level++;
			levelOrderUsingHashMap(root.left, level, map);
			levelOrderUsingHashMap(root.right, level, map);
		}
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

		Map<Integer, List<Integer>> map = new HashMap<>();
		main.levelOrderUsingHashMap(root, 1, map);
		for(int key: map.keySet())
			System.out.println(map.get(key));
	}



}
