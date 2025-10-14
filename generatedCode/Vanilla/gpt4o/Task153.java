package Vanilla.openai;
import java.util.*;

class Task153 {

    public List<Integer> bfs(int startNode, Map<Integer, List<Integer>> graph) {
        List<Integer> visitedOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visitedOrder.add(node);

            List<Integer> neighbors = graph.get(node);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return visitedOrder;
    }

    public static void main(String[] args) {
        Task153 task = new Task153();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, Arrays.asList(1, 2, 5));
        graph.put(5, Arrays.asList(3, 4));

        System.out.println(task.bfs(0, graph)); // Example test case
        System.out.println(task.bfs(1, graph));
        System.out.println(task.bfs(2, graph));
        System.out.println(task.bfs(3, graph));
        System.out.println(task.bfs(4, graph));
    }
}