package Vanilla.llama31;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Task186 {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Test case 1
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};
        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

        // Test case 2
        lists = new ListNode[0];
        result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

        // Test case 3
        lists = new ListNode[1];
        result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}