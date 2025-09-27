package ourMethod.llama31;
import java.util.*;

public class Task154 {
    public static void dfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited) {
        visited.add(start);
        System.out.print(start + " ");
        for (int neighbor : graph.get(start)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2, 0, 3, 4));
        graph.put(2, Arrays.asList(0, 1, 4));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1, 2));

        Set<Integer> visited = new HashSet<>();
        dfs(graph, 0, visited);
    }
}