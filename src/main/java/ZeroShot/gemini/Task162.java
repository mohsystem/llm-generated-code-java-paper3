package ZeroShot.gemini;
import java.util.*;

class Task162 {
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
            int distU = current.distance;

            if (distU > distances.get(u)) {
                continue;
            }

            if (!graph.containsKey(u)) continue;

            for (Map.Entry<Integer, Integer> neighbor : graph.get(u).entrySet()) {
                int v = neighbor.getKey();
                int weightUV = neighbor.getValue();

                int distV = distU + weightUV;
                if (distV < distances.get(v)) {
                    distances.put(v, distV);
                    pq.offer(new Node(v, distV));
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


    }
}