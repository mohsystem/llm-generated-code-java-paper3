package ourMethod.codestral;
import java.util.*;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    int vertices;
    LinkedList<Edge>[] adjacencylist;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source].addFirst(edge);
        edge = new Edge(destination, source, weight);
        adjacencylist[destination].addFirst(edge);
    }

    public void dijkstra_GetMinimumDistance(int sourceVertex) {
        int INFINITY = Integer.MAX_VALUE;
        boolean[] SPT = new boolean[vertices];
        int[] distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = INFINITY;
        }
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(vertices, new Comparator<Edge>() {
            @Override
            public int compare(Edge edge1, Edge edge2) {
                return edge1.weight - edge2.weight;
            }
        });
        distance[sourceVertex] = 0;
        priorityQueue.add(new Edge(sourceVertex, sourceVertex, 0));
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int u = edge.destination;
            if (SPT[u]) continue;
            SPT[u] = true;
            LinkedList<Edge> list = adjacencylist[u];
            for (int i = 0; i < list.size(); i++) {
                Edge edge2 = list.get(i);
                int v = edge2.destination;
                int weight = edge2.weight;
                if (!SPT[v] && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    priorityQueue.add(new Edge(u, v, distance[v]));
                }
            }
        }
        print(distance, sourceVertex);
    }

    public void print(int[] distance, int sourceVertex) {
        System.out.println("Dijkstra Algorithm: (Adjacency List)");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Source Vertex: " + sourceVertex + " to vertex " + i + " distance: " + distance[i]);
        }
    }
}

public class Task162 {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra_GetMinimumDistance(0);
    }
}