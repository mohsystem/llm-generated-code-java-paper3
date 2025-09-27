package ZeroShot.codestral;
class Node1 {
    int key;
    Node1 left, right;
    public Node1(int item) {
        key = item;
        left = right = null;
    }
}

class Task151 {
    Node1 root;

    Node1 insert(Node1 node, int key) {
        if (node == null) {
            return new Node1(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    Node1 minValueNode(Node1 node) {
        Node1 current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    Node1 delete(Node1 root, int key) {
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

    boolean search(Node1 root, int key) {
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