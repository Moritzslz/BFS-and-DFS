package gad.bfs;

import java.util.*;

public class BFS {

	private HashMap<Integer, Integer> parents;
	private HashMap<Integer, Integer> depth;

	public BFS() {
		parents = new HashMap<>();
		depth = new HashMap<>();
	}

	public void sssp(Graph g, int start) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		queue.add(start);
		visited.add(start);
		parents.put(start, -1);
		depth.put(start, 0);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			for (Integer neighbour : g.getAllNeighbours(currentNode)) {
				if (!visited.contains(neighbour)) {
					queue.add(neighbour);
					visited.add(neighbour);
					parents.put(neighbour, currentNode);
					depth.put(neighbour, getDepth(currentNode) + 1);
				}
			}
		}
	}

	public boolean visitedNode(int node) {
		return parents.containsKey(node);
	}

	public int getDepth(int node) {
		if (visitedNode(node)) {
			return depth.get(node);
		}
		return -1;
	}

	public int getParent(int node) {
		if (visitedNode(node)) {
			return parents.get(node);
		}
		return -1;
	}
}
