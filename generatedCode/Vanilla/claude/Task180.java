package Vanilla.claude;

import java.util.*;

class Task180 {
    static class Node {
        int value;
        List<Node> children;
        
        Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
    
    public static Node reparentTree(Node root, int newRoot) {
        // Create adjacency list representation
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, -1, graph);
        
        // Create new tree with newRoot as root
        Node newTree = new Node(newRoot);
        Set<Integer> visited = new HashSet<>();
        visited.add(newRoot);
        buildNewTree(newTree, newRoot, graph, visited);
        
        return newTree;
    }
    
    private static void buildGraph(Node node, int parent, Map<Integer, List<Integer>> graph) {
        if (!graph.containsKey(node.value)) {
            graph.put(node.value, new ArrayList<>());
        }
        
        if (parent != -1) {
            graph.get(node.value).add(parent);
        }
        
        for (Node child : node.children) {
            graph.get(node.value).add(child.value);
            buildGraph(child, node.value, graph);
        }
    }
    
    private static void buildNewTree(Node current, int value, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        for (int neighbor : graph.get(value)) {
            if (!visited.contains(neighbor)) {
                Node child = new Node(neighbor);
                current.children.add(child);
                visited.add(neighbor);
                buildNewTree(child, neighbor, graph, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Simple tree
        Node root1 = new Node(0);
        root1.children.add(new Node(1));
        root1.children.add(new Node(2));
        Node result1 = reparentTree(root1, 2);
        
        // Test case 2: Tree from problem description
        Node root2 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        root2.children.addAll(Arrays.asList(n1, n2, n3));
        n1.children.addAll(Arrays.asList(new Node(4), new Node(5)));
        n2.children.addAll(Arrays.asList(new Node(6), new Node(7)));
        n3.children.addAll(Arrays.asList(new Node(8), new Node(9)));
        Node result2 = reparentTree(root2, 6);
        
        // Test case 3: Linear tree
        Node root3 = new Node(0);
        Node c1 = new Node(1);
        Node c2 = new Node(2);
        root3.children.add(c1);
        c1.children.add(c2);
        Node result3 = reparentTree(root3, 2);
        
        // Test case 4: Star tree
        Node root4 = new Node(0);
        root4.children.addAll(Arrays.asList(new Node(1), new Node(2), new Node(3), new Node(4)));
        Node result4 = reparentTree(root4, 3);
        
        // Test case 5: Single node
        Node root5 = new Node(0);
        Node result5 = reparentTree(root5, 0);
    }
}
