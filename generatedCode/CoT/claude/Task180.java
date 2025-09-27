package CoT.claude;

import java.util.*;

class Task180 {
    static class Node {
        int value;
        List<Node> children;
        Node parent;

        Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
            this.parent = null;
        }
    }

    public static Node reparentTree(Node root, int newRootValue) {
        // First, create a map of all nodes
        Map<Integer, Node> nodeMap = new HashMap<>();
        mapNodes(root, nodeMap);

        Node newRoot = nodeMap.get(newRootValue);
        if (newRoot == null) return root;

        // Build new relationships
        Set<Node> visited = new HashSet<>();
        reparent(newRoot, null, visited);

        return newRoot;
    }

    private static void mapNodes(Node node, Map<Integer, Node> nodeMap) {
        if (node == null) return;
        nodeMap.put(node.value, node);
        for (Node child : node.children) {
            mapNodes(child, nodeMap);
        }
    }

    private static void reparent(Node node, Node parent, Set<Node> visited) {
        if (visited.contains(node)) return;
        visited.add(node);

        List<Node> connections = new ArrayList<>(node.children);
        if (node.parent != null) {
            connections.add(node.parent);
        }

        node.children.clear();
        node.parent = parent;

        if (parent != null) {
            if (!parent.children.contains(node)) {
                parent.children.add(node);
            }
        }

        for (Node connection : connections) {
            if (connection != parent) {
                reparent(connection, node, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Test case 1: Simple tree
        Node root = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        root.children.add(n1);
        root.children.add(n2);
        n1.parent = root;
        n2.parent = root;
        Node newRoot = reparentTree(root, 1);
        System.out.println("New root value: " + newRoot.value);

        // Test case 2: Complex tree (the example from the problem)
        Node root2 = new Node(0);
        n1 = new Node(1);
        n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        root2.children.addAll(Arrays.asList(n1, n2, n3));
        n1.children.addAll(Arrays.asList(n4, n5));
        n2.children.addAll(Arrays.asList(n6, n7));
        n3.children.addAll(Arrays.asList(n8, n9));

        newRoot = reparentTree(root2, 6);
        System.out.println("New root value: " + newRoot.value);
    }
}
