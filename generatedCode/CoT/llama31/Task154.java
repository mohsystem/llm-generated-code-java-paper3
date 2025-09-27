package CoT.llama31;
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
        // Test case 1
        List<List<Integer>> graph1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            graph1.add(new ArrayList<>());
        }
        graph1.get(0).add(1);
        graph1.get(0).add(2);
        graph1.get(1).add(3);
        graph1.get(2).add(4);
        boolean[] visited1 = new boolean[5];
        System.out.println("DFS Traversal starting from node 0:");
        dfs(graph1, 0, visited1);

        // Test case 2
        List<List<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph2.add(new ArrayList<>());
        }
        graph2.get(0).add(1);
        graph2.get(0).add(2);
        graph2.get(1).add(3);
        graph2.get(2).add(4);
        graph2.get(3).add(5);
        boolean[] visited2 = new boolean[6];
        System.out.println("\nDFS Traversal starting from node 0:");
        dfs(graph2, 0, visited2);

        // Test case 3
        List<List<Integer>> graph3 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            graph3.add(new ArrayList<>());
        }
        graph3.get(0).add(1);
        graph3.get(1).add(2);
        graph3.get(2).add(3);
        boolean[] visited3 = new boolean[4];
        System.out.println("\nDFS Traversal starting from node 0:");
        dfs(graph3, 0, visited3);

        // Test case 4
        List<List<Integer>> graph4 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            graph4.add(new ArrayList<>());
        }
        graph4.get(0).add(1);
        graph4.get(1).add(2);
        boolean[] visited4 = new boolean[3];
        System.out.println("\nDFS Traversal starting from node 0:");
        dfs(graph4, 0, visited4);

        // Test case 5
        List<List<Integer>> graph5 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            graph5.add(new ArrayList<>());
        }
        graph5.get(0).add(1);
        boolean[] visited5 = new boolean[2];
        System.out.println("\nDFS Traversal starting from node 0:");
        dfs(graph5, 0, visited5);
    }
}