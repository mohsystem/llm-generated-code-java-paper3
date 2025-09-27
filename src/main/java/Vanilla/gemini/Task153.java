package Vanilla.gemini;
import java.util.*;

class Task153 {
    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (!graph.containsKey(currentNode)) continue;

            for (int neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 2));
        graph1.put(1, Arrays.asList(2));
        graph1.put(2, Arrays.asList(0, 3));
        graph1.put(3, Arrays.asList(3));
        System.out.println(bfs(graph1, 2));


        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(1, Arrays.asList(2, 3));
        graph2.put(2, Arrays.asList(4, 5));
        System.out.println(bfs(graph2, 1));


        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        System.out.println(bfs(graph3, 1));

        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(0, new ArrayList<>());
        System.out.println(bfs(graph4, 0));

        Map<Integer, List<Integer>> graph5 = new HashMap<>();
        graph5.put(0, Arrays.asList(1, 2));
        graph5.put(1, Arrays.asList(0));
        graph5.put(2, Arrays.asList(0, 3));
        System.out.println(bfs(graph5, 0));
    }
}