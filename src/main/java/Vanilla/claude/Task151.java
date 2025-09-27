package Vanilla.claude;

class Task151 {
    static class Node {
        int data;
        Node left, right;
        
        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    
    Node root;
    
    Task151() {
        root = null;
    }
    
    Node insert(Node root, int value) {
        if(root == null) {
            root = new Node(value);
            return root;
        }
        
        if(value < root.data)
            root.left = insert(root.left, value);
        else if(value > root.data)
            root.right = insert(root.right, value);
            
        return root;
    }
    
    Node delete(Node root, int value) {
        if(root == null)
            return root;
            
        if(value < root.data)
            root.left = delete(root.left, value);
        else if(value > root.data)
            root.right = delete(root.right, value);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
                
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    
    int minValue(Node root) {
        int minv = root.data;
        while(root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    
    boolean search(Node root, int value) {
        if(root == null || root.data == value)
            return root != null;
            
        if(value < root.data)
            return search(root.left, value);
            
        return search(root.right, value);
    }
    
    public static void main(String[] args) {
        Task151 bst = new Task151();
        
        // Test case 1: Insert elements
        bst.root = bst.insert(bst.root, 50);
        bst.root = bst.insert(bst.root, 30);
        bst.root = bst.insert(bst.root, 70);
        
        // Test case 2: Search for existing element
        System.out.println("Search 30: " + bst.search(bst.root, 30));
        
        // Test case 3: Search for non-existing element
        System.out.println("Search 40: " + bst.search(bst.root, 40));
        
        // Test case 4: Delete leaf node
        bst.root = bst.delete(bst.root, 30);
        System.out.println("After deleting 30, Search 30: " + bst.search(bst.root, 30));
        
        // Test case 5: Delete node with two children
        bst.root = bst.insert(bst.root, 30);
        bst.root = bst.insert(bst.root, 40);
        bst.root = bst.delete(bst.root, 30);
        System.out.println("After re-deleting 30, Search 40: " + bst.search(bst.root, 40));
    }
}
