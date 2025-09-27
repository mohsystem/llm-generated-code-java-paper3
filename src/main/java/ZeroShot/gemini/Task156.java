package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Task156 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorder(node.left, result);
            result.add(node.val);
            inorder(node.right, result);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.val);
        }
    }

    public static void main(String[] args) {
        Task156 task156 = new Task156();

        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println(task156.preorderTraversal(root1)); // [1, 2, 3]

        // Test case 2
        TreeNode root2 = null;
        System.out.println(task156.inorderTraversal(root2)); // []

        // Test case 3
        TreeNode root3 = new TreeNode(1);
        System.out.println(task156.postorderTraversal(root3)); // [1]

        // Test case 4
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        System.out.println(task156.preorderTraversal(root4)); // [1, 2, 3]

         // Test case 5
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.left.right = new TreeNode(5);
         System.out.println(task156.inorderTraversal(root5)); // [4, 2, 5, 1, 3]

    }
}