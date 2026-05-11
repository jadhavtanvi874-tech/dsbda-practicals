import java.util.*;

public class GraphTraversalABC {

    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    GraphTraversalABC(int v) {
        V = v;
        adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    void DFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print((char)(v + 'A') + " ");

        for (int n : adj.get(v)) {
            if (!visited[n]) DFS(n, visited);
        }
    }

    void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print((char)(v + 'A') + " ");

            for (int n : adj.get(v)) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int nodes = sc.nextInt();

        GraphTraversalABC g = new GraphTraversalABC(nodes);

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter edges (A B format):");

        for (int i = 0; i < edges; i++) {
            char u = sc.next().charAt(0);
            char v = sc.next().charAt(0);

            g.addEdge(u - 'A', v - 'A');
        }

        System.out.print("Enter starting node: ");
        char start = sc.next().charAt(0);

        System.out.println("\nDFS:");
        g.DFS(start - 'A', new boolean[nodes]);

        System.out.println("\nBFS:");
        g.BFS(start - 'A');
    }
}