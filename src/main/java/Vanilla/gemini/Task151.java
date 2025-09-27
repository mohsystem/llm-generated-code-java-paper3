package Vanilla.gemini;
public class Task151 {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node root;

    Task151() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    Node search(int key) {
        return searchRec(root, key);
    }

    Node searchRec(Node root, int key) {
        if (root == null || root.data == key)
            return root;

        if (key < root.data)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }


    public static void main(String[] args) {
        Task151 tree = new Task151();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(tree.search(40) != null); // Expected: true
        System.out.println(tree.search(100) == null); // Expected: true

        tree.deleteKey(20);
        System.out.println(tree.search(20) == null); // Expected: true

        tree.deleteKey(30);
        System.out.println(tree.search(30) == null); // Expected: true

        tree.deleteKey(50);
        System.out.println(tree.search(50) == null); // Expected: true

    }
}