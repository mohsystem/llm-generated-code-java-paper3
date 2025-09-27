package ZeroShot.llama31;
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

        public void reparentFromNode(Node newRoot) {
            if (this == newRoot) return;

            Node current = this;
            Node newParent = null;

            // Find the path from the current root to the new root
            while (current != newRoot) {
                newParent = current.parent;
                current.parent = null;
                if (newParent != null) {
                    for (Node child : newParent.children) {
                        if (child == current) {
                            // Remove current from newParent's children
                            Node[] newChildren = new Node[newParent.children.length - 1];
                            int j = 0;
                            for (Node child2 : newParent.children) {
                                if (child2 != current) {
                                    newChildren[j++] = child2;
                                }
                            }
                            newParent.children = newChildren;
                            break;
                        }
                    }
                }
                current = newParent;
            }

            // Reattach all nodes under the new root
            reattachChildren(this, newRoot);
        }

        private void reattachChildren(Node root, Node newRoot) {
            if (root == newRoot) return;

            for (Node child : root.children) {
                reattachChildren(child, newRoot);
            }

            if (root.parent != null) {
                for (Node child : root.parent.children) {
                    if (child == root) {
                        // Remove root from parent's children
                        Node[] newChildren = new Node[root.parent.children.length - 1];
                        int j = 0;
                        for (Node child2 : root.parent.children) {
                            if (child2 != root) {
                                newChildren[j++] = child2;
                            }
                        }
                        root.parent.children = newChildren;
                        break;
                    }
                }
                root.parent = null;
            }

            newRoot.addChild(root);
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

        System.out.println("Original Tree:");
        root.printTree(0);

        // Reparent the tree from node 6's perspective
        root.reparentFromNode(node6);

        System.out.println("Tree reparented from node 6's perspective:");
        node6.printTree(0);
    }
}