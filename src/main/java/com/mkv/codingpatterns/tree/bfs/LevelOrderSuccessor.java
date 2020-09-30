package com.mkv.codingpatterns.tree.bfs;

/*
Given a binary tree and a node, find the level order successor of the given node in the tree.
The level order successor is the node that appears right after the given node in the level order traversal.

The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) which is required for the queue.
Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level),
therefore we will need O(N) space to store them in the queue.
*/

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

	private TreeNode findLevelOrderSuccessor(TreeNode root, int key) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode n = queue.poll();

			if(null != n.left)
				queue.add(n.left);
			if(null != n.right)
				queue.add(n.right);
			if(n.val == key)
				break;
		}
		return queue.peek();
	}




		public static void main(String[] args) {
			LevelOrderSuccessor main = new LevelOrderSuccessor();

			TreeNode root = new TreeNode(12);
			root.left = new TreeNode(7);
			root.right = new TreeNode(1);
			root.left.left = new TreeNode(9);
			root.right.left = new TreeNode(10);
			root.right.right = new TreeNode(5);
			TreeNode result = main.findLevelOrderSuccessor(root, 12);
			if (result != null)
				System.out.println(result.val + " ");
			result = main.findLevelOrderSuccessor(root, 9);
			if (result != null)
				System.out.println(result.val + " ");
		}

}
