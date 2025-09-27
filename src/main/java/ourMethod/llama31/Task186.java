package ourMethod.llama31;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Task186 {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test cases
        ListNode[] lists1 = {
            new ListNode(1),
            new ListNode(4),
            new ListNode(5),
            new ListNode(1),
            new ListNode(3),
            new ListNode(4),
            new ListNode(2),
            new ListNode(6)
        };
        lists1[0].next = lists1[1];
        lists1[1].next = lists1[2];
        lists1[3].next = lists1[4];
        lists1[4].next = lists1[5];
        lists1[6].next = lists1[7];

        ListNode[] lists = {lists1[0], lists1[3], lists1[6]};
        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}