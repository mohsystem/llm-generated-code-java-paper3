package ourMethod.llama31;
import java.util.*;

public class Task162 {
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
        int startNode = 0;
        dijkstra(graph1, startNode);

        int[][] graph2 = {
            {0, 1, 0, 0},
            {1, 0, 1, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0}
        };
        startNode = 0;
        dijkstra(graph2, startNode);
    }

    public static void dijkstra(int[][] graph, int startNode) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        // Initialize distances
        for (int i = 0; i < numNodes; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[startNode] = 0;

        for (int i = 0; i < numNodes; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;

            // Find the node with the minimum distance that has not been visited
            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minDistance = distances[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            // Update distances of adjacent nodes
            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && graph[minIndex][j] > 0 && distances[minIndex] + graph[minIndex][j] < distances[j]) {
                    distances[j] = distances[minIndex] + graph[minIndex][j];
                }
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.print(distances[i] + " ");
        }
        System.out.println();
    }
}