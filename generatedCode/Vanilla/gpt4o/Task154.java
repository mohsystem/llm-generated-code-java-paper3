package Vanilla.openai;
import java.util.*;

public class Task154 {

    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        List<Integer> DFSUtil(int v, boolean visited[]) {
            List<Integer> result = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(v);
            while (!stack.empty()) {
                v = stack.pop();
                if (!visited[v]) {
                    result.add(v);
                    visited[v] = true;
                }
                Iterator<Integer> itr = adj[v].iterator();
                while (itr.hasNext()) {
                    int n = itr.next();
                    if (!visited[n]) {
                        stack.push(n);
                    }
                }
            }
            return result;
        }

        List<Integer> DFS(int v) {
            boolean visited[] = new boolean[V];
            return DFSUtil(v, visited);
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        List<Integer> result1 = g.DFS(0);
        System.out.println(result1);

        List<Integer> result2 = g.DFS(1);
        System.out.println(result2);

        List<Integer> result3 = g.DFS(2);
        System.out.println(result3);

        List<Integer> result4 = g.DFS(3);
        System.out.println(result4);

        List<Integer> result5 = g.DFS(4);
        System.out.println(result5);
    }
}