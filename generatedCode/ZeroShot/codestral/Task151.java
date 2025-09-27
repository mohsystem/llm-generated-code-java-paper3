package ZeroShot.codestral;
class Node {
    int key;
    Node left, right;
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class Task151 {
    Node root;

    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValueNode(root.right).key;
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    boolean search(Node root, int key) {
        if (root == null || root.key == key) {
            return root != null;
        }
        if (root.key < key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    public static void main(String[] args) {
        Task151 tree = new Task151();
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("Search 40: " + tree.search(tree.root, 40));
        System.out.println("Search 90: " + tree.search(tree.root, 90));

        tree.delete(tree.root, 20);
        System.out.println("Search 20 after deletion: " + tree.search(tree.root, 20));

        tree.delete(tree.root, 30);
        System.out.println("Search 30 after deletion: " + tree.search(tree.root, 30));

        tree.delete(tree.root, 50);
        System.out.println("Search 50 after deletion: " + tree.search(tree.root, 50));
    }
}