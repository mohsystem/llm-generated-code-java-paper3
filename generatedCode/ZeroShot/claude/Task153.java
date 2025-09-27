package ZeroShot.claude;

import java.util.*;

class Task153 {
    private int V;
    private List<List<Integer>> adj;
    
    public Task153(int v) {
        V = v;
        adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }
    
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }
    
    public List<Integer> BFS(int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int s = queue.poll();
            result.add(s);
            
            for(int n : adj.get(s)) {
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test Case 1: Simple graph with 4 nodes
        Task153 g1 = new Task153(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(3, 3);
        System.out.println("Test 1: " + g1.BFS(2));
        
        // Test Case 2: Linear graph
        Task153 g2 = new Task153(5);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(3, 4);
        System.out.println("Test 2: " + g2.BFS(0));
        
        // Test Case 3: Disconnected graph
        Task153 g3 = new Task153(7);
        g3.addEdge(0, 1);
        g3.addEdge(2, 3);
        g3.addEdge(4, 5);
        g3.addEdge(5, 6);
        System.out.println("Test 3: " + g3.BFS(4));
        
        // Test Case 4: Cyclic graph
        Task153 g4 = new Task153(4);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 3);
        g4.addEdge(3, 0);
        System.out.println("Test 4: " + g4.BFS(0));
        
        // Test Case 5: Single node
        Task153 g5 = new Task153(1);
        System.out.println("Test 5: " + g5.BFS(0));
    }
}
