package Vanilla.gpt4o;
import java.util.*;

public class Task162 {
    static class Graph {
        private final int vertices;
        private final LinkedList<Edge>[] adjacencyList;

        static class Edge {
            int target;
            int weight;

            Edge(int target, int weight) {
                this.target = target;
                this.weight = weight;
            }
        }

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int target, int weight) {
            adjacencyList[source].add(new Edge(target, weight));
        }

        int[] dijkstra(int startVertex) {
            int[] distances = new int[vertices];
            boolean[] visited = new boolean[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{startVertex, 0});

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int currentVertex = current[0];

                if (visited[currentVertex]) continue;
                visited[currentVertex] = true;

                for (Edge edge : adjacencyList[currentVertex]) {
                    int neighbor = edge.target;
                    int newDist = distances[currentVertex] + edge.weight;

                    if (!visited[neighbor] && newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                        pq.add(new int[]{neighbor, newDist});
                    }
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 1, 4);
        graph.addEdge(2, 3, 8);
        graph.addEdge(1, 3, 2);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 3, 9);

        int[] distances = graph.dijkstra(0);
        System.out.println(Arrays.toString(distances));
    }
}