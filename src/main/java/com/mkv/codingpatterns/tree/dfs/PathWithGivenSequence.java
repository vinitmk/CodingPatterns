package com.mkv.codingpatterns.tree.dfs;

/*
Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.

Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) in the worst case.
This space will be used to store the recursion stack.
The worst case will happen when the given tree is a linked list (i.e., every node has only one child).
*/

import java.util.ArrayList;
import java.util.List;

public class PathWithGivenSequence {

	private boolean findPath(TreeNode root, int[] vals) {
		return paths(root, vals, 0);
	}

	private boolean paths(TreeNode currentNode, int[] vals, int sequenceIndex) {

		if(currentNode == null)
			return false;

		if(sequenceIndex >= vals.length || currentNode.val != vals[sequenceIndex])
			return false;

		if(currentNode.left == null && currentNode.right == null && sequenceIndex == vals.length - 1)
			return true;

		return paths(currentNode.left, vals, sequenceIndex+1) ||
				paths(currentNode.right, vals, sequenceIndex+1);
	}

	public static void main(String[] args) {
		PathWithGivenSequence main = new PathWithGivenSequence();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		System.out.println("Tree has path sequence: " + main.findPath(root, new int[] { 1, 0, 7 }));
		System.out.println("Tree has path sequence: " + main.findPath(root, new int[] { 1, 1, 6 }));
	}
}
