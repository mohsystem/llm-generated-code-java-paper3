package ZeroShot.claude;

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
    
    public static Node reparentTree(Node root, int newRootValue) {
        // Build adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, -1, graph);
        
        // Create new tree with BFS
        Map<Integer, Node> nodes = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        // Create new root
        Node newRoot = new Node(newRootValue);
        nodes.put(newRootValue, newRoot);
        queue.offer(newRootValue);
        visited.add(newRootValue);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            Node currentNode = nodes.get(current);
            
            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    Node newNode = new Node(neighbor);
                    currentNode.children.add(newNode);
                    nodes.put(neighbor, newNode);
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return newRoot;
    }
    
    private static void buildGraph(Node node, int parent, Map<Integer, List<Integer>> graph) {
        if (!graph.containsKey(node.value)) {
            graph.put(node.value, new ArrayList<>());
        }
        
        if (parent != -1) {
            graph.get(node.value).add(parent);
            graph.get(parent).add(node.value);
        }
        
        for (Node child : node.children) {
            buildGraph(child, node.value, graph);
        }
    }
    
    private static void printTree(Node node, String prefix, boolean isLast) {
        System.out.print(prefix);
        System.out.print(isLast ? "└── " : "├── ");
        System.out.println(node.value);
        
        for (int i = 0; i < node.children.size(); i++) {
            printTree(node.children.get(i),
                     prefix + (isLast ? "    " : "│   "),
                     i == node.children.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Simple tree
        Node root1 = new Node(0);
        root1.children.add(new Node(1));
        root1.children.add(new Node(2));
        Node newRoot1 = reparentTree(root1, 2);
        System.out.println("Test case 1:");
        printTree(newRoot1, "", true);
        
        // Test case 2: Larger tree
        Node root2 = new Node(0);
        root2.children.add(new Node(1));
        root2.children.add(new Node(2));
        root2.children.add(new Node(3));
        root2.children.get(0).children.add(new Node(4));
        root2.children.get(0).children.add(new Node(5));
        Node newRoot2 = reparentTree(root2, 4);
        System.out.println("\\nTest case 2:");
        printTree(newRoot2, "", true);
        
        // Add more test cases similarly
    }
}
