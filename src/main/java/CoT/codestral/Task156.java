package CoT.codestral;
class Node2 {
    int data;
    Node2 left, right;

    public Node2(int item) {
        data = item;
        left = right = null;
    }
}

class Task156 {
    Node2 root;

    void printPreorder(Node2 node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printInorder(Node2 node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    void printPostorder(Node2 node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Task156 tree = new Task156();
        tree.root = new Node2(1);
        tree.root.left = new Node2(2);
        tree.root.right = new Node2(3);
        tree.root.left.left = new Node2(4);
        tree.root.left.right = new Node2(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
    }
}