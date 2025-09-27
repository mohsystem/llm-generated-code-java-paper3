package CoT.codestral;
import java.util.*;

public class Task180 {
    static class Node {
        int data;
        List<Node> children = new ArrayList<>();
    }

    static Node reparent(Node root, int newRootData) {
        Node newRoot = findNode(root, newRootData);
        if (newRoot == null) {
            return root;
        }
        Node parent = findParent(root, newRootData);
        if (parent != null) {
            parent.children.remove(newRoot);
        }
        for (Node child : newRoot.children) {
            reparent(child, newRootData);
        }
        return newRoot;
    }

    static Node findNode(Node root, int data) {
        if (root.data == data) {
            return root;
        }
        for (Node child : root.children) {
            Node found = findNode(child, data);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    static Node findParent(Node root, int data) {
        for (Node child : root.children) {
            if (child.data == data) {
                return root;
            }
            Node found = findParent(child, data);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Test cases here
    }
}