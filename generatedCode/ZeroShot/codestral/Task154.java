package ZeroShot.codestral;
import java.util.*;

public class Task154 {
    private static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4, 5));
        graph.put(3, Arrays.asList(1, 6));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(2));
        graph.put(6, Arrays.asList(3));

        int startNode = 1;
        Set<Integer> visited = new HashSet<>();
        dfs(graph, startNode, visited);
    }
}