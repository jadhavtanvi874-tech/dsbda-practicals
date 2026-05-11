import java.util.*;

public class GraphTraversal {
    private int V; 
    private LinkedList<Integer>[] adj; 

    // Constructor to initialize the graph
    @SuppressWarnings("unchecked")
    GraphTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge (undirected)
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); 
    }

    // DFS Recursive Algorithm
    void DFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    // BFS Iterative Algorithm
    void BFS(int startNode) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int neighbor : adj[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int nodes = sc.nextInt();

        GraphTraversal g = new GraphTraversal(nodes);

        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // Checking for Out of Bounds error
            if (u < nodes && v < nodes) {
                g.addEdge(u, v);
            } else {
                System.out.println("Error: Node index " + u + " or " + v + " is out of range!");
            }
        }

        System.out.print("\nEnter the starting node for traversal: ");
        int start = sc.nextInt();

        System.out.println("\nDepth First Search (DFS) Result:");
        g.DFS(start, new boolean[nodes]);

        System.out.println("\n\nBreadth First Search (BFS) Result:");
        g.BFS(start);
        
        System.out.println();
        sc.close();
    }
}