import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
        int i = 0;

        for (Node node: nodes) {
            output += i + ": ";

            Iterator it = node.getAdjacentNodes().entrySet().iterator();

            while (it.hasNext()) {
                output += it.toString() + " ";
            }

            output += "\n";
            i++;
        }

        return output;
    }
}

class Node<T> {

    private final T value;
    private HashMap<Integer, Node<T>> adjacentNodes;

    public Node (T _value) {
        value = _value;
        adjacentNodes = new HashMap<Integer, Node<T>>();
    }

    public HashMap<Integer, Node<T>> getAdjacentNodes() {
        return adjacentNodes;
    }

    public T getValue () {
        return value;
    }

    public void addEdge(int weight, Node<T> node) {
        adjacentNodes.put(weight, node);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}