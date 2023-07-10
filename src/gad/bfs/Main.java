package gad.bfs;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2, 3);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(4,5);

        BFS bfs = new BFS();
        bfs.sssp(graph, 0);
        System.out.println(bfs.getDepth(0));
    }
}
