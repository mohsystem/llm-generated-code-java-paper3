package ourMethod.gemini;
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
        Task156 task = new Task156();

        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println("Preorder: " + task.preorderTraversal(root1));
        System.out.println("Inorder: " + task.inorderTraversal(root1));
        System.out.println("Postorder: " + task.postorderTraversal(root1));


        // Test case 2
        TreeNode root2 = null;
        System.out.println("Preorder: " + task.preorderTraversal(root2));
        System.out.println("Inorder: " + task.inorderTraversal(root2));
        System.out.println("Postorder: " + task.postorderTraversal(root2));

        // Test case 3
        TreeNode root3 = new TreeNode(1);
        System.out.println("Preorder: " + task.preorderTraversal(root3));
        System.out.println("Inorder: " + task.inorderTraversal(root3));
        System.out.println("Postorder: " + task.postorderTraversal(root3));

        // Test case 4
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        System.out.println("Preorder: " + task.preorderTraversal(root4));
        System.out.println("Inorder: " + task.inorderTraversal(root4));
        System.out.println("Postorder: " + task.postorderTraversal(root4));

        // Test case 5
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        System.out.println("Preorder: " + task.preorderTraversal(root5));
        System.out.println("Inorder: " + task.inorderTraversal(root5));
        System.out.println("Postorder: " + task.postorderTraversal(root5));
    }
}