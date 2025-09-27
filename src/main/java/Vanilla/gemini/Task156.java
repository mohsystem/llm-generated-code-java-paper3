package Vanilla.gemini;
import java.util.ArrayList;
import java.util.List;

class Node4 {
    int data;
    Node4 left;
    Node4 right;

    Node4(int data) {
        this.data = data;
    }
}

class Task156 {

    public List<Integer> preorderTraversal(Node4 root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node4 node, List<Integer> result) {
        if (node != null) {
            result.add(node.data);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }


    public List<Integer> inorderTraversal(Node4 root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(Node4 node, List<Integer> result) {
        if (node != null) {
            inorder(node.left, result);
            result.add(node.data);
            inorder(node.right, result);
        }
    }

    public List<Integer> postorderTraversal(Node4 root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node4 node, List<Integer> result) {
        if (node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.data);
        }
    }


    public static void main(String[] args) {
        Task156 task156 = new Task156();

        // Test case 1
        Node4 root1 = new Node4(1);
        root1.right = new Node4(2);
        root1.right.left = new Node4(3);
        System.out.println(task156.preorderTraversal(root1)); // Output: [1, 2, 3]

        // Test case 2
        Node4 root2 = null;
        System.out.println(task156.inorderTraversal(root2)); // Output: []

        // Test case 3
        Node4 root3 = new Node4(1);
        System.out.println(task156.postorderTraversal(root3)); // Output: [1]

        // Test case 4
        Node4 root4 = new Node4(1);
        root4.left = new Node4(2);
        root4.right = new Node4(3);
        System.out.println(task156.preorderTraversal(root4)); // Output: [1, 2, 3]


        // Test case 5
        Node4 root5 = new Node4(1);
        root5.left = new Node4(2);
        root5.right = new Node4(3);
        root5.left.left = new Node4(4);
        root5.left.right = new Node4(5);

        System.out.println(task156.inorderTraversal(root5)); // Output: [4, 2, 5, 1, 3]

    }
}