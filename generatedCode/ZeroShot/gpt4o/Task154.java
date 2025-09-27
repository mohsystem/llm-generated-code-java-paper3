package ZeroShot.gpt4o;
import java.util.*;

class Task154 {
    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;

    public Task154() {
        graph = new HashMap<>();
        visited = new HashSet<>();
    }

    public void addEdge(int source, int destination) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.get(source).add(destination);
    }

    public List<Integer> depthFirstSearch(int startNode) {
        List<Integer> result = new ArrayList<>();
        dfs(startNode, result);
        return result;
    }

    private void dfs(int node, List<Integer> result) {
        if (!visited.contains(node)) {
            visited.add(node);
            result.add(node);
            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                dfs(neighbor, result);
            }
        }
    }

    public static void main(String[] args) {
        Task154 graph = new Task154();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(graph.depthFirstSearch(2)); // Test case 1
        System.out.println(graph.depthFirstSearch(0)); // Test case 2
        System.out.println(graph.depthFirstSearch(1)); // Test case 3
        System.out.println(graph.depthFirstSearch(3)); // Test case 4
        System.out.println(graph.depthFirstSearch(4)); // Test case 5 (node not connected)
    }
}