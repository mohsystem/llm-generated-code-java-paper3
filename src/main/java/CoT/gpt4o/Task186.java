package CoT.gpt4o;
import java.util.PriorityQueue;

class Task186 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode result = mergeKLists(lists);
        printList(result);

        ListNode[] lists2 = {};
        result = mergeKLists(lists2);
        printList(result);

        ListNode[] lists3 = {null};
        result = mergeKLists(lists3);
        printList(result);

        ListNode[] lists4 = {new ListNode(1)};
        result = mergeKLists(lists4);
        printList(result);

        ListNode[] lists5 = {new ListNode(-1), new ListNode(1)};
        lists5[0].next = new ListNode(3);
        result = mergeKLists(lists5);
        printList(result);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}