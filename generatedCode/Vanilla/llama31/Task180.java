package Vanilla.llama31;
public class Task180 {
    public static class Node {
        int value;
        Node[] children;

        public Node(int value, Node[] children) {
            this.value = value;
            this.children = children;
        }
    }

    public static Node reparentTree(Node root, int newNodeValue) {
        if (root == null) return null;
        if (root.value == newNodeValue) return root;

        Node newRoot = null;
        for (Node child : root.children) {
            Node result = reparentTree(child, newNodeValue);
            if (result != null) {
                newRoot = result;
                // Adjust the children of the old root
                Node[] newChildren = new Node[root.children.length - 1];
                int j = 0;
                for (Node n : root.children) {
                    if (n != child) {
                        newChildren[j++] = n;
                    }
                }
                root.children = newChildren;
                // Add the old root to the children of the new root
                Node[] newNewChildren = new Node[newRoot.children.length + 1];
                System.arraycopy(newRoot.children, 0, newNewChildren, 0, newRoot.children.length);
                newNewChildren[newRoot.children.length] = root;
                newRoot.children = newNewChildren;
                break;
            }
        }
        return newRoot;
    }

    public static void printTree(Node node, int level) {
        if (node == null) return;
        for (int i = 0; i < level; i++) System.out.print("  ");
        System.out.println(node.value);
        for (Node child : node.children) {
            printTree(child, level + 1);
        }
    }

    public static void main(String[] args) {
        // Example tree
        Node root = new Node(0, new Node[] {
            new Node(1, new Node[] { new Node(4, null), new Node(5, null) }),
            new Node(2, new Node[] { new Node(6, null), new Node(7, null) }),
            new Node(3, new Node[] { new Node(8, null), new Node(9, null) })
        });

        System.out.println("Original Tree:");
        printTree(root, 0);

        Node newRoot = reparentTree(root, 6);

        System.out.println("Reparented Tree from node 6:");
        printTree(newRoot, 0);
    }
}