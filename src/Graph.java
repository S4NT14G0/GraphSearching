import java.util.*;

public class Graph {
    ArrayList<Node<String>> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode (Node<String> node) {
        nodes.add(node);
    }

    public ArrayList<Node<String>> getNodes () {
        return nodes;
    }

    @Override
    public String toString() {
        // return printable representation of a Graph
        String output = "";

        for (Node node: nodes) {
            output += node.toString() + ": ";

            for (Object obj: node.getEdges()) {
                Edge edge = (Edge) obj;
                output += "[" + edge.getDestination().toString() + " ," + edge.getWeight() + "], ";
            }

            output += "\n";
        }

        return output;
    }

    public Graph bfs (Node startingNode, Node destinationNode) {
        // Graph to build up our search tree
        Graph searchGraph = new Graph();
        MyQueue<Node> queue = new MyQueue<>();
        Boolean[] visited = new Boolean[nodes.size()];

        Arrays.fill(visited, false);

        // We are on the first node so it's been visited
        visited[nodes.indexOf(startingNode)] = true;
        queue.enqueue(startingNode);

        // While we still have unchecked nodes
        while (!queue.isEmpty()) {
            Node currentNode = queue.dequeue();

            // Build up the search graph
            Node currentSearchGraphNode = new Node(currentNode.getValue());
            searchGraph.addNode(currentSearchGraphNode);

            // Get all the edges out of the current node to look for
            for (Object obj: currentNode.getEdges()) {
                final Edge edge = (Edge) obj;

                // Check if this node has been visited
                if (!visited[this.nodes.indexOf(edge.getDestination())]) {
                    // Add the edge to for the search graph
                    currentSearchGraphNode.addEdge(edge.getWeight(), edge.getDestination());

                    // Add this node to the list of nodes we haven't explored
                    queue.enqueue(edge.getDestination());

                    // Mark the current node as visited
                    visited[this.nodes.indexOf(edge.getDestination())] = true;

                    searchGraph.addNode(new Node(edge.getDestination().getValue()));
                }

                if (edge.getDestination().equals(destinationNode))
                    return searchGraph;
            }
        }

        return searchGraph;
    }

    public Graph dfs (Node startingNode, Node destinationNode) {
        Graph searchGraph = new Graph();
        Stack<Node> stack = new Stack();

        Boolean[] visited = new Boolean[this.nodes.size()];

        Arrays.fill(visited, false);

        stack.push(startingNode);

        while (!stack.isEmpty()) {

            Node currentNode = stack.pop();
            Node currentSearchGraphNode = new Node(currentNode.getValue());
            searchGraph.addNode(currentSearchGraphNode);

            if (!visited[nodes.indexOf(currentNode)]) {

                visited[nodes.indexOf(currentNode)] = true;

                for (Object obj : currentNode.getEdges()) {
                    final Edge edge = (Edge) obj;
                    stack.push(edge.getDestination());

                    if (destinationNode.equals(edge.getDestination())) {
                        Node finalNode = new Node(edge.getDestination().getValue());
                        searchGraph.addNode(finalNode);

                        currentSearchGraphNode.addEdge(currentNode.findEdgeFromNode(finalNode).getWeight(), finalNode);

                        return searchGraph;
                    }
                }

                if (!currentSearchGraphNode.getEdges().contains(stack.peek())) {
                    Edge edge = currentNode.findEdgeFromNode(stack.peek());
                    currentSearchGraphNode.addEdge(edge.getWeight(), stack.peek());
                }

            }

        }


        return searchGraph;
    }
}

class Node<T> {

    private final T value;
    private List<Edge> edges;

    public Node (T _value) {
        value = _value;
        edges = new ArrayList();
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public T getValue () {
        return value;
    }

    public void addEdge(int weight, Node<T> node) {
        edges.add(new Edge(node, weight));
    }

    public Edge findEdgeFromNode (Node connectedNode) {
        for (Edge edge: edges) {
            if (edge.getDestination().equals(connectedNode))
                return edge;
        }

        return null;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null)
            return  false;

        final Node node = (Node) obj;

        if (node.getValue().equals(this.getValue()))
            return true;

        return false;
    }

}

class Edge {

    private Node destination;
    private Integer weight;


    public Edge(Node destination, Integer weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Node getDestination() {
        return destination;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null)
            return  false;

        final Edge edge = (Edge) obj;

        if (this.getDestination().equals(edge.getDestination()) && this.getWeight() == edge.getWeight())
            return true;

        return false;
    }
}