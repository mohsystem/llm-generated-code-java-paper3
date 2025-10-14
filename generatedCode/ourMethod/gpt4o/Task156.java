package ourMethod.openai;
class Task156 {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    // Preorder traversal
    public static void preorderTraversal(TreeNode node, StringBuilder result) {
        if (node == null) return;
        result.append(node.value).append(" ");
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }

    // Inorder traversal
    public static void inorderTraversal(TreeNode node, StringBuilder result) {
        if (node == null) return;
        inorderTraversal(node.left, result);
        result.append(node.value).append(" ");
        inorderTraversal(node.right, result);
    }

    // Postorder traversal
    public static void postorderTraversal(TreeNode node, StringBuilder result) {
        if (node == null) return;
        postorderTraversal(node.left, result);
        postorderTraversal(node.right, result);
        result.append(node.value).append(" ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        StringBuilder result = new StringBuilder();

        // Test 1: Preorder
        preorderTraversal(root, result);
        System.out.println("Preorder: " + result.toString().trim());
        result.setLength(0);

        // Test 2: Inorder
        inorderTraversal(root, result);
        System.out.println("Inorder: " + result.toString().trim());
        result.setLength(0);

        // Test 3: Postorder
        postorderTraversal(root, result);
        System.out.println("Postorder: " + result.toString().trim());
        result.setLength(0);

        // Additional Tests
        TreeNode newRoot = new TreeNode(6);
        newRoot.left = new TreeNode(7);
        newRoot.right = new TreeNode(8);

        // Test 4: Preorder on new tree
        preorderTraversal(newRoot, result);
        System.out.println("Preorder New Tree: " + result.toString().trim());
        result.setLength(0);

        // Test 5: Inorder on new tree
        inorderTraversal(newRoot, result);
        System.out.println("Inorder New Tree: " + result.toString().trim());
    }
}