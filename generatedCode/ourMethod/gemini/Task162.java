package ourMethod.gemini;
import java.util.*;

public class Task162 {

    public static Map<Integer, Integer> dijkstra(Map<Integer, Map<Integer, Integer>> graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int distU = current[1];

            if (distU > distances.get(u)) {
                continue;
            }

            if (!graph.containsKey(u)) {
                continue;  // Handle cases where the starting node has no outgoing edges.
            }

            for (Map.Entry<Integer, Integer> neighbor : graph.get(u).entrySet()) {
                int v = neighbor.getKey();
                int weightUV = neighbor.getValue();

                if (weightUV < 0) {
                    throw new IllegalArgumentException("Negative edge weight detected.");
                }

                int distV = distU + weightUV;
                if (distV < distances.get(v)) {
                    distances.put(v, distV);
                    pq.offer(new int[]{v, distV});
                }
            }
        }
        return distances;
    }


    public static void main(String[] args) {

        // Test cases
        Map<Integer, Map<Integer, Integer>> graph1 = new HashMap<>();
        graph1.put(0, new HashMap<>());
        graph1.put(1, new HashMap<>());
        graph1.put(2, new HashMap<>());
        graph1.put(3, new HashMap<>());
        graph1.get(0).put(1, 4);
        graph1.get(0).put(2, 1);
        graph1.get(1).put(3, 1);
        graph1.get(2).put(1, 2);
        graph1.get(2).put(3, 5);
        System.out.println(dijkstra(graph1, 0));


        Map<Integer, Map<Integer, Integer>> graph2 = new HashMap<>(); // Empty graph
        System.out.println(dijkstra(graph2, 0));

        Map<Integer, Map<Integer, Integer>> graph3 = new HashMap<>();
        graph3.put(0, new HashMap<>());
        System.out.println(dijkstra(graph3, 0));// Single node graph


        Map<Integer, Map<Integer, Integer>> graph4 = new HashMap<>(); // Disconnected graph
        graph4.put(0, new HashMap<>());
        graph4.get(0).put(1, 4);
        graph4.put(2, new HashMap<>());
        graph4.get(2).put(3, 1);
        System.out.println(dijkstra(graph4, 0));

        Map<Integer, Map<Integer, Integer>> graph5 = new HashMap<>(); // Graph with a cycle
        graph5.put(0, new HashMap<>());
        graph5.get(0).put(1, 4);
        graph5.get(0).put(2, 2);
        graph5.put(1, new HashMap<>());
        graph5.get(1).put(2, 1);
        graph5.put(2, new HashMap<>());
        graph5.get(2).put(0, 1);

        System.out.println(dijkstra(graph5, 0));

    }
}