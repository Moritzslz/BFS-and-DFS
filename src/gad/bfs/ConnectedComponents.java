package gad.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ConnectedComponents {
	private BFS search;
	private Set<Integer> visited;

	public ConnectedComponents() {
		this.search = new BFS();
	}

	public ConnectedComponents(BFS search) {
		this.search = search;
	}

	public int countConnectedComponents(Graph g) {
		int count = 0; // Zähler für die Anzahl der Zusammenhangskomponenten
		visited = new HashSet<>();

		for (int node : g.getAllNodes()) {
			if (!visited.contains(node)) {
				bfs(g, node);
				count++;
			}
		}

		return count;
	}

	private void bfs(Graph graph, int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		visited.add(startNode);
		queue.add(startNode);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			for (int neighbor : graph.getAllNeighbours(currentNode)) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
	}
}