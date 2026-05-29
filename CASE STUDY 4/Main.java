public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        // Toll Plaza Connections

        graph.addEdge("KTR", "URS", 5);

        graph.addEdge("KTR", "DNA", 7);

        graph.addEdge("URS", "TLG", 6);

        graph.addEdge("DNA", "KRD", 4);

        graph.addEdge("TLG", "DEN", 8);

        graph.addEdge("KRD", "DEN", 5);

        graph.addEdge("DEN", "PUN", 3);

        System.out.println(
                "Pune-Mumbai Dynamic Toll Dijkstra\n");

        System.out.println(
                "Finding minimum toll route from KTR to PUN");

        // Run Dijkstra
        graph.dijkstra("KTR", "PUN");
    }
}