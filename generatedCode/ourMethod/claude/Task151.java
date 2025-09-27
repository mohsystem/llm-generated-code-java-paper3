package ourMethod.claude;

public class Task151 {
    private static class Node {
        private int data;
        private Node left;
        private Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root;
    
    public Task151() {
        this.root = null;
    }
    
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }
    
    public boolean search(int data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(Node root, int data) {
        if (root == null || root.data == data) {
            return root != null;
        }
        
        if (data < root.data) {
            return searchRec(root.left, data);
        }
        
        return searchRec(root.right, data);
    }
    
    public void delete(int data) {
        root = deleteRec(root, data);
    }
    
    private Node deleteRec(Node root, int data) {
        if (root == null) {
            return null;
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
    
    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    
    public static void main(String[] args) {
        Task151 bst = new Task151();
        
        // Test case 1: Insert and search
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        System.out.println("Test 1 - Search 30: " + bst.search(30));  // Should print true
        
        // Test case 2: Search non-existent value
        System.out.println("Test 2 - Search 40: " + bst.search(40));  // Should print false
        
        // Test case 3: Delete leaf node
        bst.delete(30);
        System.out.println("Test 3 - Search 30 after deletion: " + bst.search(30));  // Should print false
        
        // Test case 4: Delete node with one child
        bst.insert(60);
        bst.delete(70);
        System.out.println("Test 4 - Search 70 after deletion: " + bst.search(70));  // Should print false
        
        // Test case 5: Delete node with two children
        bst.insert(80);
        bst.delete(60);
        System.out.println("Test 5 - Search 60 after deletion: " + bst.search(60));  // Should print false
    }
}
