import java.util.Scanner;
import java.util.Arrays;

class Edge implements Comparable<Edge> {

    int src, dest, weight;

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class Kruskal {

    static int parent[];

    // Find parent
    static int find(int v) {

        while (parent[v] != v) {
            v = parent[v];
        }

        return v;
    }

    // Union
    static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        parent[rootA] = rootB;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        char vertex[] = new char[v];

        for (int i = 0; i < v; i++) {
            vertex[i] = (char)('A' + i);
        }

        int graph[][] = new int[v][v];

        // Input matrix
        System.out.println("\nEnter Adjacency Matrix:\n");

        System.out.print("   ");
        for (int i = 0; i < v; i++) {
            System.out.print(vertex[i] + "  ");
        }

        System.out.println();

        for (int i = 0; i < v; i++) {

            System.out.print(vertex[i] + "  ");

            for (int j = 0; j < v; j++) {

                graph[i][j] = sc.nextInt();
            }
        }

        // Count edges
        int edgeCount = 0;

        for (int i = 0; i < v; i++) {

            for (int j = i + 1; j < v; j++) {

                if (graph[i][j] != 0) {
                    edgeCount++;
                }
            }
        }

        // Store edges
        Edge edges[] = new Edge[edgeCount];

        int k = 0;

        for (int i = 0; i < v; i++) {

            for (int j = i + 1; j < v; j++) {

                if (graph[i][j] != 0) {

                    edges[k] = new Edge();

                    edges[k].src = i;
                    edges[k].dest = j;
                    edges[k].weight = graph[i][j];

                    k++;
                }
            }
        }

        // Sort edges
        Arrays.sort(edges);

        // Initialize parent
        parent = new int[v];

        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        // Kruskal Algorithm
        System.out.println("\nMinimum Spanning Tree:\n");

        int totalWeight = 0;
        int edgeUsed = 0;

        for (int i = 0; i < edgeCount; i++) {

            int a = find(edges[i].src);
            int b = find(edges[i].dest);

            // No cycle
            if (a != b) {

                System.out.println(
                    vertex[edges[i].src] + " - " +
                    vertex[edges[i].dest] + " = " +
                    edges[i].weight
                );

                totalWeight += edges[i].weight;

                union(a, b);

                edgeUsed++;
            }

            if (edgeUsed == v - 1) {
                break;
            }
        }

        System.out.println("\nTotal Weight = " + totalWeight);

        sc.close();
    }
}