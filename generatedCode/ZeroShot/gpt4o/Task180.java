package ZeroShot.openai;
import java.util.*;

class Task180 {
    static class TreeNode {
        int val;
        List<TreeNode> children;
        
        TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }
    
    static Map<Integer, TreeNode> nodeMap;
    
    public static TreeNode reparentTree(TreeNode root, int newRootVal) {
        nodeMap = new HashMap<>();
        buildNodeMap(root, null);
        TreeNode newRoot = nodeMap.get(newRootVal);
        reorientTree(null, newRoot);
        return newRoot;
    }
    
    private static void buildNodeMap(TreeNode node, TreeNode parent) {
        nodeMap.put(node.val, node);
        for (TreeNode child : node.children) {
            if (child != parent) {
                buildNodeMap(child, node);
            }
        }
    }
    
    private static void reorientTree(TreeNode parent, TreeNode node) {
        if (parent != null) {
            node.children.remove(parent);
            node.children.add(parent);
        }
        for (TreeNode child : new ArrayList<>(node.children)) {
            reorientTree(node, child);
        }
    }
    
    public static void main(String[] args) {
        // Test case 1
        TreeNode root1 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root1.children.add(node1);
        root1.children.add(node2);
        root1.children.add(node3);
        node1.children.add(new TreeNode(4));
        node1.children.add(new TreeNode(5));
        node2.children.add(new TreeNode(6));
        node2.children.add(new TreeNode(7));
        node3.children.add(new TreeNode(8));
        node3.children.add(new TreeNode(9));
        TreeNode newRoot1 = reparentTree(root1, 6);
        
        // Test case 2
        TreeNode root2 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3);
        root2.children.add(node4);
        root2.children.add(node5);
        root2.children.add(node6);
        node4.children.add(new TreeNode(4));
        node5.children.add(new TreeNode(5));
        node6.children.add(new TreeNode(6));
        TreeNode newRoot2 = reparentTree(root2, 5);
        
        // Test case 3
        TreeNode root3 = new TreeNode(0);
        TreeNode node7 = new TreeNode(1);
        root3.children.add(node7);
        node7.children.add(new TreeNode(2));
        node7.children.add(new TreeNode(3));
        TreeNode newRoot3 = reparentTree(root3, 3);
        
        // Test case 4
        TreeNode root4 = new TreeNode(0);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(2);
        root4.children.add(node8);
        node8.children.add(node9);
        node9.children.add(new TreeNode(3));
        TreeNode newRoot4 = reparentTree(root4, 2);
        
        // Test case 5
        TreeNode root5 = new TreeNode(0);
        TreeNode node10 = new TreeNode(1);
        root5.children.add(node10);
        node10.children.add(new TreeNode(2));
        TreeNode newRoot5 = reparentTree(root5, 1);
    }
}