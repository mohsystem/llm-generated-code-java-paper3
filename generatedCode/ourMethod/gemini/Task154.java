package ourMethod.gemini;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Task154 {
    public static List<Integer> depthFirstSearch(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        if (!graph.containsKey(startNode)) {
            return visited; // Handle cases where startNode is not in the graph.
        }

        stack.push(startNode);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                List<Integer> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        // Test cases
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, List.of(1, 2));
        graph1.put(1, List.of(2));
        graph1.put(2, List.of(0, 3));
        graph1.put(3, List.of(3));
        System.out.println(depthFirstSearch(graph1, 2)); // Expected: [2, 0, 1, 3]


        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, List.of(1, 2));
        graph2.put(1, List.of(0, 3, 4));
        graph2.put(2, List.of(0));
        graph2.put(3, List.of(1));
        graph2.put(4, List.of(1));
        System.out.println(depthFirstSearch(graph2, 0)); // Expected: [0, 2, 1, 4, 3]

        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        System.out.println(depthFirstSearch(graph3, 0)); // Expected: [] - Empty graph

        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(0, List.of());
        System.out.println(depthFirstSearch(graph4, 0)); // Expected: [0] - Single node

        Map<Integer, List<Integer>> graph5 = new HashMap<>();
        graph5.put(0, List.of(1, 2));
        graph5.put(1, List.of(3));
        graph5.put(2, List.of(4));
        graph5.put(3, List.of());
        graph5.put(4, List.of());
        System.out.println(depthFirstSearch(graph5, 0)); // Expected: [0, 2, 4, 1, 3]
    }
}