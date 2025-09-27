package Vanilla.codestral;
import java.util.*;

class Node4 {
    int data;
    Node4 parent;
    List<Node4> children;

    Node4(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    void addChild(Node4 child) {
        children.add(child);
        child.parent = this;
    }
}

class Task180 {
    static void reparent(Node4 node) {
        if (node.parent != null) {
            Node4 parent = node.parent;
            parent.children.remove(node);
            node.parent = null;
            node.addChild(parent);
            reparent(parent);
        }
    }

    public static void main(String[] args) {
        Node4 root = new Node4(0);
        Node4 node1 = new Node4(1);
        Node4 node2 = new Node4(2);
        Node4 node3 = new Node4(3);

        root.addChild(node1);
        root.addChild(node2);
        root.addChild(node3);

        reparent(node2);
        // Now, the tree is reparented on node2
    }
}