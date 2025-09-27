package ourMethod.gpt4o;
import java.util.*;

public class Task162 {
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static Map<Integer, Integer> dijkstra(Map<Integer, List<Edge>> graph, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        pq.add(new int[]{start, 0});
        distances.put(start, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            for (Edge edge : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int neighbor = edge.target;
                int newDist = currentDistance + edge.weight;

                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    pq.add(new int[]{neighbor, newDist});
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
        graph.put(3, Arrays.asList());
        graph.put(4, Arrays.asList(new Edge(0, 1), new Edge(3, 1)));

        System.out.println(dijkstra(graph, 0));
        System.out.println(dijkstra(graph, 1));
        System.out.println(dijkstra(graph, 2));
        System.out.println(dijkstra(graph, 3));
        System.out.println(dijkstra(graph, 4));
    }
}