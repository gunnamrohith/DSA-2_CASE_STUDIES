public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        // Workflow Dependencies

        graph.addEdge("build", "test");

        graph.addEdge("test", "integration");

        graph.addEdge("integration", "build");

        graph.addEdge("deploy", "build");

        System.out.println(
                "GitHub Actions Workflow Cycle Detection\n");

        graph.detectCycle();
    }
}