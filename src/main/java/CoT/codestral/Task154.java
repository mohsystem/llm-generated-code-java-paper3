package CoT.codestral;
import java.util.*;

public class Task154 {
    private static void depthFirstSearch(int start, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        visited.add(start);
        System.out.print(start + " ");

        List<Integer> neighbors = graph.get(start);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    depthFirstSearch(neighbor, graph, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Populate graph here

        depthFirstSearch(0, graph, new HashSet<>());
    }
}