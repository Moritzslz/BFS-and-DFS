package gad.bfs;

import java.util.ArrayList;

public class ConnectedComponents {
	private BFS search;

	public ConnectedComponents() {
		this.search = new BFS();
	}

	public ConnectedComponents(BFS search) {
		this.search = search;
	}

	public int countConnectedComponents(Graph g) {
		int numberOfConnectedComponents = 0;
		ArrayList<Integer> nodes = new ArrayList<>();
		nodes.addAll(g.getAllNodes());

		for (Integer node : nodes) {
			if (!search.visitedNode(node)) {
				search.sssp(g, node);
				numberOfConnectedComponents++;
			}
		}
		return numberOfConnectedComponents;
	}
}