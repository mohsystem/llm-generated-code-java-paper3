package ZeroShot.openai;
import java.util.PriorityQueue;

class Task186 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
            if (current.next != null) {
                queue.add(current.next);
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        // Test cases
        ListNode[] lists1 = { new ListNode(1), new ListNode(1), new ListNode(2) };
        lists1[0].next = new ListNode(4);
        lists1[0].next.next = new ListNode(5);
        lists1[1].next = new ListNode(3);
        lists1[1].next.next = new ListNode(4);
        lists1[2].next = new ListNode(6);
        printList(mergeKLists(lists1));

        ListNode[] lists2 = {};
        printList(mergeKLists(lists2));

        ListNode[] lists3 = { new ListNode(0) };
        printList(mergeKLists(lists3));

        ListNode[] lists4 = { new ListNode(-10), new ListNode(-5), new ListNode(4) };
        lists4[0].next = new ListNode(-9);
        lists4[1].next = new ListNode(-4);
        lists4[2].next = new ListNode(6);
        printList(mergeKLists(lists4));

        ListNode[] lists5 = { null, new ListNode(2) };
        printList(mergeKLists(lists5));
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}