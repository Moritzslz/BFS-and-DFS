package gad.bfs;

import java.util.*;

public class Graph {

	private HashMap<Integer, ArrayList<Integer>> adjacencyMatrix;
	private int currentNodeId;

	public Graph() {
		adjacencyMatrix = new HashMap<>();
		currentNodeId = 0;
	}

	public int addNode() {
		ArrayList<Integer> edges = new ArrayList<>();
		adjacencyMatrix.put(currentNodeId, edges);
		currentNodeId++;
		return currentNodeId - 1;
	}

	public Collection<Integer> getAllNodes() {
		ArrayList<Integer> allNodes = new ArrayList<>();
		for (int i = 0; i < adjacencyMatrix.size(); i++) {
			if (adjacencyMatrix.get(i) != null) {
				allNodes.add(i);
			}
		}
		return allNodes;
	}

	public Collection<Integer> getAllNeighbours(int id) {
		return adjacencyMatrix.get(id);
	}

	public void addEdge(int idA, int idB) {
		if (adjacencyMatrix.get(idA) != null && adjacencyMatrix.get(idB) != null) {
			adjacencyMatrix.get(idA).add(idB);
			adjacencyMatrix.get(idB).add(idA);
		} else {
			return;
		}
	}
}