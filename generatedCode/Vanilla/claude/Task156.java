package Vanilla.claude;

class Task156 {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Test Case 1: Single node
        Node root1 = new Node(1);
        System.out.println("Test Case 1:");
        System.out.print("Preorder: "); preorder(root1);
        System.out.print("\\nInorder: "); inorder(root1);
        System.out.print("\\nPostorder: "); postorder(root1);
        System.out.println("\\n");

        // Test Case 2: Complete binary tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        System.out.println("Test Case 2:");
        System.out.print("Preorder: "); preorder(root2);
        System.out.print("\\nInorder: "); inorder(root2);
        System.out.print("\\nPostorder: "); postorder(root2);
        System.out.println("\\n");

        // Test Case 3: Left skewed tree
        Node root3 = new Node(1);
        root3.left = new Node(2);
        root3.left.left = new Node(3);
        System.out.println("Test Case 3:");
        System.out.print("Preorder: "); preorder(root3);
        System.out.print("\\nInorder: "); inorder(root3);
        System.out.print("\\nPostorder: "); postorder(root3);
        System.out.println("\\n");

        // Test Case 4: Right skewed tree
        Node root4 = new Node(1);
        root4.right = new Node(2);
        root4.right.right = new Node(3);
        System.out.println("Test Case 4:");
        System.out.print("Preorder: "); preorder(root4);
        System.out.print("\\nInorder: "); inorder(root4);
        System.out.print("\\nPostorder: "); postorder(root4);
        System.out.println("\\n");

        // Test Case 5: Complex tree
        Node root5 = new Node(1);
        root5.left = new Node(2);
        root5.right = new Node(3);
        root5.left.left = new Node(4);
        root5.left.right = new Node(5);
        System.out.println("Test Case 5:");
        System.out.print("Preorder: "); preorder(root5);
        System.out.print("\\nInorder: "); inorder(root5);
        System.out.print("\\nPostorder: "); postorder(root5);
        System.out.println();
    }
}
