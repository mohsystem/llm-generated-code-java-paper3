package CoT.gemini;
import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Task156 {

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
        System.out.println("Preorder Traversal: " + task156.preorderTraversal(root1));
        System.out.println("Inorder Traversal: " + task156.inorderTraversal(root1));
        System.out.println("Postorder Traversal: " + task156.postorderTraversal(root1));


        // Test case 2
        Node root2 = null;
        System.out.println("Preorder Traversal: " + task156.preorderTraversal(root2));

        // Test case 3
        Node root3 = new Node(1);
        System.out.println("Preorder Traversal: " + task156.preorderTraversal(root3));

        // Test case 4
        Node root4 = new Node(1);
        root4.left = new Node(2);
        System.out.println("Inorder Traversal: " + task156.inorderTraversal(root4));

        //Test case 5
        Node root5 = new Node(1);
        root5.right = new Node(2);
        System.out.println("Postorder Traversal: " + task156.postorderTraversal(root5));
    }
}