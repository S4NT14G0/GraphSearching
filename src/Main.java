public class Main {

    public static void main(String[] args) {

        // Create nodes
        Node<CustomNode> oradea = new Node<>(new CustomNode("Oradea", 380));
        Node<CustomNode> zerind = new Node<>(new CustomNode("Zerind", 374));
        Node<CustomNode> arad = new Node<>(new CustomNode("Arad", 366));
        Node<CustomNode> sibiu = new Node<>(new CustomNode("Sibiu", 253));
        Node<CustomNode> timisoara = new Node<>(new CustomNode("Timisoara", 329));
        Node<CustomNode> lugoj = new Node<>(new CustomNode("Lugoj", 244));
        Node<CustomNode> rimnicuvilcea = new Node<>(new CustomNode("Rimnicu Vilcea", 193));
        Node<CustomNode> fagaras = new Node<>(new CustomNode("Fagaras", 176));
        Node<CustomNode> bucharest = new Node<>(new CustomNode("Bucharest", 0));
        Node<CustomNode> pitesti = new Node<>(new CustomNode("Pitesti", 100));
        Node<CustomNode> mehadia = new Node<>(new CustomNode("Mehadia", 241));
        Node<CustomNode> drobeta = new Node<>(new CustomNode("Drobeta", 242));
        Node<CustomNode> craiova = new Node<>(new CustomNode("Craiova", 160));
        Node<CustomNode> giurgiu = new Node<>(new CustomNode("Giurgiu", 77));
        Node<CustomNode> urziceni = new Node<>(new CustomNode("Urziceni", 80));
        Node<CustomNode> vaslui = new Node<>(new CustomNode("Vaslui", 199));
        Node<CustomNode> iasi = new Node<>(new CustomNode("Iasi", 226));
        Node<CustomNode> neamt = new Node<>(new CustomNode("Neamt", 234));
        Node<CustomNode> hirsova = new Node<>(new CustomNode("Hirsova", 151));
        Node<CustomNode> eforie = new Node<>(new CustomNode("Eforie", 161));

        // Create all the edges
        oradea.addEdge(151, sibiu);
        oradea.addEdge(71, zerind);

        zerind.addEdge(71, oradea);
        zerind.addEdge(75, arad);

        arad.addEdge(75, zerind);
        arad.addEdge(140, sibiu);
        arad.addEdge(118, timisoara);

        timisoara.addEdge(118, arad);
        timisoara.addEdge(111, lugoj);

        lugoj.addEdge(111, timisoara);
        lugoj.addEdge(70, mehadia);

        mehadia.addEdge(70, lugoj);
        mehadia.addEdge(75, drobeta);

        drobeta.addEdge(75, mehadia);
        drobeta.addEdge(120,craiova);

        craiova.addEdge(120, drobeta);
        craiova.addEdge(146, rimnicuvilcea);
        craiova.addEdge(138, pitesti);

        rimnicuvilcea.addEdge(146, craiova);
        rimnicuvilcea.addEdge(97, pitesti);
        rimnicuvilcea.addEdge(80, sibiu);

        sibiu.addEdge(80, rimnicuvilcea);
        sibiu.addEdge(151, oradea);
        sibiu.addEdge(140, arad);
        sibiu.addEdge(99, fagaras);

        pitesti.addEdge(97, rimnicuvilcea);
        pitesti.addEdge(101, bucharest);

        fagaras.addEdge(99,sibiu);
        fagaras.addEdge(211, bucharest);

        bucharest.addEdge(211, fagaras);
        bucharest.addEdge(101, pitesti);
        bucharest.addEdge(90, giurgiu);
        bucharest.addEdge(85, urziceni);

        giurgiu.addEdge(90, bucharest);

        urziceni.addEdge(85, bucharest);
        urziceni.addEdge(98, hirsova);
        urziceni.addEdge(142, vaslui);

        hirsova.addEdge(98, urziceni);
        hirsova.addEdge(86, eforie);

        eforie.addEdge(86, hirsova);

        vaslui.addEdge(142, iasi);

        iasi.addEdge(142, vaslui);
        iasi.addEdge(87, neamt);

        neamt.addEdge(87, iasi);

        // Build the graph
        Graph romaniaRoadGraph = new Graph();

        romaniaRoadGraph.addNode(oradea);
        romaniaRoadGraph.addNode(zerind);
        romaniaRoadGraph.addNode(arad);
        romaniaRoadGraph.addNode(timisoara);
        romaniaRoadGraph.addNode(lugoj);
        romaniaRoadGraph.addNode(mehadia);
        romaniaRoadGraph.addNode(drobeta);
        romaniaRoadGraph.addNode(craiova);
        romaniaRoadGraph.addNode(rimnicuvilcea);
        romaniaRoadGraph.addNode(pitesti);
        romaniaRoadGraph.addNode(sibiu);
        romaniaRoadGraph.addNode(fagaras);
        romaniaRoadGraph.addNode(bucharest);
        romaniaRoadGraph.addNode(giurgiu);
        romaniaRoadGraph.addNode(urziceni);
        romaniaRoadGraph.addNode(hirsova);
        romaniaRoadGraph.addNode(eforie);
        romaniaRoadGraph.addNode(vaslui);
        romaniaRoadGraph.addNode(iasi);
        romaniaRoadGraph.addNode(neamt);

        Graph astar = romaniaRoadGraph.aStar(arad, bucharest);

        System.out.println("\nA*");
        System.out.println(astar);
    }
}

/***
 * Custom node that includes LOS to Bucharest
 */
class CustomNode {
    private final String cityName;
    private final int losToBucharest;

    CustomNode(String cityName, int losToBucharest) {
        this.cityName = cityName;
        this.losToBucharest = losToBucharest;
    }

    public int getLosToBucharest () {
        return losToBucharest;
    }

    @Override
    public String toString() {
        return cityName;
    }
}