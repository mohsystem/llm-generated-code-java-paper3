package CoT.gpt4o;
import java.util.*;

public class Task154 {
    public static List<Integer> depthFirstSearch(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);
                List<Integer> neighbors = graph.get(node);
                if (neighbors != null) {
                    for (int neighbor : neighbors) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 5));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1, 5));
        graph.put(5, Arrays.asList(2, 4));

        List<Integer> result1 = depthFirstSearch(graph, 0);
        List<Integer> result2 = depthFirstSearch(graph, 1);
        List<Integer> result3 = depthFirstSearch(graph, 2);
        List<Integer> result4 = depthFirstSearch(graph, 3);
        List<Integer> result5 = depthFirstSearch(graph, 4);
        
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }
}