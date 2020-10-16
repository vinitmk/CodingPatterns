package com.mkv.codingpatterns.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TaskScheduling {

	private boolean isSchedulingPossible(int vertex, int[][] edges) {

		List<Integer> path = new ArrayList<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();
		for(int i = 0; i < vertex; i++) {
			graph.put(i, graph.getOrDefault(i, new ArrayList<>()));
			inDegree.put(i, 0);
		}

		int child, parent;
		for(int[] row: edges) {
			parent = row[0];
			child = row[1];

			graph.get(parent).add(child);
			inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
		}

		Queue<Integer> queue = new LinkedList<>();
		for(int children: inDegree.keySet()) {
			if(inDegree.get(children) == 0)
				queue.add(children);
		}

		int n;
		while(!queue.isEmpty()) {
			n = queue.poll();
			path.add(n);
			for(int c: graph.get(n)) {
				inDegree.put(c, inDegree.get(c) - 1);
				if(inDegree.get(c) == 0)
					queue.add(c);
			}
		}

		return path.size() == vertex;
	}

	public static void main(String[] args) {

		TaskScheduling main = new TaskScheduling();

		boolean result = main.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
		System.out.println("Tasks execution possible: " + result);

		result = main.isSchedulingPossible(3,
				new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
		System.out.println("Tasks execution possible: " + result);

		result = main.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
				new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
		System.out.println("Tasks execution possible: " + result);
	}
}
