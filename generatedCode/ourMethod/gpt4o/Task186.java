package ourMethod.openai;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Task186 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;

            if (current.next != null) queue.add(current.next);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Task186 task = new Task186();
        
        // Test case 1
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        
        ListNode[] lists1 = new ListNode[]{l1, l2, l3};
        ListNode result1 = task.mergeKLists(lists1);
        printList(result1);
        
        // Test case 2
        ListNode[] lists2 = new ListNode[]{};
        ListNode result2 = task.mergeKLists(lists2);
        printList(result2);
        
        // Test case 3
        ListNode[] lists3 = new ListNode[]{new ListNode(0)};
        ListNode result3 = task.mergeKLists(lists3);
        printList(result3);
        
        // Test case 4
        ListNode[] lists4 = new ListNode[]{null};
        ListNode result4 = task.mergeKLists(lists4);
        printList(result4);
        
        // Test case 5
        ListNode l5 = new ListNode(-1);
        l5.next = new ListNode(0);
        l5.next.next = new ListNode(1);
        
        ListNode[] lists5 = new ListNode[]{l5};
        ListNode result5 = task.mergeKLists(lists5);
        printList(result5);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}