package com.mkv.codingpatterns.tree.bfs;

/*
Given a binary tree, return an array containing nodes in its right view.
The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.

Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) as we need to return a list containing the level order traversal.
We will also need O(N) space for the queue. Since we can have a maximum of N/2 nodes at any level
(this could happen only at the lowest level), therefore we will need O(N) space to store them in the queue.

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {

	private List<TreeNode> traverse(TreeNode root) {
		int level;
		List<TreeNode> list = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			level = queue.size();
			for(int i = 0; i < level; i++) {
				TreeNode n = queue.poll();
				if(null != n) {
					if(i == level - 1)
						list.add(n);

					if(null != n.left)
						queue.add(n.left);
					if(null != n.right)
						queue.add(n.right);
				}
			}
		}
		return list;
	}


	public static void main(String[] args) {
		RightViewTree main = new RightViewTree();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(3);
		List<TreeNode> result = main.traverse(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}
	}

}
