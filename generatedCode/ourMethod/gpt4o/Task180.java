package ourMethod.gpt4o;
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

    public static TreeNode reparentTree(TreeNode root, int newRootVal) {
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        TreeNode newRoot = parentMap.get(newRootVal);
        reparent(newRoot, null, parentMap);
        return newRoot;
    }

    private static void buildParentMap(TreeNode node, TreeNode parent, Map<Integer, TreeNode> parentMap) {
        if (node != null) {
            parentMap.put(node.val, parent);
            for (TreeNode child : node.children) {
                buildParentMap(child, node, parentMap);
            }
        }
    }

    private static void reparent(TreeNode node, TreeNode parent, Map<Integer, TreeNode> parentMap) {
        if (node != null) {
            List<TreeNode> newChildren = new ArrayList<>(node.children);
            if (parent != null) {
                newChildren.add(parent);
            }
            TreeNode originalParent = parentMap.get(node.val);
            if (originalParent != null) {
                originalParent.children.remove(node);
            }
            node.children = newChildren;

            for (TreeNode child : new ArrayList<>(node.children)) {
                if (child != parent) {
                    reparent(child, node, parentMap);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
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

        TreeNode newRoot = reparentTree(root, 6);
        System.out.println(newRoot.val); // Output: 6

        TreeNode newRoot2 = reparentTree(root, 3);
        System.out.println(newRoot2.val); // Output: 3

        TreeNode newRoot3 = reparentTree(root, 0);
        System.out.println(newRoot3.val); // Output: 0

        TreeNode newRoot4 = reparentTree(root, 7);
        System.out.println(newRoot4.val); // Output: 7

        TreeNode newRoot5 = reparentTree(root, 9);
        System.out.println(newRoot5.val); // Output: 9
    }
}