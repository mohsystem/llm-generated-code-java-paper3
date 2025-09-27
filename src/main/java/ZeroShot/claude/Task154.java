package ZeroShot.claude;

import java.util.*;

public class Task154 {
    private int V;
    private List<List<Integer>> adj;
    
    public Task154(int vertices) {
        V = vertices;
        adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }
    
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }
    
    public List<Integer> DFS(int start) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();
        DFSUtil(start, visited, result);
        return result;
    }
    
    private void DFSUtil(int v, boolean[] visited, List<Integer> result) {
        visited[v] = true;
        result.add(v);
        
        for(int n : adj.get(v)) {
            if(!visited[n]) {
                DFSUtil(n, visited, result);
            }
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1
        Task154 g1 = new Task154(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(3, 3);
        System.out.println("DFS from vertex 2: " + g1.DFS(2));
        
        // Test Case 2
        Task154 g2 = new Task154(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println("DFS from vertex 0: " + g2.DFS(0));
        
        // Test Case 3
        Task154 g3 = new Task154(5);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 3);
        g3.addEdge(3, 4);
        g3.addEdge(4, 0);
        System.out.println("DFS from vertex 0: " + g3.DFS(0));
        
        // Test Case 4
        Task154 g4 = new Task154(4);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 3);
        g4.addEdge(3, 0);
        System.out.println("DFS from vertex 3: " + g4.DFS(3));
        
        // Test Case 5
        Task154 g5 = new Task154(6);
        g5.addEdge(0, 1);
        g5.addEdge(0, 2);
        g5.addEdge(1, 3);
        g5.addEdge(2, 4);
        g5.addEdge(3, 5);
        System.out.println("DFS from vertex 0: " + g5.DFS(0));
    }
}
