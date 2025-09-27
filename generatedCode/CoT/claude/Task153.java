package CoT.claude;

import java.util.*;

public class Task153 {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public Task153(int v) {
        vertices = v;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        if (v >= 0 && v < vertices && w >= 0 && w < vertices) {
            adjacencyList.get(v).add(w);
        }
    }

    public List<Integer> bfs(int startVertex) {
        if (startVertex < 0 || startVertex >= vertices) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Simple graph
        Task153 g1 = new Task153(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(3, 3);
        System.out.println("Test 1: " + g1.bfs(2));

        // Test Case 2: Linear graph
        Task153 g2 = new Task153(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println("Test 2: " + g2.bfs(0));

        // Test Case 3: Disconnected graph
        Task153 g3 = new Task153(4);
        g3.addEdge(0, 1);
        g3.addEdge(2, 3);
        System.out.println("Test 3: " + g3.bfs(0));

        // Test Case 4: Single node
        Task153 g4 = new Task153(1);
        System.out.println("Test 4: " + g4.bfs(0));

        // Test Case 5: Empty graph
        Task153 g5 = new Task153(0);
        System.out.println("Test 5: " + g5.bfs(0));
    }
}
