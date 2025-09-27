package ourMethod.claude;

import java.util.*;

public class Task153 {
    private static void bfs(Map<Integer, List<Integer>> graph, int start) {
        if (graph == null || graph.isEmpty()) {
            return;
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            
            if (graph.containsKey(current)) {
                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 2));
        graph1.put(1, Arrays.asList(2));
        graph1.put(2, Arrays.asList(0, 3));
        graph1.put(3, Arrays.asList(3));
        System.out.print("Test 1: ");
        bfs(graph1, 2);
        System.out.println();
        
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(1, Arrays.asList(2, 3, 4));
        graph2.put(2, Arrays.asList(1, 5));
        graph2.put(3, Arrays.asList(1, 6));
        graph2.put(4, Arrays.asList(1));
        graph2.put(5, Arrays.asList(2));
        graph2.put(6, Arrays.asList(3));
        System.out.print("Test 2: ");
        bfs(graph2, 1);
        System.out.println();
        
        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        System.out.print("Test 3: ");
        bfs(graph3, 1);
        System.out.println();
        
        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(1, Arrays.asList(2));
        graph4.put(2, Arrays.asList(3));
        graph4.put(3, Arrays.asList(4));
        graph4.put(4, Arrays.asList(5));
        graph4.put(5, new ArrayList<>());
        System.out.print("Test 4: ");
        bfs(graph4, 1);
        System.out.println();
        
        Map<Integer, List<Integer>> graph5 = new HashMap<>();
        graph5.put(1, Arrays.asList(2, 3));
        graph5.put(2, Arrays.asList(4, 5));
        graph5.put(3, Arrays.asList(6, 7));
        System.out.print("Test 5: ");
        bfs(graph5, 1);
        System.out.println();
    }
}
