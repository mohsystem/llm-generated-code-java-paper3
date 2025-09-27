package CoT.llama31;
public class Task180 {
    static class Node {
        int value;
        Node parent;
        Node[] children;

        public Node(int value) {
            this.value = value;
            this.children = new Node[0];
        }

        public void addChild(Node child) {
            Node[] newChildren = new Node[children.length + 1];
            System.arraycopy(children, 0, newChildren, 0, children.length);
            newChildren[children.length] = child;
            children = newChildren;
            child.parent = this;
        }

        public void reparent(Node newParent) {
            if (parent != null) {
                Node[] newChildren = new Node[parent.children.length - 1];
                int j = 0;
                for (int i = 0; i < parent.children.length; i++) {
                    if (parent.children[i] != this) {
                        newChildren[j++] = parent.children[i];
                    }
                }
                parent.children = newChildren;
            }
            newParent.addChild(this);
        }

        public void printTree(int level) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(value);
            for (Node child : children) {
                child.printTree(level + 1);
            }
        }
    }

    public static void main(String[] args) {
        // Create a sample tree
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        root.addChild(node1);
        root.addChild(node2);
        root.addChild(node3);
        node1.addChild(node4);
        node1.addChild(node5);
        node2.addChild(node6);
        node2.addChild(node7);
        node3.addChild(node8);
        node3.addChild(node9);

        // Print original tree
        System.out.println("Original Tree:");
        root.printTree(0);

        // Reparent tree from node 6's perspective
        node2.reparent(node6);
        root.reparent(node6);
        node3.reparent(node6);

        // Print reparented tree
        System.out.println("Reparented Tree from node 6's perspective:");
        node6.printTree(0);
    }
}