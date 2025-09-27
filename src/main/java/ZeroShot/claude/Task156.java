package ZeroShot.claude;

class Task156 {
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    
    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1: Single node tree
        Node root1 = new Node(1);
        System.out.println("Test Case 1:");
        System.out.print("Preorder: "); preorder(root1); System.out.println();
        System.out.print("Inorder: "); inorder(root1); System.out.println();
        System.out.print("Postorder: "); postorder(root1); System.out.println();
        
        // Test Case 2: Complete binary tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        System.out.println("\\nTest Case 2:");
        System.out.print("Preorder: "); preorder(root2); System.out.println();
        System.out.print("Inorder: "); inorder(root2); System.out.println();
        System.out.print("Postorder: "); postorder(root2); System.out.println();
        
        // Test Case 3: Left skewed tree
        Node root3 = new Node(1);
        root3.left = new Node(2);
        root3.left.left = new Node(3);
        System.out.println("\\nTest Case 3:");
        System.out.print("Preorder: "); preorder(root3); System.out.println();
        System.out.print("Inorder: "); inorder(root3); System.out.println();
        System.out.print("Postorder: "); postorder(root3); System.out.println();
        
        // Test Case 4: Right skewed tree
        Node root4 = new Node(1);
        root4.right = new Node(2);
        root4.right.right = new Node(3);
        System.out.println("\\nTest Case 4:");
        System.out.print("Preorder: "); preorder(root4); System.out.println();
        System.out.print("Inorder: "); inorder(root4); System.out.println();
        System.out.print("Postorder: "); postorder(root4); System.out.println();
        
        // Test Case 5: Empty tree
        Node root5 = null;
        System.out.println("\\nTest Case 5:");
        System.out.print("Preorder: "); preorder(root5); System.out.println();
        System.out.print("Inorder: "); inorder(root5); System.out.println();
        System.out.print("Postorder: "); postorder(root5); System.out.println();
    }
}
