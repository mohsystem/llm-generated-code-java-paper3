package CoT.openai;
import java.util.*;

public class Task153 {
    public List<Integer> bfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        queue.add(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!seen.contains(neighbor)) {
                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        Task153 task = new Task153();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(4, 5));
        graph.put(4, Collections.emptyList());
        graph.put(5, Collections.emptyList());

        System.out.println(task.bfs(graph, 1)); // Test case 1
        System.out.println(task.bfs(graph, 2)); // Test case 2
        System.out.println(task.bfs(graph, 3)); // Test case 3
        System.out.println(task.bfs(graph, 4)); // Test case 4
        System.out.println(task.bfs(graph, 5)); // Test case 5
    }
}