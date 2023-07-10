package gad.bfs;

import java.util.ArrayList;
import java.util.Collection;

public class Graph {

	private ArrayList<Integer>[] adjacencyMatrix;
	private int currentNodeId;

	public Graph() {
		adjacencyMatrix = new ArrayList[1000000];
		currentNodeId = 0;
	}

	public int addNode() {
		adjacencyMatrix[currentNodeId] = new ArrayList<>();
		currentNodeId++;
		return currentNodeId - 1;
	}

	public Collection<Integer> getAllNodes() {
		ArrayList<Integer> allNodes = new ArrayList<>();
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[i] != null) {
				allNodes.add(i);
			}
		}
		return allNodes;
	}

	public Collection<Integer> getAllNeighbours(int id) {
		ArrayList<Integer> neighbours = new ArrayList<>();
		for (int i = 0; i < adjacencyMatrix[id].size(); i++) {
			if (adjacencyMatrix[id].get(i) == 1) {
				neighbours.add(i);
			}
		}
		return neighbours;
	}

	public void addEdge(int idA, int idB) {
		adjacencyMatrix[idA].set(idB, 1);
		adjacencyMatrix[idB].set(idA, 1);
	}
}