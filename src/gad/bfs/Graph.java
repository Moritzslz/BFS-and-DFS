package gad.bfs;

import java.util.*;

public class Graph {

	private HashMap<Integer, ArrayList<Integer>> adjacencyList;
	private int currentNodeId;

	public Graph() {
		adjacencyList = new HashMap<>();
		currentNodeId = 0;
	}

	public int addNode() {
		ArrayList<Integer> edges = new ArrayList<>();
		adjacencyList.put(currentNodeId, edges);
		currentNodeId++;
		return currentNodeId - 1;
	}

	public Collection<Integer> getAllNodes() {
		ArrayList<Integer> allNodes = new ArrayList<>();
		for (int i = 0; i < adjacencyList.size(); i++) {
			if (adjacencyList.get(i) != null) {
				allNodes.add(i);
			}
		}
		return List.copyOf(allNodes);
	}

	public Collection<Integer> getAllNeighbours(int id) {
		return List.copyOf(adjacencyList.get(id));
	}

	public void addEdge(int idA, int idB) {
		if (adjacencyList.get(idA) != null && adjacencyList.get(idB) != null) {
			if (!adjacencyList.get(idA).contains(idB)) {
				adjacencyList.get(idA).add(idB);
			}
			if (!adjacencyList.get(idB).contains(idA)) {
				adjacencyList.get(idB).add(idA);
			}
		} else {
			return;
		}
	}
}