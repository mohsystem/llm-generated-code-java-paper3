package ourMethod.llama31;
public class Task151 {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static Node root;

    public static void main(String[] args) {
        // Test cases
        insert(10);
        insert(5);
        insert(20);
        insert(4);
        insert(8);
        insert(15);
        insert(25);

        System.out.println("Search Value 10: " + search(root, 10));
        System.out.println("Search Value 2: " + search(root, 2));
        System.out.println("Delete Value 10: " + delete(root, 10));
        System.out.println("Search Value 10 after deletion: " + search(root, 10));
    }

    public static void insert(int key) {
        root = insertKey(root, key);
    }

    public static Node insertKey(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertKey(root.left, key);
        else if (key > root.key)
            root.right = insertKey(root.right, key);
        return root;
    }

    public static boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (key == root.key)
            return true;
        if (key < root.key)
            return search(root.left, key);
        return search(root.right, key);
    }

    public static Node delete(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            Node temp = minValueNode(root.right);
            root.key = temp.key;
            root.right = delete(root.right, temp.key);
        }
        return root;
    }

    public static Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }
}