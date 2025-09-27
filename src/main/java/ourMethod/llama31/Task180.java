package ourMethod.llama31;
import java.util.*;

public class Task180 {
    static class Node {
        int value;
        List<Node> children = new ArrayList<>();
        Node parent;

        public Node(int value) {
            this.value = value;
        }

        public void addChild(Node child) {
            child.parent = this;
            children.add(child);
        }

        public void reparent(Node newRoot) {
            if (this == newRoot) return;

            // Remove newRoot from its current position
            Node newRootParent = newRoot.parent;
            if (newRootParent != null) {
                newRootParent.children.remove(newRoot);
            }

            // Make newRoot the new root
            newRoot.parent = null;

            // Reparent the rest of the tree
            Node current = this;
            while (current != newRoot) {
                Node next = current.parent;
                current.parent = newRoot;
                newRoot.children.add(current);
                current = next;
            }
        }

        public void printTree(Node node, int level) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(node.value);
            for (Node child : node.children) {
                printTree(child, level + 1);
            }
        }

        public static void main(String[] args) {
            // Create the tree
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
            root.printTree(root, 0);

            // Reparent the tree from node6's perspective
            root.reparent(node6);

            System.out.println("Reparented Tree from node6's perspective:");
            node6.printTree(node6, 0);
        }
    }
}