package CoT.gpt4o;
public class Task156 {
    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public static void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public static void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Preorder traversal:");
        preorder(root);
        System.out.println();

        System.out.println("Inorder traversal:");
        inorder(root);
        System.out.println();

        System.out.println("Postorder traversal:");
        postorder(root);
        System.out.println();
    }
}