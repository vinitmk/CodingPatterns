package com.mkv.codingpatterns.tree.bfs;

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
