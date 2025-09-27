package ourMethod.llama31;
public class Task156 {
    // Node class for binary tree
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Method for preorder traversal
    public static void preorderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    // Method for inorder traversal
    public static void inorderTraversal(Node node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    // Method for postorder traversal
    public static void postorderTraversal(Node node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        // Creating a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Preorder Traversal: ");
        preorderTraversal(root);
        System.out.println();

        System.out.println("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println();

        System.out.println("Postorder Traversal: ");
        postorderTraversal(root);
        System.out.println();
    }
}