package ZeroShot.openai;
import java.util.*;

public class Task153 {
    public static List<Integer> bfs(int n, List<List<Integer>> adjList, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> graph = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(0, 3, 4),
            Arrays.asList(0, 4),
            Arrays.asList(1),
            Arrays.asList(1, 2)
        );
        
        System.out.println(bfs(5, graph, 0)); // Output: [0, 1, 2, 3, 4]
        System.out.println(bfs(5, graph, 1)); // Output: [1, 0, 3, 4, 2]
        System.out.println(bfs(5, graph, 2)); // Output: [2, 0, 4, 1, 3]
        System.out.println(bfs(5, graph, 3)); // Output: [3, 1, 0, 4, 2]
        System.out.println(bfs(5, graph, 4)); // Output: [4, 1, 2, 0, 3]
    }
}