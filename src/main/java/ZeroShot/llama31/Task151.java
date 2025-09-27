package ZeroShot.llama31;
public class Task151 {
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static boolean search(Node root, int key) {
        if (root == null) return false;
        if (key == root.key) return true;
        if (key < root.key) return search(root.left, key);
        return search(root.right, key);
    }

    public static Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static Node delete(Node root, int key) {
        if (root == null) return root;
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            Node temp = minValueNode(root.right);
            root.key = temp.key;
            root.right = delete(root.right, temp.key);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("Inorder traversal of the given tree is");
        inOrder(root);

        System.out.println("\nDelete 20");
        root = delete(root, 20);
        System.out.println("Inorder traversal of the modified tree is");
        inOrder(root);

        System.out.println("\nSearch for 40: " + search(root, 40));
        System.out.println("Search for 90: " + search(root, 90));
    }
}