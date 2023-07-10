package gad.bfs;

import java.util.*;

public class BFS {

	private HashMap<Integer, Integer[]> parents; //Index 0 = parent; Index 1 = depth

	public BFS() {
		parents = new HashMap<>();
	}

	public void sssp(Graph g, int start) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		queue.add(start);
		Integer[] array = new Integer[2];
		array[0] = -1;
		array[1] = 0;
		parents.put(start, array);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			for (Integer neighbour : g.getAllNeighbours(currentNode)) {
				if (!visited.contains(neighbour)) {
					queue.add(neighbour);
					visited.add(neighbour);
					Integer[] nArray = new Integer[] {currentNode, getDepth(currentNode + 1)};
					parents.put(neighbour, nArray);
				}
			}
		}
	}

	public boolean visitedNode(int node) {
		return parents.containsKey(node);
	}

	public int getDepth(int node) {
		if (visitedNode(node)) {
			return parents.get(node)[1];
		}
		return -1;
	}

	public int getParent(int node) {
		if (visitedNode(node)) {
			return parents.get(node)[0];
		}
		return -1;
	}
}
