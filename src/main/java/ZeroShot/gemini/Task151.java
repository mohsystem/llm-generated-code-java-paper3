package ZeroShot.gemini;
import java.util.LinkedList;
import java.util.Queue;

class Node3 {
    int data;
    Node3 left, right;

    Node3(int d) {
        data = d;
        left = right = null;
    }
}

class Task151 {

    Node3 root;

    Task151() {
        root = null;
    }


    void insert(int key) {
        root = insertRec(root, key);
    }


    Node3 insertRec(Node3 root, int key) {


        if (root == null) {
            root = new Node3(key);
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


    Node3 deleteRec(Node3 root, int key) {

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


    int minValue(Node3 root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }


    boolean search(int key) {
        root = searchRec(root, key);
        return root != null;
    }

    Node3 searchRec(Node3 root, int key) {
        if (root == null || root.data == key)
            return root;


        if (root.data > key)
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
        
        System.out.println(tree.search(40)); // Expected: true
        tree.deleteKey(40);
        System.out.println(tree.search(40)); // Expected: false
        
        tree.insert(40);
        System.out.println(tree.search(40)); // Expected: true
        
        tree.deleteKey(20);
        System.out.println(tree.search(20)); // Expected: false
        
        System.out.println(tree.search(80)); // Expected: true
    }
}