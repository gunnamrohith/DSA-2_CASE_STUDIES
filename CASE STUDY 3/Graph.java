import java.util.*;

class Graph {

    private HashMap<String, ArrayList<String>> adjList;

    Graph() {

        adjList = new HashMap<>();
    }

    // Add Edge
    void addEdge(String source, String destination) {

        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());

        adjList.get(source).add(destination);
    }

    // DFS Cycle Detection
    boolean dfs(String node,
                HashMap<String, Boolean> visited,
                HashMap<String, Boolean> recursionStack) {

        visited.put(node, true);

        recursionStack.put(node, true);

        System.out.println("Visiting: " + node);

        for (String neighbor : adjList.get(node)) {

            // If not visited
            if (!visited.get(neighbor)) {

                if (dfs(neighbor, visited, recursionStack)) {

                    return true;
                }
            }

            // Cycle detected
            else if (recursionStack.get(neighbor)) {

                System.out.println(
                        "\nCycle Detected at edge: "
                        + node
                        + " -> "
                        + neighbor);

                return true;
            }
        }

        recursionStack.put(node, false);

        return false;
    }

    // Detect Cycle
    void detectCycle() {

        HashMap<String, Boolean> visited = new HashMap<>();

        HashMap<String, Boolean> recursionStack = new HashMap<>();

        // Initialize
        for (String node : adjList.keySet()) {

            visited.put(node, false);
            recursionStack.put(node, false);
        }

        // DFS Traversal
        for (String node : adjList.keySet()) {

            if (!visited.get(node)) {

                if (dfs(node, visited, recursionStack)) {

                    System.out.println(
                            "\nWorkflow Rejected due to cyclic dependency.");

                    return;
                }
            }
        }

        System.out.println("No Cycle Detected.");
    }
}