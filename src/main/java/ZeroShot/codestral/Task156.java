package ZeroShot.codestral;
// Task156
import java.util.ArrayList;
import java.util.List;

class Node2 {
    int data;
    Node2 left, right;

    Node2(int item) {
        data = item;
        left = right = null;
    }
}

class Task156 {
    Node2 root;

    void printPreorder(Node2 node, List<Integer> list) {
        if (node == null)
            return;

        list.add(node.data);
        printPreorder(node.left, list);
        printPreorder(node.right, list);
    }

    void printInorder(Node2 node, List<Integer> list) {
        if (node == null)
            return;

        printInorder(node.left, list);
        list.add(node.data);
        printInorder(node.right, list);
    }

    void printPostorder(Node2 node, List<Integer> list) {
        if (node == null)
            return;

        printPostorder(node.left, list);
        printPostorder(node.right, list);
        list.add(node.data);
    }

    public static void main(String args[]) {
        Task156 tree = new Task156();
        tree.root = new Node2(1);
        tree.root.left = new Node2(2);
        tree.root.right = new Node2(3);
        tree.root.left.left = new Node2(4);
        tree.root.left.right = new Node2(5);

        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();

        tree.printPreorder(tree.root, preorderList);
        tree.printInorder(tree.root, inorderList);
        tree.printPostorder(tree.root, postorderList);

        System.out.println("Preorder traversal of binary tree is: " + preorderList);
        System.out.println("Inorder traversal of binary tree is: " + inorderList);
        System.out.println("Postorder traversal of binary tree is: " + postorderList);
    }
}