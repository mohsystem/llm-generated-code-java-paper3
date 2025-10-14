package ourMethodv2.gpt4o;
import java.util.*;

public class Task180 {
    static class TreeNode {
        int val;
        List<TreeNode> children;

        TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static TreeNode reparent(TreeNode root, int newRootVal) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        TreeNode newRoot = findNode(root, newRootVal);
        if (newRoot == null) return null;

        TreeNode current = newRoot;
        TreeNode parent = parentMap.get(current);
        while (parent != null) {
            parent.children.remove(current);
            current.children.add(parent);

            TreeNode temp = parentMap.get(parent);
            parentMap.put(parent, current);
            current = parent;
            parent = temp;
        }

        return newRoot;
    }

    private static void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        parentMap.put(node, parent);
        for (TreeNode child : node.children) {
            buildParentMap(child, node, parentMap);
        }
    }

    private static TreeNode findNode(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val == val) return node;
        for (TreeNode child : node.children) {
            TreeNode found = findNode(child, val);
            if (found != null) return found;
        }
        return null;
    }

    public static void main(String[] args) {
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

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node1.children.add(node4);
        node1.children.add(node5);
        node2.children.add(node6);
        node2.children.add(node7);
        node3.children.add(node8);
        node3.children.add(node9);

        TreeNode newRoot = reparent(root, 6);
        printTree(newRoot, 0);
    }

    private static void printTree(TreeNode node, int level) {
        if (node == null) return;
        System.out.println("  ".repeat(level) + node.val);
        for (TreeNode child : node.children) {
            printTree(child, level + 1);
        }
    }
}