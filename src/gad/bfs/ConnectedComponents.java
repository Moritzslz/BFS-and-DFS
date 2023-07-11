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
		int numberOfConnectedComponents = 0;
		search.sssp(g, 0);
		for (Integer node : g.getAllNodes()) {
			Integer depth = search.getDepth(node);
			numberOfConnectedComponents = Math.max(depth, numberOfConnectedComponents);
		}
		return numberOfConnectedComponents;
	}
}