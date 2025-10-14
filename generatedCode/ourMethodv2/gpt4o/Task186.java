package ourMethodv2.gpt4o;
import java.util.PriorityQueue;
import java.util.Comparator;

class Task186 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode[] testCases = new ListNode[5];

        testCases[0] = new ListNode(1);
        testCases[0].next = new ListNode(4);
        testCases[0].next.next = new ListNode(5);

        testCases[1] = new ListNode(1);
        testCases[1].next = new ListNode(3);
        testCases[1].next.next = new ListNode(4);

        testCases[2] = new ListNode(2);
        testCases[2].next = new ListNode(6);

        ListNode[] example1 = {testCases[0], testCases[1], testCases[2]};
        ListNode merged1 = mergeKLists(example1);
        printList(merged1);

        ListNode[] example2 = {};
        ListNode merged2 = mergeKLists(example2);
        printList(merged2);

        ListNode[] example3 = {null};
        ListNode merged3 = mergeKLists(example3);
        printList(merged3);

        ListNode[] example4 = {null, new ListNode(1), new ListNode(0)};
        ListNode merged4 = mergeKLists(example4);
        printList(merged4);

        ListNode[] example5 = {new ListNode(5), new ListNode(6)};
        ListNode merged5 = mergeKLists(example5);
        printList(merged5);
    }
    
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}