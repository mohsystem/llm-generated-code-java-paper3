package Vanilla.claude;

import java.util.*;

class Task162 {
    static class Edge {
        int dest, weight;
        Edge(int d, int w) {
            dest = d;
            weight = w;
        }
    }

    public static int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int start, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.dest;

            for (Edge e : graph.get(u)) {
                int v = e.dest;
                int weight = e.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // Test Case 1
        int V1 = 4;
        ArrayList<ArrayList<Edge>> graph1 = new ArrayList<>();
        for(int i = 0; i < V1; i++) graph1.add(new ArrayList<>());
        graph1.get(0).add(new Edge(1, 1));
        graph1.get(0).add(new Edge(2, 4));
        graph1.get(1).add(new Edge(2, 2));
        graph1.get(1).add(new Edge(3, 5));
        graph1.get(2).add(new Edge(3, 1));
        System.out.println(Arrays.toString(dijkstra(graph1, 0, V1)));

        // Test Case 2
        int V2 = 3;
        ArrayList<ArrayList<Edge>> graph2 = new ArrayList<>();
        for(int i = 0; i < V2; i++) graph2.add(new ArrayList<>());
        graph2.get(0).add(new Edge(1, 2));
        graph2.get(1).add(new Edge(2, 3));
        System.out.println(Arrays.toString(dijkstra(graph2, 0, V2)));

        // Test Case 3
        int V3 = 5;
        ArrayList<ArrayList<Edge>> graph3 = new ArrayList<>();
        for(int i = 0; i < V3; i++) graph3.add(new ArrayList<>());
        graph3.get(0).add(new Edge(1, 4));
        graph3.get(0).add(new Edge(2, 2));
        graph3.get(1).add(new Edge(3, 3));
        graph3.get(2).add(new Edge(1, 1));
        graph3.get(2).add(new Edge(3, 5));
        graph3.get(3).add(new Edge(4, 2));
        System.out.println(Arrays.toString(dijkstra(graph3, 0, V3)));

        // Test Case 4
        int V4 = 3;
        ArrayList<ArrayList<Edge>> graph4 = new ArrayList<>();
        for(int i = 0; i < V4; i++) graph4.add(new ArrayList<>());
        graph4.get(0).add(new Edge(1, 1));
        graph4.get(1).add(new Edge(2, 1));
        graph4.get(2).add(new Edge(0, 1));
        System.out.println(Arrays.toString(dijkstra(graph4, 0, V4)));

        // Test Case 5
        int V5 = 4;
        ArrayList<ArrayList<Edge>> graph5 = new ArrayList<>();
        for(int i = 0; i < V5; i++) graph5.add(new ArrayList<>());
        graph5.get(0).add(new Edge(1, 10));
        graph5.get(0).add(new Edge(2, 5));
        graph5.get(1).add(new Edge(2, 2));
        graph5.get(1).add(new Edge(3, 1));
        graph5.get(2).add(new Edge(1, 3));
        graph5.get(2).add(new Edge(3, 9));
        System.out.println(Arrays.toString(dijkstra(graph5, 0, V5)));
    }
}
