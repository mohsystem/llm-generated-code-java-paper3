package Vanilla.claude;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Task186 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        // Add first node from each list to priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        Task186 solution = new Task186();
        
        // Test case 1
        ListNode[] lists1 = new ListNode[3];
        lists1[0] = new ListNode(1);
        lists1[0].next = new ListNode(4);
        lists1[0].next.next = new ListNode(5);
        
        lists1[1] = new ListNode(1);
        lists1[1].next = new ListNode(3);
        lists1[1].next.next = new ListNode(4);
        
        lists1[2] = new ListNode(2);
        lists1[2].next = new ListNode(6);
        
        ListNode result1 = solution.mergeKLists(lists1);
        printList(result1); // Expected: 1->1->2->3->4->4->5->6
        
        // Test case 2
        ListNode[] lists2 = new ListNode[0];
        ListNode result2 = solution.mergeKLists(lists2);
        printList(result2); // Expected: null
        
        // Test case 3
        ListNode[] lists3 = {null};
        ListNode result3 = solution.mergeKLists(lists3);
        printList(result3); // Expected: null
        
        // Test case 4
        ListNode[] lists4 = new ListNode[1];
        lists4[0] = new ListNode(1);
        ListNode result4 = solution.mergeKLists(lists4);
        printList(result4); // Expected: 1
        
        // Test case 5
        ListNode[] lists5 = new ListNode[2];
        lists5[0] = new ListNode(2);
        lists5[1] = new ListNode(1);
        ListNode result5 = solution.mergeKLists(lists5);
        printList(result5); // Expected: 1->2
    }
    
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
