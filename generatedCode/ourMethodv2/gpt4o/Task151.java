package ourMethodv2.gpt4o;
public class Task151 {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        BinarySearchTree() {
            root = null;
        }

        void insert(int data) {
            root = insertRec(root, data);
        }

        Node insertRec(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }

            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else if (data > root.data) {
                root.right = insertRec(root.right, data);
            }

            return root;
        }

        void delete(int data) {
            root = deleteRec(root, data);
        }

        Node deleteRec(Node root, int data) {
            if (root == null) {
                return root;
            }

            if (data < root.data) {
                root.left = deleteRec(root.left, data);
            } else if (data > root.data) {
                root.right = deleteRec(root.right, data);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                root.data = minValue(root.right);
                root.right = deleteRec(root.right, root.data);
            }

            return root;
        }

        int minValue(Node root) {
            int minValue = root.data;
            while (root.left != null) {
                minValue = root.left.data;
                root = root.left;
            }
            return minValue;
        }

        boolean search(int data) {
            return searchRec(root, data) != null;
        }

        Node searchRec(Node root, int data) {
            if (root == null || root.data == data) {
                return root;
            }

            if (root.data > data) {
                return searchRec(root.left, data);
            }

            return searchRec(root.right, data);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println(bst.search(50)); // true
        System.out.println(bst.search(15)); // false

        bst.delete(20);
        System.out.println(bst.search(20)); // false

        bst.delete(30);
        System.out.println(bst.search(30)); // false

        bst.delete(50);
        System.out.println(bst.search(50)); // false
    }
}