package Vanilla.llama31;
import java.util.*;

class Task153 {
    public static void bfs(int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < graph.length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[][] graph1 = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 1, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0}
        };
        System.out.println("BFS Traversal starting from node 0:");
        bfs(graph1, 0);

        int[][] graph2 = {
            {0, 1, 0, 0, 1},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };
        System.out.println("\nBFS Traversal starting from node 1:");
        bfs(graph2, 1);

        int[][] graph3 = {
            {0, 0, 1, 0},
            {0, 0, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };
        System.out.println("\nBFS Traversal starting from node 2:");
        bfs(graph3, 2);

        int[][] graph4 = {
            {0, 1, 0, 0},
            {1, 0, 1, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0}
        };
        System.out.println("\nBFS Traversal starting from node 0:");
        bfs(graph4, 0);

        int[][] graph5 = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        System.out.println("\nBFS Traversal starting from node 0:");
        bfs(graph5, 0);
    }
}