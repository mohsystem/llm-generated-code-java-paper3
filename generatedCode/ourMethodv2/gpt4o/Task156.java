package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;

class Task156 {
    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private static void preorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            preorderHelper(node.left, result);
            preorderHelper(node.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> preorderResult = preorderTraversal(root);
        System.out.println(preorderResult);
    }
}