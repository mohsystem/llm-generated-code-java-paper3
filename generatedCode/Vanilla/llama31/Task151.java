package Vanilla.llama31;
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
        Task151 tree = new Task151();
        tree.root = null;

        // Test cases
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        tree.insert(14);
        tree.insert(4);
        tree.insert(7);
        tree.insert(13);

        System.out.println("Search Value 10 is in tree? " + searchRecursively(tree.root, 10));
        System.out.println("Search Value 15 is in tree? " + searchRecursively(tree.root, 15));

        tree.inorder();
        System.out.println();
        tree.deleteRec(tree.root, 10);
        tree.inorder();
    }

    public static boolean searchRecursively(Node root, int value) {
        if (root == null)
            return false;
        if (value == root.key)
            return true;
        if (value < root.key)
            return searchRecursively(root.left, value);
        return searchRecursively(root.right, value);
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

    public static void insert(int key) {
        root = insertKey(root, key);
    }

    public static void inorder() {
        inorderRec(root);
    }

    public static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static Node deleteRec(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    public static int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}