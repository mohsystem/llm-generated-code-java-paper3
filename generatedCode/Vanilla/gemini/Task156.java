package Vanilla.gemini;
import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class Task156 {

    public List<Integer> preorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.data);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }


    public List<Integer> inorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(Node node, List<Integer> result) {
        if (node != null) {
            inorder(node.left, result);
            result.add(node.data);
            inorder(node.right, result);
        }
    }

    public List<Integer> postorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node node, List<Integer> result) {
        if (node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.data);
        }
    }


    public static void main(String[] args) {
        Task156 task156 = new Task156();

        // Test case 1
        Node root1 = new Node(1);
        root1.right = new Node(2);
        root1.right.left = new Node(3);
        System.out.println(task156.preorderTraversal(root1)); // Output: [1, 2, 3]

        // Test case 2
        Node root2 = null;
        System.out.println(task156.inorderTraversal(root2)); // Output: []

        // Test case 3
        Node root3 = new Node(1);
        System.out.println(task156.postorderTraversal(root3)); // Output: [1]

        // Test case 4
        Node root4 = new Node(1);
        root4.left = new Node(2);
        root4.right = new Node(3);
        System.out.println(task156.preorderTraversal(root4)); // Output: [1, 2, 3]


        // Test case 5
        Node root5 = new Node(1);
        root5.left = new Node(2);
        root5.right = new Node(3);
        root5.left.left = new Node(4);
        root5.left.right = new Node(5);

        System.out.println(task156.inorderTraversal(root5)); // Output: [4, 2, 5, 1, 3]

    }
}