package ZeroShot.llama31;
import java.util.*;

public class Task154 {
    public static void dfs(List<List<Integer>> graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int neighbor : graph.get(start)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(3).add(5);

        // Test cases
        for (int i = 0; i < 5; i++) {
            boolean[] visited = new boolean[6];
            System.out.println("DFS starting from node " + i + ":");
            dfs(graph, i, visited);
            System.out.println();
        }
    }
}