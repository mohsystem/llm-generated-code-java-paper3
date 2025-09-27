package Vanilla.llama31;
import java.util.*;

class Task154 {
    static void dfs(int[][] graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 1, 1},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0}
        };

        // Test cases
        int[] startNodes = {0, 1, 2, 3, 4};
        for (int start : startNodes) {
            boolean[] visited = new boolean[graph.length];
            System.out.print("DFS starting from node " + start + ": ");
            dfs(graph, start, visited);
            System.out.println();
        }
    }
}