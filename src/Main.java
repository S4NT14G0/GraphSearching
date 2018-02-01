public class Main {

    public static void main(String[] args) {

        // Create nodes
        Node<String> oradea = new Node<>("Oradea");
        Node<String> zerind = new Node<>("Zerind");
        Node<String> arad = new Node<>("Arad");
        Node<String> sibiu = new Node<>("Sibiu");
        Node<String> timisoara = new Node<>("Timisoara");
        Node<String> lugoj = new Node<>("Lugoj");
        Node<String> rimnicuvilcea = new Node<>("Rimnicu Vilcea");
        Node<String> fagaras = new Node<>("Fagaras");
        Node<String> bucharest = new Node<>("Bucharest");
        Node<String> pitesti = new Node<>("Pitesti");
        Node<String> mehadia = new Node<>("Mehadia");
        Node<String> drobeta = new Node<>("Drobeta");
        Node<String> craiova = new Node<>("Craiova");
        Node<String> giurgiu = new Node<>("Giurgiu");
        Node<String> urziceni = new Node<>("Urziceni");
        Node<String> vaslui = new Node<>("Vaslui");
        Node<String> iasi = new Node<>("Iasi");
        Node<String> neamt = new Node<>("Neamt");
        Node<String> hirsova = new Node<>("Hirsova");
        Node<String> eforie = new Node<>("Eforie");

        // Create all the edges
        oradea.addEdge(151, sibiu);
        oradea.addEdge(71, zerind);

        zerind.addEdge(71, oradea);
        zerind.addEdge(75, arad);

        arad.addEdge(75, arad);
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

        System.out.print(romaniaRoadGraph.toString());
    }
}
