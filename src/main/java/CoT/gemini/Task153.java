package CoT.gemini;
import java.util.*;

public class Task153 {

    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (!graph.containsKey(currentNode)) continue; // Handle cases where the start node has no neighbors.

            for (int neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        // Test cases
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 2));
        graph1.put(1, Arrays.asList(2));
        graph1.put(2, Arrays.asList(0, 3));
        graph1.put(3, Arrays.asList(3));
        System.out.println(bfs(graph1, 2)); // Expected: [2, 0, 3, 1] or similar order

        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1, 2));
        graph2.put(1, Arrays.asList(0,3,4));
        graph2.put(2, Arrays.asList(0));
        graph2.put(3, Arrays.asList(1));
        graph2.put(4, Arrays.asList(1));

        System.out.println(bfs(graph2, 1));


        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        System.out.println(bfs(graph3, 1)); // Empty graph test case


        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(0, Arrays.asList(1, 2));
        System.out.println(bfs(graph4, 0));

        Map<Integer, List<Integer>> graph5 = new HashMap<>();
        graph5.put(0, new ArrayList<>());
        System.out.println(bfs(graph5, 0)); // Node with empty neighbor list
    }
}