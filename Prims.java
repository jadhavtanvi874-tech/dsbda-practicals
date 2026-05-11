import java.util.Scanner;

public class Prims {

    static int findMinVertex(int key[], boolean visited[], int v) {

        int minVertex = -1;

        for (int i = 0; i < v; i++) {

            if (!visited[i] &&
               (minVertex == -1 || key[i] < key[minVertex])) {

                minVertex = i;
            }
        }

        return minVertex;
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

        int parent[] = new int[v];
        int key[] = new int[v];
        boolean visited[] = new boolean[v];

        for (int i = 0; i < v; i++) {

            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < v - 1; i++) {

            int minVertex = findMinVertex(key, visited, v);

            visited[minVertex] = true;

            for (int j = 0; j < v; j++) {

                if (graph[minVertex][j] != 0 &&
                    !visited[j] &&
                    graph[minVertex][j] < key[j]) {

                    key[j] = graph[minVertex][j];
                    parent[j] = minVertex;
                }
            }
        }

        System.out.println("\nMinimum Spanning Tree:\n");

        int totalWeight = 0;

        for (int i = 1; i < v; i++) {

            System.out.println(
                vertex[parent[i]] + " - " +
                vertex[i] + " = " +
                graph[i][parent[i]]
            );

            totalWeight += graph[i][parent[i]];
        }

        System.out.println("\nTotal Weight = " + totalWeight);

        sc.close();
    }
}