import java.util.*;

public class DFSBFS 
{

    static int vertices;

    // DFS Recursive Function
    static void DFS(int graph[][], int start, boolean visited[]) 
	{

        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < vertices; i++) 
		{

            if (graph[start][i] == 1 && !visited[i]) 
			{
                DFS(graph, i, visited);
            }
        }
    }

    // BFS Function
    static void BFS(int graph[][], int start) 
	{

        boolean visited[] = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) 
		{

            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < vertices; i++) 
			{

                if (graph[node][i] == 1 && !visited[i]) 
				{

                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) 
	{

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        vertices = sc.nextInt();

        int graph[][] = new int[vertices][vertices];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < vertices; i++) 
		{
            for (int j = 0; j < vertices; j++) 
			{
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        boolean visited[] = new boolean[vertices];

        System.out.println("\nDFS Traversal:");
        DFS(graph, start, visited);

        System.out.println("\n");

        System.out.println("BFS Traversal:");
        BFS(graph, start);

        sc.close();
    }
}