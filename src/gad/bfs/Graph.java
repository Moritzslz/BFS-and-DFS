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
		return List.copyOf(allNodes);
	}

	public Collection<Integer> getAllNeighbours(int id) {
		return List.copyOf(adjacencyMatrix.get(id));
	}

	public void addEdge(int idA, int idB) {
		if (adjacencyMatrix.get(idA) != null && adjacencyMatrix.get(idB) != null) {
			if (!adjacencyMatrix.get(idA).contains(idB)) {
				adjacencyMatrix.get(idA).add(idB);
			}
			if (!adjacencyMatrix.get(idB).contains(idA)) {
				adjacencyMatrix.get(idB).add(idA);
			}
		} else {
			return;
		}
	}
}