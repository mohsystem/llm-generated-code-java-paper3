package CoT.claude;

public class Task154 {
    private int V;
    private java.util.List<Integer>[] adjList;
    
    @SuppressWarnings("unchecked")
    public Task154(int v) {
        this.V = v;
        adjList = new java.util.LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new java.util.LinkedList<>();
        }
    }
    
    public void addEdge(int v, int w) {
        if(v >= 0 && v < V && w >= 0 && w < V) {
            adjList[v].add(w);
        }
    }
    
    public java.util.List<Integer> dfs(int start) {
        if(start < 0 || start >= V) {
            return new java.util.ArrayList<>();
        }
        
        boolean[] visited = new boolean[V];
        java.util.List<Integer> result = new java.util.ArrayList<>();
        dfsUtil(start, visited, result);
        return result;
    }
    
    private void dfsUtil(int v, boolean[] visited, java.util.List<Integer> result) {
        visited[v] = true;
        result.add(v);
        
        for(int n : adjList[v]) {
            if(!visited[n]) {
                dfsUtil(n, visited, result);
            }
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1: Simple path graph
        Task154 g1 = new Task154(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        System.out.println("Test 1: " + g1.dfs(0));  // Expected: [0, 1, 2, 3]
        
        // Test Case 2: Cyclic graph
        Task154 g2 = new Task154(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(3, 0);
        System.out.println("Test 2: " + g2.dfs(0));  // Expected: [0, 1, 2, 3]
        
        // Test Case 3: Disconnected graph
        Task154 g3 = new Task154(4);
        g3.addEdge(0, 1);
        g3.addEdge(2, 3);
        System.out.println("Test 3: " + g3.dfs(0));  // Expected: [0, 1]
        
        // Test Case 4: Single node
        Task154 g4 = new Task154(1);
        System.out.println("Test 4: " + g4.dfs(0));  // Expected: [0]
        
        // Test Case 5: Invalid start node
        Task154 g5 = new Task154(4);
        g5.addEdge(0, 1);
        g5.addEdge(1, 2);
        System.out.println("Test 5: " + g5.dfs(5));  // Expected: []
    }
}
