package gad.bfs;

import java.util.*;

public class ConnectedComponents {
	private BFS search;

	public ConnectedComponents() {
		this.search = new BFS();
	}

	public ConnectedComponents(BFS search) {
		this.search = search;
	}

	public int countConnectedComponents(Graph g) {
		// Tiefensuche
		int numberOfConnectedComponents = 0;
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		queue.add(0);
		visited.add(0);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			ArrayList<Integer> neighbours = new ArrayList<>();
			neighbours.addAll(g.getAllNeighbours(currentNode));
			if (neighbours.get(0) != null && !visited.contains(neighbours.get(0))) {
				Integer neighbour = neighbours.get(0);
				if (!visited.contains(neighbour)) {
					queue.add(neighbour);
					visited.add(neighbour);
				}
			} else {
				numberOfConnectedComponents++;
			}
		}
		return numberOfConnectedComponents;
	}
}