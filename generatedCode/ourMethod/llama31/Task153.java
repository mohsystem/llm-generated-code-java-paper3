package ourMethod.llama31;
import java.util.*;

public class Task153 {
    public static void bfs(int[][] graph, int start) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {0, 1, 0, 1, 0}
        };

        System.out.println("BFS Traversal starting from vertex 0:");
        bfs(graph, 0);

        System.out.println("\nBFS Traversal starting from vertex 1:");
        bfs(graph, 1);

        System.out.println("\nBFS Traversal starting from vertex 2:");
        bfs(graph, 2);

        System.out.println("\nBFS Traversal starting from vertex 3:");
        bfs(graph, 3);

        System.out.println("\nBFS Traversal starting from vertex 4:");
        bfs(graph, 4);
    }
}