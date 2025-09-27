package ZeroShot.gpt4o;
import java.util.*;

public class Task162 {
    static class Node implements Comparable<Node> {
        int id;
        int cost;

        Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static Map<Integer, Integer> dijkstra(Map<Integer, List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (Integer node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (!visited.add(current.id)) {
                continue;
            }

            for (Node neighbor : graph.get(current.id)) {
                if (visited.contains(neighbor.id)) {
                    continue;
                }
                int newDist = distances.get(current.id) + neighbor.cost;
                if (newDist < distances.get(neighbor.id)) {
                    distances.put(neighbor.id, newDist);
                    pq.add(new Node(neighbor.id, newDist));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Node(1, 4), new Node(2, 1)));
        graph.put(1, Arrays.asList(new Node(3, 1)));
        graph.put(2, Arrays.asList(new Node(1, 2), new Node(3, 5)));
        graph.put(3, Arrays.asList());

        System.out.println(dijkstra(graph, 0));
    }
}