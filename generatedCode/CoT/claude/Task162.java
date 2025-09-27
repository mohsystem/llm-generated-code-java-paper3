package CoT.claude;

public class Task162 {
    static final int V = 5;
    static final int INF = Integer.MAX_VALUE;

    private static int minDistance(int[] dist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            visited[i] = false;
            parent[i] = -1;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && 
                    dist[u] != INF && 
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printSolution(dist, parent, src);
    }

    private static void printSolution(int[] dist, int[] parent, int src) {
        System.out.println("Vertex \\t\\t Distance \\tPath");
        for (int i = 0; i < V; i++) {
            if (i != src) {
                System.out.print(i + " \\t\\t " + dist[i] + "\\t\\t");
                printPath(parent, i);
                System.out.println();
            }
        }
    }

    private static void printPath(int[] parent, int j) {
        if (parent[j] == -1)
            return;
        printPath(parent, parent[j]);
        System.out.print(j + " ");
    }

    public static void main(String[] args) {
        int[][] graph1 = {
            {0, 4, 0, 0, 0},
            {4, 0, 8, 0, 0},
            {0, 8, 0, 7, 0},
            {0, 0, 7, 0, 9},
            {0, 0, 0, 9, 0}
        };
        System.out.println("Test Case 1:");
        dijkstra(graph1, 0);

        int[][] graph2 = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        System.out.println("\\nTest Case 2:");
        dijkstra(graph2, 0);

        int[][] graph3 = {
            {0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0}
        };
        System.out.println("\\nTest Case 3:");
        dijkstra(graph3, 0);

        int[][] graph4 = {
            {0, 5, 0, 10, 0},
            {5, 0, 3, 0, 2},
            {0, 3, 0, 1, 0},
            {10, 0, 1, 0, 4},
            {0, 2, 0, 4, 0}
        };
        System.out.println("\\nTest Case 4:");
        dijkstra(graph4, 0);

        int[][] graph5 = {
            {0, 3, 0, 7, 0},
            {3, 0, 4, 2, 0},
            {0, 4, 0, 0, 6},
            {7, 2, 0, 0, 5},
            {0, 0, 6, 5, 0}
        };
        System.out.println("\\nTest Case 5:");
        dijkstra(graph5, 0);
    }
}
