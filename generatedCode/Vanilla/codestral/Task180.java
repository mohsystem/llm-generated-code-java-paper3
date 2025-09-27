package Vanilla.codestral;
import java.util.*;

class Node {
    int data;
    Node parent;
    List<Node> children;

    Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    void addChild(Node child) {
        children.add(child);
        child.parent = this;
    }
}

class Task180 {
    static void reparent(Node node) {
        if (node.parent != null) {
            Node parent = node.parent;
            parent.children.remove(node);
            node.parent = null;
            node.addChild(parent);
            reparent(parent);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        root.addChild(node1);
        root.addChild(node2);
        root.addChild(node3);

        reparent(node2);
        // Now, the tree is reparented on node2
    }
}