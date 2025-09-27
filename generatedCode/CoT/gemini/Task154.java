package CoT.gemini;
import java.util.*;

public class Task154 {
    private static Map<Integer, List<Integer>> graph;
    private static Set<Integer> visited;

    public static List<Integer> depthFirstSearch(Map<Integer, List<Integer>> graphInput, int startNode) {
        graph = graphInput;
        visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        dfs(startNode, result);
        return result;
    }

    private static void dfs(int node, List<Integer> result) {
        visited.add(node);
        result.add(node);
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, result);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 2));
        graph1.put(1, Arrays.asList(2));
        graph1.put(2, Arrays.asList(0, 3));
        graph1.put(3, Arrays.asList(3));
        System.out.println(depthFirstSearch(graph1, 2));

        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1, 2));
        graph2.put(1, Arrays.asList(0, 3, 4));
        graph2.put(2, Arrays.asList(0));
        graph2.put(3, Arrays.asList(1));
        graph2.put(4, Arrays.asList(1));

        System.out.println(depthFirstSearch(graph2, 0));

         Map<Integer, List<Integer>> graph3 = new HashMap<>();
        System.out.println(depthFirstSearch(graph3, 0));


        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(0, Arrays.asList(1,2,3));
        System.out.println(depthFirstSearch(graph4, 0));

        Map<Integer, List<Integer>> graph5 = new HashMap<>();
        graph5.put(0, new ArrayList<>());
        System.out.println(depthFirstSearch(graph5, 0));

    }
}