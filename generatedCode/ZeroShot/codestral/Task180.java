package ZeroShot.codestral;
public class Task180 {
    static class Node {
        int data;
        Node parent;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public void addChild(Node child) {
            child.parent = this;
            this.children.add(child);
        }
    }

    public static void reparent(Node node) {
        Node parent = node.parent;
        node.parent = null;
        if (parent != null) {
            parent.children.remove(node);
            node.addChild(parent);
        }
        for (Node child : new ArrayList<>(node.children)) {
            reparent(child);
        }
    }

    public static void main(String[] args) {
        // Test cases
        Node root = new Node(0);
        root.addChild(new Node(1));
        root.addChild(new Node(2));
        Node three = new Node(3);
        root.addChild(three);
        three.addChild(new Node(8));
        three.addChild(new Node(9));
        Node two = root.children.get(1);
        two.addChild(new Node(6));
        two.addChild(new Node(7));
        Node one = root.children.get(0);
        one.addChild(new Node(4));
        one.addChild(new Node(5));

        reparent(two);
        // Now the tree is reparented on node 2
    }
}