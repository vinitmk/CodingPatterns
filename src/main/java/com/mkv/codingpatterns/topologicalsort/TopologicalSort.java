package com.mkv.codingpatterns.topologicalsort;

/*
Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices
such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.

Time Complexity #
In step ‘d’, each vertex will become a source only once and each edge will be accessed and removed once.
Therefore, the time complexity of the above algorithm will be O(V+E), where ‘V’ is the total number of vertices
and ‘E’ is the total number of edges in the graph.

Space Complexity #
The space complexity will be O(V+E), since we are storing all of the edges for each vertex in an adjacency list.

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {

	private List<Integer> sort(int vertices, int[][] edges) {

		// Initialization
		List<Integer> sortedList = new ArrayList<>();
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();
		for(int i = 0; i < vertices; i++) {
			adjList.putIfAbsent(i, new ArrayList<>());
			inDegree.putIfAbsent(i, 0);
		}

		// Build graph and inDegree
		int parent, child;
		for(int[] row: edges) {
			parent = row[0];
			child = row[1];

			adjList.get(parent).add(child);
			inDegree.put(child, inDegree.getOrDefault(child, 0)+1);
		}

		// Find all Sources
		Queue<Integer> queue = new LinkedList<>();
		for(int i: inDegree.keySet()) {
			if(inDegree.get(i) == 0)
				queue.add(i);
		}

		// Sort using Queue
		while(!queue.isEmpty()) {
			int n = queue.poll();
			sortedList.add(n);

			for(int children: adjList.get(n)) {
				inDegree.put(children, inDegree.get(children) - 1);
				if(inDegree.get(children) == 0)
					queue.add(children);
			}
		}

		if(sortedList.size() != vertices)
			return new ArrayList<>();

		return sortedList;
	}

	public static void main(String[] args) {

		TopologicalSort main  = new TopologicalSort();

		List<Integer> result = main.sort(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = main.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
				new int[] { 2, 1 }, new int[] { 3, 1 } });
		System.out.println(result);

		result = main.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
				new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);
	}
}
