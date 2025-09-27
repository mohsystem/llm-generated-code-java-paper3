package ZeroShot.claude;

class Task151 {
    static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    Node root;
    
    Task151() {
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
        
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        
        return root;
    }
    
    boolean search(int data) {
        return searchRec(root, data);
    }
    
    boolean searchRec(Node root, int data) {
        if (root == null || root.data == data)
            return root != null;
        
        if (data < root.data)
            return searchRec(root.left, data);
        
        return searchRec(root.right, data);
    }
    
    void delete(int data) {
        root = deleteRec(root, data);
    }
    
    Node deleteRec(Node root, int data) {
        if (root == null)
            return root;
            
        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
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
    
    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    
    public static void main(String[] args) {
        Task151 bst = new Task151();
        
        // Test Case 1: Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        
        // Test Case 2: Search elements
        System.out.println("Search 20: " + bst.search(20));  // true
        System.out.println("Search 60: " + bst.search(60));  // false
        
        // Test Case 3: Delete leaf node
        bst.delete(20);
        System.out.println("Search after delete 20: " + bst.search(20));  // false
        
        // Test Case 4: Delete node with one child
        bst.insert(60);
        bst.insert(80);
        bst.delete(70);
        System.out.println("Search after delete 70: " + bst.search(70));  // false
        
        // Test Case 5: Delete node with two children
        bst.delete(30);
        System.out.println("Search after delete 30: " + bst.search(30));  // false
    }
}
