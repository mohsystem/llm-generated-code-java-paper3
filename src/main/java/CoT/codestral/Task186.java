package CoT.codestral;

import java.util.Arrays;

// Node3 class for linked list
class Node3 {
    int data;
    Node3 next;

    Node3(int d) {
        data = d;
        next = null;
    }
}

// Class for Task186
public class Task186 {
    // Function to merge k sorted linked lists
    public static Node3 mergeKLists(Node3[] lists) {
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
    public static Node3 mergeTwoLists(Node3 l1, Node3 l2) {
        Node3 dummy = new Node3(0);
        Node3 tail = dummy;

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
        Node3[] lists = new Node3[3];
        lists[0] = new Node3(1);
        lists[0].next = new Node3(4);
        lists[0].next.next = new Node3(5);

        lists[1] = new Node3(1);
        lists[1].next = new Node3(3);
        lists[1].next.next = new Node3(4);

        lists[2] = new Node3(2);
        lists[2].next = new Node3(6);

        Node3 result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}