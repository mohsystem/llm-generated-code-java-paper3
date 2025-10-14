package ourMethodv2.gpt4o;
import java.util.*;

public class Task153 {

    public List<Integer> breadthFirstSearch(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedSet = new HashSet<>();

        queue.add(startNode);
        visitedSet.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited.add(currentNode);

            List<Integer> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());
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
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1, 2));
        
        System.out.println(task.breadthFirstSearch(graph, 0)); // [0, 1, 2, 3, 4]
        System.out.println(task.breadthFirstSearch(graph, 1)); // [1, 0, 3, 4, 2]
        System.out.println(task.breadthFirstSearch(graph, 2)); // [2, 0, 4, 1, 3]
        System.out.println(task.breadthFirstSearch(graph, 3)); // [3, 1, 0, 4, 2]
        System.out.println(task.breadthFirstSearch(graph, 4)); // [4, 1, 2, 0, 3]
    }
}