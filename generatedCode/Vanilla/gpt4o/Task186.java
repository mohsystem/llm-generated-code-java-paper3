package Vanilla.openai;
import java.util.PriorityQueue;

public class Task186 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) queue.offer(list);
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) queue.offer(node.next);
        }
        return head.next;
    }

    public static void main(String[] args) {
        Task186 solution = new Task186();
        
        // Example 1
        ListNode[] lists1 = {
            new ListNode(1), new ListNode(1), new ListNode(2)
        };
        lists1[0].next = new ListNode(4);
        lists1[0].next.next = new ListNode(5);
        lists1[1].next = new ListNode(3);
        lists1[1].next.next = new ListNode(4);
        lists1[2].next = new ListNode(6);
        
        printList(solution.mergeKLists(lists1));

        // Example 2
        ListNode[] lists2 = {};
        printList(solution.mergeKLists(lists2));

        // Example 3
        ListNode[] lists3 = { new ListNode(0) };
        printList(solution.mergeKLists(lists3));

        // Test case 4
        ListNode[] lists4 = { new ListNode(1) };
        printList(solution.mergeKLists(lists4));

        // Test case 5
        ListNode[] lists5 = { new ListNode(5), new ListNode(3), new ListNode(8) };
        lists5[0].next = new ListNode(10);
        lists5[1].next = new ListNode(4);
        lists5[2].next = new ListNode(9);
        printList(solution.mergeKLists(lists5));
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}