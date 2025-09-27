package ZeroShot.claude;

import java.util.*;

class Task162 {
    static class Edge {
        int destination, weight;
        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.destination;

            if (current.weight > distances[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.offer(new Edge(v, distances[v]));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        // Test Case 1: Simple graph with 4 nodes
        List<List<Edge>> graph1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) graph1.add(new ArrayList<>());
        graph1.get(0).add(new Edge(1, 1));
        graph1.get(0).add(new Edge(2, 4));
        graph1.get(1).add(new Edge(2, 2));
        graph1.get(1).add(new Edge(3, 5));
        graph1.get(2).add(new Edge(3, 1));
        System.out.println("Test 1: " + Arrays.toString(dijkstra(graph1, 0)));

        // Test Case 2: Linear graph
        List<List<Edge>> graph2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) graph2.add(new ArrayList<>());
        graph2.get(0).add(new Edge(1, 1));
        graph2.get(1).add(new Edge(2, 2));
        System.out.println("Test 2: " + Arrays.toString(dijkstra(graph2, 0)));

        // Test Case 3: Cyclic graph
        List<List<Edge>> graph3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) graph3.add(new ArrayList<>());
        graph3.get(0).add(new Edge(1, 1));
        graph3.get(1).add(new Edge(2, 2));
        graph3.get(2).add(new Edge(0, 3));
        System.out.println("Test 3: " + Arrays.toString(dijkstra(graph3, 0)));

        // Test Case 4: Disconnected graph
        List<List<Edge>> graph4 = new ArrayList<>();
        for (int i = 0; i < 4; i++) graph4.add(new ArrayList<>());
        graph4.get(0).add(new Edge(1, 1));
        graph4.get(2).add(new Edge(3, 1));
        System.out.println("Test 4: " + Arrays.toString(dijkstra(graph4, 0)));

        // Test Case 5: Single node
        List<List<Edge>> graph5 = new ArrayList<>();
        graph5.add(new ArrayList<>());
        System.out.println("Test 5: " + Arrays.toString(dijkstra(graph5, 0)));
    }
}
