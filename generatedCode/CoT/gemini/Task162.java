package CoT.gemini;
import java.util.*;

public class Task162 {

    public static Map<Integer, Integer> dijkstra(Map<Integer, Map<Integer, Integer>> graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (current.distance > distances.get(u)) {
                continue;
            }

            if (!graph.containsKey(u)) {
                continue;
            }

            for (Map.Entry<Integer, Integer> neighbor : graph.get(u).entrySet()) {
                int v = neighbor.getKey();
                int weight = neighbor.getValue();

                if (distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                    pq.offer(new Node(v, distances.get(v)));
                }
            }
        }
        return distances;
    }

    static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        // Test cases
        Map<Integer, Map<Integer, Integer>> graph1 = new HashMap<>();
        graph1.put(0, new HashMap<>());
        graph1.get(0).put(1, 4);
        graph1.get(0).put(2, 1);
        graph1.put(1, new HashMap<>());
        graph1.get(1).put(3, 1);
        graph1.put(2, new HashMap<>());
        graph1.get(2).put(1, 2);
        graph1.get(2).put(3, 5);
        graph1.put(3, new HashMap<>());

        System.out.println(dijkstra(graph1, 0));


        Map<Integer, Map<Integer, Integer>> graph2 = new HashMap<>(); // Empty graph
        System.out.println(dijkstra(graph2, 0));

        Map<Integer, Map<Integer, Integer>> graph3 = new HashMap<>();
        graph3.put(0, new HashMap<>());
        System.out.println(dijkstra(graph3, 0)); // Single node graph

        Map<Integer, Map<Integer, Integer>> graph4 = new HashMap<>();
        graph4.put(0, new HashMap<>());
        graph4.get(0).put(1, -1); // Negative edge (Dijkstra's doesn't handle negative edges correctly)
        System.out.println(dijkstra(graph4, 0));

        Map<Integer, Map<Integer, Integer>> graph5 = new HashMap<>();
        graph5.put(0, new HashMap<>());
        graph5.get(0).put(1, 10);
        graph5.get(0).put(2, 5);
        graph5.put(1, new HashMap<>());
        graph5.get(1).put(2, 2);
        graph5.put(2, new HashMap<>());
        graph5.get(2).put(3, 1);
        graph5.put(3, new HashMap<>());
        System.out.println(dijkstra(graph5, 0));


    }
}