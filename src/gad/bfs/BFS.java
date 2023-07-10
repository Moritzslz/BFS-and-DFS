package gad.bfs;

import java.util.*;

public class BFS {

	private HashMap<Integer, ArrayList<Integer>> parents;
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
		ArrayList arrayList = new ArrayList<>();
		arrayList.add(-1);
		parents.put(start, arrayList);
		depth.put(start, 0);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			for (Integer neighbour : g.getAllNeighbours(currentNode)) {
				if (!visited.contains(neighbour)) {
					queue.add(neighbour);
					visited.add(neighbour);
					ArrayList nArrayList = new ArrayList<>();
					arrayList.add(currentNode);
					parents.put(neighbour, nArrayList);
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
			return parents.get(node).get(0);
		}
		return -1;
	}
}
