package com.mkv.codingpatterns.tree.bfs;

/*
Given a binary tree, connect each node with its level order successor.
The last node of each level should point to a null node.

Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) which is required for the queue.
Since we can have a maximum of N/2nodes at any level (this could happen only at the lowest level),
therefore we will need O(N) space to store them in the queue.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectLevelOrderSiblings {

	private void connectSiblings(TreeNode root) {
		int levelSize;
		TreeNode previousNode = null;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			levelSize = queue.size();
			for(int i = 0; i < levelSize; i++) {
				TreeNode n =queue.poll();
				if(null != previousNode)
					previousNode.next = n;
				previousNode = n;
			}
		}
	}

	public static void main(String[] args) {
		ConnectLevelOrderSiblings main = new ConnectLevelOrderSiblings();
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		main.connectSiblings(root);
		System.out.println("Level order traversal using 'next' pointer: ");
	}




}
