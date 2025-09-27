package CoT.codestral;
// Java
class Node1 {
    int key;
    Node1 left, right;

    public Node1(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node1 root;

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node1 insertRec(Node1 root, int key) {
        if (root == null) {
            root = new Node1(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node1 deleteRec(Node1 root, int key) {
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

    int minValue(Node1 root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node1 root, int key) {
        if (root == null || root.key == key)
            return root != null;

        if (key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }
}

public class Task151 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Search 60: " + tree.search(60));
        System.out.println("Delete 20");
        tree.delete(20);
        System.out.println("Search 20: " + tree.search(20));
    }
}