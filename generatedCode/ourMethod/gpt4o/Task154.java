package ourMethod.gpt4o;
import java.util.*;

public class Task154 {

    public List<Integer> depthFirstSearch(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visitedSet.contains(node)) {
                visited.add(node);
                visitedSet.add(node);
                List<Integer> neighbors = graph.get(node);
                if (neighbors != null) {
                    for (int neighbor : neighbors) {
                        if (!visitedSet.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
        
        return visited;
    }

    public static void main(String[] args) {
        Task154 task = new Task154();
        
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 2));
        graph1.put(1, Arrays.asList(0, 3, 4));
        graph1.put(2, Arrays.asList(0));
        graph1.put(3, Arrays.asList(1));
        graph1.put(4, Arrays.asList(1, 5));
        graph1.put(5, Arrays.asList(4));

        System.out.println(task.depthFirstSearch(graph1, 0)); // Example output: [0, 2, 1, 4, 5, 3]
        
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1));
        graph2.put(1, Arrays.asList(0, 2));
        graph2.put(2, Arrays.asList(1, 3));
        graph2.put(3, Arrays.asList(2));

        System.out.println(task.depthFirstSearch(graph2, 0)); // Example output: [0, 1, 2, 3]
        
        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        graph3.put(0, Arrays.asList(1, 2, 3));
        graph3.put(1, Arrays.asList(0));
        graph3.put(2, Arrays.asList(0));
        graph3.put(3, Arrays.asList(0, 4));
        graph3.put(4, Arrays.asList(3));

        System.out.println(task.depthFirstSearch(graph3, 0)); // Example output: [0, 3, 4, 2, 1]
        
        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(0, Arrays.asList(1, 2));
        graph4.put(1, Arrays.asList(0));
        graph4.put(2, Arrays.asList(0, 3));
        graph4.put(3, Arrays.asList(2));

        System.out.println(task.depthFirstSearch(graph4, 0)); // Example output: [0, 2, 3, 1]

        Map<Integer, List<Integer>> graph5 = new HashMap<>();
        graph5.put(0, Arrays.asList(1));
        graph5.put(1, Arrays.asList(0, 2));
        graph5.put(2, Arrays.asList(1, 3, 4));
        graph5.put(3, Arrays.asList(2));
        graph5.put(4, Arrays.asList(2));

        System.out.println(task.depthFirstSearch(graph5, 0)); // Example output: [0, 1, 2, 4, 3]
    }
}