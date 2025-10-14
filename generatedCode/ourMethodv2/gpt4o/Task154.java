package ourMethodv2.gpt4o;
import java.util.*;

class Task154 {
    private Map<Integer, List<Integer>> adjList;

    public Task154() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);
    }

    public List<Integer> depthFirstSearch(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(start, visited, result);
        return result;
    }

    private void dfs(int node, Set<Integer> visited, List<Integer> result) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        result.add(node);
        if (adjList.containsKey(node)) {
            for (int neighbor : adjList.get(node)) {
                dfs(neighbor, visited, result);
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

        System.out.println(graph.depthFirstSearch(2)); // [2, 0, 1, 3]
        System.out.println(graph.depthFirstSearch(0)); // [0, 1, 2, 3]
        System.out.println(graph.depthFirstSearch(1)); // [1, 2, 0, 3]
        System.out.println(graph.depthFirstSearch(3)); // [3]
        System.out.println(graph.depthFirstSearch(4)); // [4]
    }
}