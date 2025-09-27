package CoT.claude;

public class Task151 {
    static class Node {
        int data;
        Node left, right;
        
        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    
    static class BST {
        Node root;
        
        BST() {
            root = null;
        }
        
        Node insert(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }
            if (value < node.data) {
                node.left = insert(node.left, value);
            } else if (value > node.data) {
                node.right = insert(node.right, value);
            }
            return node;
        }
        
        Node delete(Node node, int value) {
            if (node == null) {
                return null;
            }
            if (value < node.data) {
                node.left = delete(node.left, value);
            } else if (value > node.data) {
                node.right = delete(node.right, value);
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                }
                node.data = minValue(node.right);
                node.right = delete(node.right, node.data);
            }
            return node;
        }
        
        int minValue(Node node) {
            int minv = node.data;
            while (node.left != null) {
                minv = node.left.data;
                node = node.left;
            }
            return minv;
        }
        
        boolean search(Node node, int value) {
            if (node == null || node.data == value) {
                return node != null;
            }
            if (value < node.data) {
                return search(node.left, value);
            }
            return search(node.right, value);
        }
    }
    
    public static void main(String[] args) {
        BST bst = new BST();
        
        // Test case 1: Insert elements
        bst.root = bst.insert(bst.root, 50);
        bst.root = bst.insert(bst.root, 30);
        bst.root = bst.insert(bst.root, 70);
        System.out.println("Search 30: " + bst.search(bst.root, 30));
        
        // Test case 2: Search non-existent element
        System.out.println("Search 40: " + bst.search(bst.root, 40));
        
        // Test case 3: Delete leaf node
        bst.root = bst.delete(bst.root, 30);
        System.out.println("Search after delete 30: " + bst.search(bst.root, 30));
        
        // Test case 4: Delete node with one child
        bst.root = bst.insert(bst.root, 60);
        bst.root = bst.delete(bst.root, 70);
        System.out.println("Search after delete 70: " + bst.search(bst.root, 70));
        
        // Test case 5: Delete node with two children
        bst.root = bst.insert(bst.root, 70);
        bst.root = bst.insert(bst.root, 65);
        bst.root = bst.delete(bst.root, 60);
        System.out.println("Search after delete 60: " + bst.search(bst.root, 60));
    }
}
