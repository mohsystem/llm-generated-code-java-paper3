package Vanilla.codestral;
// Java code:

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Task156 {
    Node root;

    void printPreorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printInorder(Node node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    void printPostorder(Node node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Task156 tree = new Task156();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
    }
}