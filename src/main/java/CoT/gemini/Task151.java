package CoT.gemini;
class Node4 {
    int data;
    Node4 left, right;

    Node4(int d) {
        data = d;
        left = right = null;
    }
}

public class Task151 {

    Node4 root;

    Task151() {
        root = null;
    }


    void insert(int key) {
        root = insertRec(root, key);
    }


    Node4 insertRec(Node4 root, int key) {


        if (root == null) {
            root = new Node4(key);
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


    Node4 deleteRec(Node4 root, int key) {


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


    int minValue(Node4 root) {
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


    Node4 searchRec(Node4 root, int key) {

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

        tree.deleteKey(20);
        System.out.println(tree.search(20)); // Expected: false


        tree.insert(10);
        System.out.println(tree.search(10)); // Expected: true
        tree.deleteKey(50);
        System.out.println(tree.search(50)); // Expected: false


        tree.insert(90);
        System.out.println(tree.search(90)); // Expected: true
        tree.deleteKey(10);
        System.out.println(tree.search(10)); // Expected: false



    }
}