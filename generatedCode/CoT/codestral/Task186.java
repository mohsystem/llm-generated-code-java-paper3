package CoT.codestral;
// Node class for linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

// Class for Task186
public class Task186 {
    // Function to merge k sorted linked lists
    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        while (lists.length > 1) {
            int k = lists.length;
            for (int i = 0; i < k / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[k - i - 1]);
            }
            lists = Arrays.copyOf(lists, (k + 1) / 2);
        }
        return lists[0];
    }

    // Function to merge two sorted linked lists
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return dummy.next;
    }

    // Main method for testing
    public static void main(String[] args) {
        Node[] lists = new Node[3];
        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(5);

        lists[1] = new Node(1);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(4);

        lists[2] = new Node(2);
        lists[2].next = new Node(6);

        Node result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}