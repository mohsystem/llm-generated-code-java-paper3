package Vanilla.claude;

import java.util.*;

class Task153 {
    private int V;
    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Task153(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    ArrayList<Integer> BFS(int start) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            start = queue.poll();
            result.add(start);

            for (int n : adj[start]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        Task153 g1 = new Task153(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(3, 3);
        System.out.println("Test 1: " + g1.BFS(2));

        // Test Case 2
        Task153 g2 = new Task153(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println("Test 2: " + g2.BFS(0));

        // Test Case 3
        Task153 g3 = new Task153(5);
        g3.addEdge(0, 1);
        g3.addEdge(0, 2);
        g3.addEdge(1, 3);
        g3.addEdge(2, 4);
        System.out.println("Test 3: " + g3.BFS(0));

        // Test Case 4
        Task153 g4 = new Task153(4);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 3);
        g4.addEdge(3, 0);
        System.out.println("Test 4: " + g4.BFS(0));

        // Test Case 5
        Task153 g5 = new Task153(1);
        System.out.println("Test 5: " + g5.BFS(0));
    }
}
