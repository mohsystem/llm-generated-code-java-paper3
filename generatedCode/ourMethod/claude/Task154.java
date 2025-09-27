package ourMethod.claude;

import java.util.*;

public class Task154 {
    private int vertices;
    private List<List<Integer>> adjacencyList;
    
    public Task154(int v) {
        this.vertices = v;
        adjacencyList = new ArrayList<>(vertices);
        for(int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    
    public void addEdge(int v, int w) {
        if(v >= 0 && v < vertices && w >= 0 && w < vertices) {
            adjacencyList.get(v).add(w);
        }
    }
    
    public List<Integer> dfs(int startVertex) {
        if(startVertex < 0 || startVertex >= vertices) {
            return new ArrayList<>();
        }
        
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<>();
        dfsUtil(startVertex, visited, result);
        return result;
    }
    
    private void dfsUtil(int vertex, boolean[] visited, List<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);
        
        for(Integer adjacent : adjacencyList.get(vertex)) {
            if(!visited[adjacent]) {
                dfsUtil(adjacent, visited, result);
            }
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Simple graph
        Task154 g1 = new Task154(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(3, 3);
        System.out.println("DFS from vertex 2: " + g1.dfs(2));
        
        // Test case 2: Single node
        Task154 g2 = new Task154(1);
        System.out.println("DFS from vertex 0: " + g2.dfs(0));
        
        // Test case 3: Disconnected graph
        Task154 g3 = new Task154(4);
        g3.addEdge(0, 1);
        g3.addEdge(2, 3);
        System.out.println("DFS from vertex 0: " + g3.dfs(0));
        
        // Test case 4: Linear graph
        Task154 g4 = new Task154(4);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 3);
        System.out.println("DFS from vertex 0: " + g4.dfs(0));
        
        // Test case 5: Invalid input
        Task154 g5 = new Task154(4);
        g5.addEdge(0, 1);
        System.out.println("DFS from invalid vertex: " + g5.dfs(-1));
    }
}
