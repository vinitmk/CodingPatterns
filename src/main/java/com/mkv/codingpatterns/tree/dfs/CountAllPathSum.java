package com.mkv.codingpatterns.tree.dfs;

/*
Given a binary tree and a number ‘S’, find all paths in the tree such that
the sum of all the node values of each path equals ‘S’.
Please note that the paths can start or end at any node but
all paths must follow direction from parent to child (top to bottom).

Time complexity #
The time complexity of the above algorithm is O(N^2) in the worst case,
where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once,
but for every node, we iterate the current path. The current path, in the worst case,
can be O(N) (in the case of a skewed tree). But, if the tree is balanced,
then the current path will be equal to the height of the tree, i.e., O(logN).
So the best case of our algorithm will be O(NlogN).

Space complexity #
The space complexity of the above algorithm will be O(N).
This space will be used to store the recursion stack.
The worst case will happen when the given tree is a linked list
(i.e., every node has only one child). We also need O(N)O(N) space for storing the currentPath in the worst case.
Overall space complexity of our algorithm is O(N).
*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountAllPathSum {

	private int findAllPaths(TreeNode root, int sum) {
		List<Integer> pathList = new ArrayList<>();
		return findPathCount(root, pathList, sum);
	}

	private int findPathCount(TreeNode root, List<Integer> pathList, int sum) {

		if(root == null)
			return 0;

		int pathCount = 0, pathSum = 0;
		pathList.add(root.val);
		ListIterator<Integer> ls = pathList.listIterator(pathList.size());

		while(ls.hasPrevious()) {
			//System.out.println(ls.previous());
			pathSum += ls.previous();
			if(pathSum == sum)
				pathCount++;
		}

		pathCount += findPathCount(root.left, pathList, sum);
		pathCount += findPathCount(root.right, pathList, sum);

		pathList.remove(pathList.size() - 1);
		return pathCount;
	}

	public static void main(String[] args) {
		CountAllPathSum main = new CountAllPathSum();

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + main.findAllPaths(root, 11));

	}
}
