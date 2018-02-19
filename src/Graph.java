import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Graph<T> {
    ArrayList<Node<T>> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode (Node<T> node) {
        nodes.add(node);
    }

    public ArrayList<Node<T>> getNodes () {
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

    public Graph aStar (Node startingNode, Node destinationNode) {
        Graph searchGraph = new Graph();

        // Initialize the open and closed structures
        ArrayList<Pair<Node<CustomNode>, Integer>> openList = new ArrayList<>();
        ArrayList<Pair<Node<CustomNode>, Integer>> closedList = new ArrayList<>();

        openList.add(new Pair(startingNode, 0));

        while (!openList.isEmpty()) {
            // Find the next lowest f value
            Pair<Node<CustomNode>, Integer> q = findLowestOpenFValue(openList);

            // Remove q from our list
            openList.remove(q);

            searchGraph.addNode(q.getFirst());

            // Look at q's possible next nodes
            for (Object obj: q.getFirst().getEdges()) {

                // Get the successor node
                Node successorNode = ((Edge) obj).getDestination();

                // Initialize g
                int g = 0;

                // Cost from start to get to this successor city
                if (q.getSecond() != 0)
                    g = ((Edge) obj).getWeight() + (q.getSecond() - q.getFirst().getValue().getLosToBucharest());
                else
                    g = ((Edge) obj).getWeight() + q.getSecond();

                // Find the successor city heuristic
                int h = ((CustomNode) successorNode.getValue()).getLosToBucharest();

                // Check the current nodes value
                System.out.println(successorNode + ", g: " + g + ", h: " + h + ", f: " + (g + h));

                int f = g + h;

                // Create our custom successor pair
                Pair<Node<CustomNode>, Integer> successor = new Pair<>(successorNode, f);

                // Check if one of these nodes is the destination and we don't have any paths with lower cost left
                if (successorNode.equals(destinationNode)  && successor.getSecond() <= findLowestOpenFValue(openList).getSecond()) {
                    return searchGraph;
                }

                // Skip this node if it's in the open list
                if (openList.contains(successor))
                    break;

                if (closedList.contains(successor))
                    break;
                else
                    openList.add(successor);
            }

            closedList.add(q);
        }

        return searchGraph;
    }

    private Pair<Node<CustomNode>,Integer> findLowestOpenFValue (ArrayList<Pair<Node<CustomNode>,Integer>> openList) {
        // Set the first node as the lowest
        Pair lowestFNode = openList.get(0);

        // Iterate over the nodes and find lowest f value node
        for (Object obj: openList) {

            Pair node = (Pair) obj;

            if ((int) node.getSecond() <  (int)lowestFNode.getSecond()) {
                lowestFNode = node;
            }
        }

        return lowestFNode;
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

class Pair<F, S> {
    private final F first; //first member of pair
    private final S second; //second member of pair

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
