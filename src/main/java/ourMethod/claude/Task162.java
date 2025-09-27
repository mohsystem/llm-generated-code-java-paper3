package ourMethod.claude;

import java.util.*;

public class Task162 {
    static class Graph {
        private int vertices;
        private List<List<Node>> adjacencyList;

        static class Node {
            int vertex;
            int weight;

            Node(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }
        }

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int destination, int weight) {
            if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
                adjacencyList.get(source).add(new Node(destination, weight));
                adjacencyList.get(destination).add(new Node(source, weight)); // For undirected graph
            }
        }

        int[] dijkstra(int startNode) {
            if (startNode < 0 || startNode >= vertices) {
                return new int[0];
            }

            int[] distances = new int[vertices];
            boolean[] visited = new boolean[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startNode] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
            pq.offer(new Node(startNode, 0));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int u = current.vertex;

                if (visited[u]) continue;
                visited[u] = true;

                for (Node neighbor : adjacencyList.get(u)) {
                    int v = neighbor.vertex;
                    int weight = neighbor.weight;

                    if (!visited[v] && distances[u] != Integer.MAX_VALUE && 
                        distances[u] + weight < distances[v]) {
                        distances[v] = distances[u] + weight;
                        pq.offer(new Node(v, distances[v]));
                    }
                }
            }
            return distances;
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Simple graph with 4 vertices
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1, 1);
        g1.addEdge(1, 2, 2);
        g1.addEdge(2, 3, 3);
        System.out.println("Test 1: " + Arrays.toString(g1.dijkstra(0)));

        // Test Case 2: Graph with multiple paths
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1, 4);
        g2.addEdge(0, 2, 2);
        g2.addEdge(1, 2, 1);
        g2.addEdge(1, 3, 5);
        g2.addEdge(2, 3, 8);
        g2.addEdge(2, 4, 10);
        g2.addEdge(3, 4, 2);
        System.out.println("Test 2: " + Arrays.toString(g2.dijkstra(0)));

        // Test Case 3: Disconnected graph
        Graph g3 = new Graph(4);
        g3.addEdge(0, 1, 1);
        g3.addEdge(2, 3, 1);
        System.out.println("Test 3: " + Arrays.toString(g3.dijkstra(0)));

        // Test Case 4: Single vertex graph
        Graph g4 = new Graph(1);
        System.out.println("Test 4: " + Arrays.toString(g4.dijkstra(0)));

        // Test Case 5: Graph with negative index (error case)
        Graph g5 = new Graph(4);
        g5.addEdge(-1, 1, 1);
        System.out.println("Test 5: " + Arrays.toString(g5.dijkstra(-1)));
    }
}
