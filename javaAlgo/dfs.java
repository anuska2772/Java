import java.util.LinkedList;

public class GraphDFS {
    private LinkedList<Integer>[] adjLists;
    private boolean[] visited;

    // Graph Constructor
    GraphDFS(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // DFS traversal of the vertices reachable from v
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjLists[vertex]) {
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth First Search starting from vertex 2:");
        graph.DFS(2);
    }
}
