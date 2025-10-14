package ourMethod.openai;
import java.util.*;

public class Task153 {
    
    public List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedSet = new HashSet<>();

        queue.add(startNode);
        visitedSet.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);

            List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visitedSet.contains(neighbor)) {
                    queue.add(neighbor);
                    visitedSet.add(neighbor);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Task153 task = new Task153();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 5));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1, 5));
        graph.put(5, Arrays.asList(2, 4));

        System.out.println(task.bfs(graph, 0));
        System.out.println(task.bfs(graph, 1));
        System.out.println(task.bfs(graph, 2));
        System.out.println(task.bfs(graph, 3));
        System.out.println(task.bfs(graph, 4));
    }
}