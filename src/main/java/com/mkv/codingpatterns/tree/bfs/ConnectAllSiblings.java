package com.mkv.codingpatterns.tree.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectAllSiblings {

	private void connect(TreeNode root) {
		TreeNode prevNode = null;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode n = queue.poll();
			if(null != prevNode)
				prevNode.next = n;
			prevNode = n;

			if(null != n) {
				if(null != n.left)
					queue.add(n.left);
				if(null != n.right)
					queue.add(n.right);

			}
		}
	}

	public static void main(String[] args) {
		ConnectAllSiblings main = new ConnectAllSiblings();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		main.connect(root);

		// level order traversal using 'next' pointer
		TreeNode current = root;
		System.out.println("Traversal using 'next' pointer: ");
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

}
