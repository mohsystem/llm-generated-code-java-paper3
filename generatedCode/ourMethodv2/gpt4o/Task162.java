package ourMethodv2.gpt4o;
import java.util.*;

class Task162 {

    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static Map<Integer, Integer> dijkstra(Map<Integer, List<Edge>> graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        distances.put(start, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > distances.getOrDefault(node, Integer.MAX_VALUE)) continue;

            List<Edge> neighbors = graph.getOrDefault(node, Collections.emptyList());
            for (Edge edge : neighbors) {
                int newDist = dist + edge.weight;
                if (newDist < distances.getOrDefault(edge.target, Integer.MAX_VALUE)) {
                    distances.put(edge.target, newDist);
                    pq.add(new int[]{edge.target, newDist});
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 1)));
        graph.put(1, Arrays.asList(new Edge(3, 1)));
        graph.put(2, Arrays.asList(new Edge(1, 2), new Edge(3, 5)));
        graph.put(3, Arrays.asList(new Edge(4, 3)));
        graph.put(4, Collections.emptyList());

        System.out.println(dijkstra(graph, 0)); // {0=0, 1=3, 2=1, 3=4, 4=7}
        System.out.println(dijkstra(graph, 1)); // {1=0, 3=1, 4=4}
        System.out.println(dijkstra(graph, 2)); // {2=0, 1=2, 3=5, 4=8}
        System.out.println(dijkstra(graph, 3)); // {3=0, 4=3}
        System.out.println(dijkstra(graph, 4)); // {4=0}
    }
}