package ourMethod.claude;

import java.util.*;

public class Task180 {
    static class Node {
        int value;
        List<Node> children;
        
        Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
    
    public static Node reparent(Map<Integer, List<Integer>> tree, int root) {
        Map<Integer, Node> nodes = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        // Create nodes
        for (int key : tree.keySet()) {
            nodes.putIfAbsent(key, new Node(key));
            for (int child : tree.get(key)) {
                nodes.putIfAbsent(child, new Node(child));
            }
        }
        
        // Build new tree from root
        return buildTree(nodes, tree, root, visited);
    }
    
    private static Node buildTree(Map<Integer, Node> nodes, Map<Integer, List<Integer>> connections, 
                                int current, Set<Integer> visited) {
        visited.add(current);
        Node currentNode = nodes.get(current);
        
        List<Integer> neighbors = connections.get(current);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    currentNode.children.add(buildTree(nodes, connections, neighbor, visited));
                }
            }
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : connections.entrySet()) {
            if (entry.getValue().contains(current) && !visited.contains(entry.getKey())) {
                currentNode.children.add(buildTree(nodes, connections, entry.getKey(), visited));
            }
        }
        
        return currentNode;
    }

    public static void main(String[] args) {
        // Test cases
        Map<Integer, List<Integer>> tree1 = new HashMap<>();
        tree1.put(0, Arrays.asList(1, 2, 3));
        tree1.put(1, Arrays.asList(4, 5));
        tree1.put(2, Arrays.asList(6, 7));
        tree1.put(3, Arrays.asList(8, 9));
        
        // Test case 1: Reparent from node 6
        Node result1 = reparent(tree1, 6);
        System.out.println("Test 1: Reparented from node 6");
        
        // Test case 2: Reparent from node 0 (original root)
        Node result2 = reparent(tree1, 0);
        System.out.println("Test 2: Reparented from node 0");
        
        // Test case 3: Reparent from leaf node 9
        Node result3 = reparent(tree1, 9);
        System.out.println("Test 3: Reparented from node 9");
        
        // Test case 4: Reparent from middle node 2
        Node result4 = reparent(tree1, 2);
        System.out.println("Test 4: Reparented from node 2");
        
        // Test case 5: Reparent from leaf node 4
        Node result5 = reparent(tree1, 4);
        System.out.println("Test 5: Reparented from node 4");
    }
}
