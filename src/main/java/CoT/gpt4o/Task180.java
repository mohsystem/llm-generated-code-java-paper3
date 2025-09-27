package CoT.gpt4o;
import java.util.*;

public class Task180 {
    static class TreeNode {
        int value;
        List<TreeNode> children;
        
        TreeNode(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    public static TreeNode reparent(TreeNode root, int newRootValue) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        buildNodeMap(root, null, nodeMap);
        TreeNode newRoot = nodeMap.get(newRootValue);
        rebuildTree(newRoot, null);
        return newRoot;
    }

    private static void buildNodeMap(TreeNode node, TreeNode parent, Map<Integer, TreeNode> nodeMap) {
        nodeMap.put(node.value, node);
        if (parent != null) {
            node.children.remove(parent);
        }
        for (TreeNode child : new ArrayList<>(node.children)) {
            buildNodeMap(child, node, nodeMap);
        }
    }

    private static void rebuildTree(TreeNode node, TreeNode parent) {
        if (parent != null) {
            node.children.add(parent);
        }
        for (TreeNode child : new ArrayList<>(node.children)) {
            rebuildTree(child, node);
        }
    }

    public static void main(String[] args) {
        // Construct tree
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        root.children.addAll(Arrays.asList(node1, node2, node3));
        node1.children.addAll(Arrays.asList(node4, node5));
        node2.children.addAll(Arrays.asList(node6, node7));
        node3.children.addAll(Arrays.asList(node8, node9));

        // Reparent and print
        TreeNode newRoot = reparent(root, 6);
        printTree(newRoot, "");
    }

    private static void printTree(TreeNode node, String indent) {
        System.out.println(indent + node.value);
        for (TreeNode child : node.children) {
            printTree(child, indent + "  ");
        }
    }
}