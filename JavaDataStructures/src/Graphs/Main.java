package Graphs;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        initGraphNodes(graph);

        System.out.println(graph.depthFirstSearchHasPath(3,2));
        // System.out.println(graph.breadthFirstSearchHasPath(3,2));
    }

    public static void initGraphNodes(Graph graph) {
        // graph.nodeLookup.put(12, "Marcia")
        graph.addEdge(1,2);
        graph.addEdge(0,1);
        graph.addEdge(3,1);
        graph.addEdge(3,0);
        graph.addEdge(3,2);
        System.out.println(graph);

    }
}
