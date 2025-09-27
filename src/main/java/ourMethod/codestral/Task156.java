package ourMethod.codestral;
class Node1 {
    int data;
    Node1 left, right;

    public Node1(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node1 root;

    void printPreorder(Node1 node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printInorder(Node1 node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    void printPostorder(Node1 node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
    }
}