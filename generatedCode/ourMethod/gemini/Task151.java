package ourMethod.gemini;
import java.util.LinkedList;
import java.util.Queue;

class Task151 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BST {
        Node root;

        BST() {
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
            int minv = root.data;
            while (root.left != null) {
                minv = root.left.data;
                root = root.left;
            }
            return minv;
        }


        boolean search(int data) {
            return searchRec(root, data);
        }

        boolean searchRec(Node root, int data) {
            if (root == null) {
                return false;
            }

            if (root.data == data) {
                return true;
            }

            if (data < root.data) {
                return searchRec(root.left, data);
            } else {
                return searchRec(root.right, data);
            }
        }


        void levelOrderTraversal() {
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }


    public static void main(String[] args) {

        BST tree = new BST();


        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.print("Level order traversal: ");
        tree.levelOrderTraversal();

        System.out.println("\nDelete 20");
        tree.delete(20);
        System.out.print("Level order traversal: ");
        tree.levelOrderTraversal();

        System.out.println("\nDelete 30");
        tree.delete(30);
        System.out.print("Level order traversal: ");
        tree.levelOrderTraversal();

        System.out.println("\nDelete 50");
        tree.delete(50);
        System.out.print("Level order traversal: ");
        tree.levelOrderTraversal();

        System.out.println("\nSearch 50: " + tree.search(50));
        System.out.println("Search 80: " + tree.search(80));

        System.out.println("Insert 90");
        tree.insert(90);
        System.out.print("Level order traversal: ");
        tree.levelOrderTraversal();

        System.out.println("\nDelete 90");
        tree.delete(90);
        System.out.print("Level order traversal: ");
        tree.levelOrderTraversal();
    }
}