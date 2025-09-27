package CoT.llama31;
import java.util.PriorityQueue;

class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
}

public class Task186 {
    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (Node list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        Node dummy = new Node(0);
        Node current = dummy;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case 1
        Node[] lists1 = new Node[3];
        lists1[0] = new Node(1);
        lists1[0].next = new Node(4);
        lists1[0].next.next = new Node(5);

        lists1[1] = new Node(1);
        lists1[1].next = new Node(3);
        lists1[1].next.next = new Node(4);

        lists1[2] = new Node(2);
        lists1[2].next = new Node(6);

        Node head1 = mergeKLists(lists1);
        printList(head1);

        // Test case 2
        Node[] lists2 = new Node[0];
        Node head2 = mergeKLists(lists2);
        printList(head2);

        // Test case 3
        Node[] lists3 = new Node[1];
        lists3[0] = null;
        Node head3 = mergeKLists(lists3);
        printList(head3);

        // Test case 4
        Node[] lists4 = new Node[2];
        lists4[0] = new Node(1);
        lists4[1] = new Node(2);
        Node head4 = mergeKLists(lists4);
        printList(head4);

        // Test case 5
        Node[] lists5 = new Node[3];
        lists5[0] = new Node(1);
        lists5[0].next = new Node(3);
        lists5[0].next.next = new Node(7);

        lists5[1] = new Node(2);
        lists5[1].next = new Node(4);
        lists5[1].next.next = new Node(8);

        lists5[2] = new Node(9);
        Node head5 = mergeKLists(lists5);
        printList(head5);
    }
}