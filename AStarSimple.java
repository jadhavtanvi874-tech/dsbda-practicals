import java.util.*;

class Node {
    String city;
    int cost;
    int heuristic;
    Node parent;

    Node(String city, int cost, int heuristic, Node parent) {
        this.city = city;
        this.cost = cost;
        this.heuristic = heuristic;
        this.parent = parent;
    }

    int totalCost() {
        return cost + heuristic;
    }
}

public class AStarSimple {

    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> hValue = new HashMap<>();
    static Map<String, Integer> edgeCost = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of edges
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        // Input edges
        for (int i = 0; i < edges; i++) {

            System.out.print("Enter source node: ");
            String src = sc.next();

            System.out.print("Enter destination node: ");
            String dest = sc.next();

            System.out.print("Enter cost: ");
            int cost = sc.nextInt();

            graph.putIfAbsent(src, new ArrayList<>());
            graph.get(src).add(dest);

            edgeCost.put(src + "-" + dest, cost);
        }

        // Number of heuristic values
        System.out.print("Enter number of nodes for heuristic: ");
        int n = sc.nextInt();

        // Input heuristic values
        for (int i = 0; i < n; i++) {

            System.out.print("Enter node: ");
            String node = sc.next();

            System.out.print("Enter heuristic value: ");
            int h = sc.nextInt();

            hValue.put(node, h);
        }

        // Start and goal
        System.out.print("Enter start node: ");
        String start = sc.next();

        System.out.print("Enter goal node: ");
        String goal = sc.next();

        aStar(start, goal);
    }

    static void aStar(String start, String goal) {

        PriorityQueue<Node> open = new PriorityQueue<>(
                Comparator.comparingInt(Node::totalCost));

        Set<String> closed = new HashSet<>();

        open.add(new Node(start, 0, hValue.get(start), null));

        while (!open.isEmpty()) {

            Node current = open.poll();

            if (current.city.equals(goal)) {
                printPath(current);
                return;
            }

            closed.add(current.city);

            List<String> neighbors = graph.getOrDefault(current.city, new ArrayList<>());

            for (String next : neighbors) {

                if (!closed.contains(next)) {

                    int newCost = current.cost +
                            edgeCost.get(current.city + "-" + next);

                    open.add(new Node(
                            next,
                            newCost,
                            hValue.get(next),
                            current));
                }
            }
        }

        System.out.println("Path not found");
    }

    static void printPath(Node goal) {

        List<String> path = new ArrayList<>();

        while (goal != null) {
            path.add(goal.city);
            goal = goal.parent;
        }

        Collections.reverse(path);

        System.out.println("Shortest Path: " + path);
    }
}