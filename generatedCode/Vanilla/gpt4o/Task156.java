package Vanilla.openai;
import java.util.*;

class Task156 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorderHelper(node.left, result);
            preorderHelper(node.right, result);
        }
    }

    public static void main(String[] args) {
        Task156 task = new Task156();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = task.preorderTraversal(root);
        System.out.println(result); // Output: [1, 2, 3]

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(7);
        root2.left.right = new TreeNode(8);

        result = task.preorderTraversal(root2);
        System.out.println(result); // Output: [4, 5, 7, 8, 6]
    }
}