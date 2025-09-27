package ourMethod.codestral;
import java.util.*;

class Node2 {
    int data;
    Node2 parent;
    List<Node2> children;

    public Node2(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(Node2 child) {
        child.parent = this;
        this.children.add(child);
    }
}

public class Task180 {
    public static void reparent(Node2 node, Node2 parent) {
        if (node.parent != null) {
            node.parent.children.remove(node);
        }
        node.parent = parent;
        if (parent != null) {
            parent.children.add(node);
        }
    }

    public static void main(String[] args) {
        Node2 root = new Node2(0);
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(4);
        Node2 node5 = new Node2(5);
        Node2 node6 = new Node2(6);
        Node2 node7 = new Node2(7);
        Node2 node8 = new Node2(8);
        Node2 node9 = new Node2(9);

        root.addChild(node1);
        root.addChild(node2);
        root.addChild(node3);
        node1.addChild(node4);
        node1.addChild(node5);
        node2.addChild(node6);
        node2.addChild(node7);
        node3.addChild(node8);
        node3.addChild(node9);

        reparent(node6, null);
        reparent(node2, node6);
        reparent(node7, node2);
        reparent(root, node2);
    }
}