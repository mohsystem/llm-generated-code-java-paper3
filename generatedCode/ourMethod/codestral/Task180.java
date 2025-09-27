package ourMethod.codestral;
import java.util.*;

class Node {
    int data;
    Node parent;
    List<Node> children;

    public Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        child.parent = this;
        this.children.add(child);
    }
}

public class Task180 {
    public static void reparent(Node node, Node parent) {
        if (node.parent != null) {
            node.parent.children.remove(node);
        }
        node.parent = parent;
        if (parent != null) {
            parent.children.add(node);
        }
    }

    public static void main(String[] args) {
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

        reparent(node6, null);
        reparent(node2, node6);
        reparent(node7, node2);
        reparent(root, node2);
    }
}