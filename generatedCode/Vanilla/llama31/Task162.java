package Vanilla.llama31;
import java.util.*;

public class Task162 {
    public static void dijkstra(int[][] graph, int start) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        // Initialize distances and visited array
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[start] = 0;

        // Create a priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] > 0 && !visited[v] && dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Print shortest distances
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[][] graph1 = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        dijkstra(graph1, 0);

        int[][] graph2 = {
            {0, 1, 0, 0, 0},
            {1, 0, 2, 0, 0},
            {0, 2, 0, 3, 0},
            {0, 0, 3, 0, 1},
            {0, 0, 0, 1, 0}
        };
        dijkstra(graph2, 0);

        int[][] graph3 = {
            {0, 5, 0, 10},
            {5, 0, 3, 0},
            {0, 3, 0, 1},
            {10, 0, 1, 0}
        };
        dijkstra(graph3, 0);

        int[][] graph4 = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        dijkstra(graph4, 0);

        int[][] graph5 = {
            {0, 4, 0, 0},
            {4, 0, 8, 0},
            {0, 8, 0, 7},
            {0, 0, 7, 0}
        };
        dijkstra(graph5, 0);
    }
}