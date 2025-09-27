package ourMethod.gemini;
import java.util.*;

public class Task153 {
    public static List<Integer> breadthFirstSearch(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startNode);
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (!graph.containsKey(currentNode)) {
                continue; // Handle cases where the start node has no neighbors
            }
            
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
        System.out.println(breadthFirstSearch(graph1, 2)); // Expected: [2, 0, 3, 1]

        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1, 2));
        graph2.put(1, Arrays.asList(0,3,4));
        graph2.put(2, new ArrayList<>());
        graph2.put(3, Arrays.asList(1));
        graph2.put(4, Arrays.asList(1));
        System.out.println(breadthFirstSearch(graph2, 0)); // Expected: [0, 1, 2, 3, 4]

        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        System.out.println(breadthFirstSearch(graph3, 0)); // Expected: [0]
        
        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(0, Arrays.asList(1,2));
        System.out.println(breadthFirstSearch(graph4, 0)); // Expected: [0, 1, 2]

        Map<Integer, List<Integer>> graph5 = new HashMap<>();
        graph5.put(0, Arrays.asList(1, 2, 3));
        graph5.put(1, Arrays.asList(0, 4));
        graph5.put(2, Arrays.asList(0, 5));
        graph5.put(3, Arrays.asList(0, 6));
        graph5.put(4, Arrays.asList(1));
        graph5.put(5, Arrays.asList(2));
        graph5.put(6, Arrays.asList(3));
        System.out.println(breadthFirstSearch(graph5, 0)); // Expected: [0, 1, 2, 3, 4, 5, 6]

    }
}