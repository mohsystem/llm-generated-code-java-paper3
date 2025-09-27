package CoT.llama31;
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
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        System.out.println("Inorder Traversal of the given tree is");
        inorder(tree.root);

        System.out.println("\nDelete 20");
        tree.root = deleteNode(tree.root, 20);
        System.out.println("Inorder Traversal of the modified tree is");
        inorder(tree.root);

        System.out.println("\nSearch for 40");
        if (searchNode(tree.root, 40))
            System.out.println("Node found");
        else
            System.out.println("Node not found");

        System.out.println("\nInsert 10");
        tree.root = insertNode(tree.root, 10);
        System.out.println("Inorder Traversal of the modified tree is");
        inorder(tree.root);
    }

    static Node insertNode(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertNode(root.left, key);
        else if (key > root.key)
            root.right = insertNode(root.right, key);

        return root;
    }

    static Node deleteNode(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteNode(root.right, root.key);
        }
        return root;
    }

    static int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    static boolean searchNode(Node root, int key) {
        if (root == null) return false;

        if (key < root.key)
            return searchNode(root.left, key);
        else if (key > root.key)
            return searchNode(root.right, key);
        else
            return true;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
}