import java.util.*;

class Edge {

    String destination;
    int weight;

    Edge(String destination, int weight) {

        this.destination = destination;
        this.weight = weight;
    }
}

class Pair {

    String node;
    int cost;

    Pair(String node, int cost) {

        this.node = node;
        this.cost = cost;
    }
}

class Graph {

    private HashMap<String, ArrayList<Edge>> adjList;

    Graph() {

        adjList = new HashMap<>();
    }

    // Add Edge
    void addEdge(String source,
                 String destination,
                 int weight) {

        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());

        adjList.get(source)
                .add(new Edge(destination, weight));

        adjList.get(destination)
                .add(new Edge(source, weight));
    }

    // Dijkstra Algorithm
    void dijkstra(String start, String end) {

        HashMap<String, Integer> distance =
                new HashMap<>();

        HashMap<String, String> parent =
                new HashMap<>();

        // Initialize distances
        for (String node : adjList.keySet()) {

            distance.put(node, Integer.MAX_VALUE);
        }

        distance.put(start, 0);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        (a, b) -> a.cost - b.cost);

        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            String currentNode = current.node;

            int currentCost = current.cost;

            // Traverse neighbors
            for (Edge edge : adjList.get(currentNode)) {

                int newCost =
                        currentCost + edge.weight;

                if (newCost
                        < distance.get(edge.destination)) {

                    distance.put(edge.destination,
                            newCost);

                    parent.put(edge.destination,
                            currentNode);

                    pq.add(
                            new Pair(edge.destination,
                                    newCost));
                }
            }
        }

        // Reconstruct Path
        ArrayList<String> path = new ArrayList<>();

        String current = end;

        while (current != null) {

            path.add(current);

            current = parent.get(current);
        }

        Collections.reverse(path);

        // Output
        System.out.println("\nOptimal Toll Route:");

        for (String node : path) {

            System.out.print(node + " ");
        }

        System.out.println();

        System.out.println("\nMinimum Toll Cost: "
                + distance.get(end));
    }
}