package Graphs;

import java.util.*;

// assuming a directed graph
public class Graph {

    // hash table to store id for each graph node
    HashMap<Integer, Node> nodeLookup = new HashMap<>();

    // each node on the graph
    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>(); // adjacency list of all neighbors
        private Node (int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return nodeLookup.get(id);  // returns null if elt is not hash table
    }

    // add a connection between 2 nodes already in the graph
    public void addEdge(int source, int destination) {
        Node src = getNode(source);
        Node dest = getNode(destination);
        // verify if source and destination are in hashtable. If node add them
        if (src == null) {  // source not in hash table
            src = new Node(source);
            nodeLookup.put(source, src);
        }
        if (dest == null) {   // destination not in hash table
            dest = new Node(destination);
            nodeLookup.put(destination, dest);
        }
        // before adding to the src adjacent list
        src.adjacent.add(dest); // just add to linked list - we don't care abt its location on the linked list
    }

    @Override
    public String toString() {
        int nodeId;
        Node node;
        String s = "Graph:";
        for (Map.Entry entry : nodeLookup.entrySet()) {
            nodeId = (int)entry.getKey();   // get key
            s += "\n  Node " + nodeId + ":";
            node = (Node)entry.getValue();
            // loop through linked list
            s += " Directs to: {";
            for (Node neighbor : node.adjacent) {
                s += neighbor.id + ", ";
            }
            s += "}";
        }

        return s;
    }

    public boolean depthFirstSearchHasPath(int source, int destination) {
        Node src = getNode(source);
        Node dest = getNode(destination);
        if (src != null && dest != null) {
            // contains all nodes that have been visited
            HashSet<Integer> visited = new HashSet<>();
            boolean isPath = depthFirstSearchHasPath(src, dest, visited);
            System.out.println(visited);    // interesting: should be able to help with traversal
            return isPath;
        } else {
            System.out.println("ERROR: search operation failed." +
                    "\nEither Source id " + source + " or destination id " + destination +" is not in graph.");
            return false;
        }
    }

    // depth first: go deep into one neighbor first before coming back to explore its other neighbors
    // interesting: overloading for private recursive function
    private boolean depthFirstSearchHasPath(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;   // already visited this node: keep with search
        }
        visited.add(source.id); // mark it as visited
        if (source == destination) {    // Yayy. We found it!
            return true;
        }
        // if we have not found the destinations yet, then iterate through this node's children or neighboring/adjacent nodes
        for (Node neighbor : source.adjacent) {
            if (depthFirstSearchHasPath(neighbor, destination, visited)) {
                return true;
            }
        }
        // if we get here: not found:
        return false;
    }

    public boolean breadthFirstSearchHasPath(int source, int destination) {
        Node src = getNode(source);
        Node dest = getNode(destination);
        if (src != null && dest != null) {
            Deque<Node> nextToVisit = new ArrayDeque<>();
            HashSet<Integer> visited = new HashSet<>();
            nextToVisit.offer(src); // enqueue source

            while(!nextToVisit.isEmpty()) {
                Node currentNode = nextToVisit.poll(); // dequeue next node
                if (currentNode == dest) {
                    return true;    // Yayy, found it.
                }
                if (visited.contains(currentNode.id))
                    continue;

                visited.add(currentNode.id);   // update set of visited nodes
                // add all neighbors - they will be next to be explored
                for (Node neighbor : currentNode.adjacent) {
                    nextToVisit.offer(neighbor);
                }
            }
            // if we get here, then no path exists
            return false;

        } else {
            System.out.println("ERROR: search operation failed." +
                    "\nEither Source id " + source + " or destination id " + destination +" is not in graph.");
            return false;
        }
    }

}
