package ZeroShot.llama31;
import java.util.*;

public class Task162 {
    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;

        // Priority queue to store nodes to be visited
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currentNode = node.node;
            int currentDistance = node.distance;

            if (visited[currentNode]) {
                continue;
            }

            visited[currentNode] = true;

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[currentNode][neighbor] > 0 && !visited[neighbor]) {
                    int newDistance = currentDistance + graph[currentNode][neighbor];
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        pq.add(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Print distances
        for (int i = 0; i < n; i++) {
            System.out.println("Shortest distance from " + start + " to " + i + ": " + distances[i]);
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int distance;

        Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
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
            {0, 2, 0, 6},
            {2, 0, 3, 8},
            {0, 3, 0, 0},
            {6, 8, 0, 0}
        };
        dijkstra(graph2, 0);

        int[][] graph3 = {
            {0, 1, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {0, 0, 1, 0}
        };
        dijkstra(graph3, 0);

        int[][] graph4 = {
            {0, 3, 0, 0},
            {3, 0, 2, 0},
            {0, 2, 0, 1},
            {0, 0, 1, 0}
        };
        dijkstra(graph4, 0);

        int[][] graph5 = {
            {0, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 0}
        };
        dijkstra(graph5, 0);
    }
}