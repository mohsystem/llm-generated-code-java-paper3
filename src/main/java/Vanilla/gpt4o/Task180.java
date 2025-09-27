package Vanilla.gpt4o;
import java.util.*;

public class Task180 {
    static class TreeNode {
        int val;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode reorientTree(TreeNode root, int target) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);
        TreeNode newRoot = findNode(root, target);
        reorient(newRoot, null, parentMap);
        return newRoot;
    }

    private static void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        parentMap.put(node, parent);
        for (TreeNode child : node.children) {
            buildParentMap(child, node, parentMap);
        }
    }

    private static TreeNode findNode(TreeNode node, int target) {
        if (node == null || node.val == target) return node;
        for (TreeNode child : node.children) {
            TreeNode result = findNode(child, target);
            if (result != null) return result;
        }
        return null;
    }

    private static void reorient(TreeNode node, TreeNode newParent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        TreeNode originalParent = parentMap.get(node);
        if (originalParent != null) {
            node.children.add(originalParent);
            originalParent.children.remove(node);
            reorient(originalParent, node, parentMap);
        }
        if (newParent != null) {
            node.children.remove(newParent);
        }
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

        TreeNode newRoot = reorientTree(root, 6);
        System.out.println("New root value: " + newRoot.val);

        newRoot = reorientTree(root, 3);
        System.out.println("New root value: " + newRoot.val);

        newRoot = reorientTree(root, 9);
        System.out.println("New root value: " + newRoot.val);

        newRoot = reorientTree(root, 0);
        System.out.println("New root value: " + newRoot.val);

        newRoot = reorientTree(root, 7);
        System.out.println("New root value: " + newRoot.val);
    }
}