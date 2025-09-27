package Vanilla.codestral;
import java.util.*;

class Node3 implements Comparable<Node3> {
    int vertex;
    int distance;

    Node3(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node3 other) {
        return this.distance - other.distance;
    }
}

public class Task162 {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int start) {
        int V = graph.length;
        int[] distances = new int[V];
        boolean[] visited = new boolean[V];

        PriorityQueue<Node3> queue = new PriorityQueue<>();

        for (int i = 0; i < V; i++) {
            distances[i] = INFINITY;
        }

        distances[start] = 0;
        queue.add(new Node3(start, 0));

        while (!queue.isEmpty()) {
            int u = queue.poll().vertex;

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && distances[u] != INFINITY && distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                    queue.add(new Node3(v, distances[v]));
                }
            }
        }

        System.out.println("Shortest path from node " + start + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To node " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 20, 0, 0},
            {10, 0, 5, 2, 0},
            {20, 5, 0, 15, 6},
            {0, 2, 15, 0, 1},
            {0, 0, 6, 1, 0}
        };

        dijkstra(graph, 0);
    }
}