package CoT.gpt4o;
import java.util.*;

public class Task162 {
    static class Graph {
        private final Map<Integer, List<Node>> nodes;

        public Graph() {
            nodes = new HashMap<>();
        }

        public void addEdge(int source, int target, int weight) {
            nodes.computeIfAbsent(source, k -> new ArrayList<>()).add(new Node(target, weight));
            nodes.computeIfAbsent(target, k -> new ArrayList<>());
        }

        public Map<Integer, Integer> dijkstra(int start) {
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
            Map<Integer, Integer> dist = new HashMap<>();
            Set<Integer> visited = new HashSet<>();

            pq.add(new Node(start, 0));
            dist.put(start, 0);

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                if (!visited.add(current.id)) continue;

                for (Node neighbor : nodes.getOrDefault(current.id, Collections.emptyList())) {
                    if (visited.contains(neighbor.id)) continue;

                    int newDist = dist.get(current.id) + neighbor.cost;
                    if (newDist < dist.getOrDefault(neighbor.id, Integer.MAX_VALUE)) {
                        dist.put(neighbor.id, newDist);
                        pq.add(new Node(neighbor.id, newDist));
                    }
                }
            }

            return dist;
        }

        static class Node {
            int id, cost;

            Node(int id, int cost) {
                this.id = id;
                this.cost = cost;
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);

        Map<Integer, Integer> shortestPaths = graph.dijkstra(0);

        for (Map.Entry<Integer, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("Node " + entry.getKey() + " has shortest distance: " + entry.getValue());
        }
    }
}