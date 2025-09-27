package ZeroShot.gemini;
import java.util.*;

class Task154 {
    private Map<Integer, List<Integer>> graph;

    public Task154(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
    }

    public List<Integer> depthFirstSearch(int startNode) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                if (graph.containsKey(currentNode)) {
                    for (int neighbor : graph.get(currentNode)) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
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
        Task154 dfs1 = new Task154(graph1);
        System.out.println(dfs1.depthFirstSearch(2));


        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1, 2));
        graph2.put(1, Arrays.asList(0, 3, 4));
        graph2.put(2, Arrays.asList(0));
        graph2.put(3, Arrays.asList(1));
        graph2.put(4, Arrays.asList(1));
        Task154 dfs2 = new Task154(graph2);
        System.out.println(dfs2.depthFirstSearch(0));

        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        Task154 dfs3 = new Task154(graph3);
        System.out.println(dfs3.depthFirstSearch(0));

        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(0, Arrays.asList());
        Task154 dfs4 = new Task154(graph4);
        System.out.println(dfs4.depthFirstSearch(0));

        Map<Integer, List<Integer>> graph5 = new HashMap<>();
        graph5.put(0, Arrays.asList(1, 2, 3));
        graph5.put(1, Arrays.asList(0, 4));
        graph5.put(2, Arrays.asList(0, 5));
        graph5.put(3, Arrays.asList(0, 6));
        graph5.put(4, Arrays.asList(1));
        graph5.put(5, Arrays.asList(2));
        graph5.put(6, Arrays.asList(3));
        Task154 dfs5 = new Task154(graph5);
        System.out.println(dfs5.depthFirstSearch(0));
    }
}