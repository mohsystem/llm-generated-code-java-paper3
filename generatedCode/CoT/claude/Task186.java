package CoT.claude;

class Task186 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        // Add first node of each list to queue
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            
            if (node.next != null) {
                queue.offer(node.next);
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
        
        // Test case 2
        ListNode[] lists2 = new ListNode[0];
        
        // Test case 3
        ListNode[] lists3 = new ListNode[1];
        lists3[0] = null;
        
        // Test case 4
        ListNode[] lists4 = new ListNode[2];
        lists4[0] = new ListNode(1);
        lists4[1] = new ListNode(2);
        
        // Test case 5
        ListNode[] lists5 = new ListNode[3];
        lists5[0] = new ListNode(1);
        lists5[1] = new ListNode(1);
        lists5[2] = new ListNode(2);
        
        ListNode result1 = solution.mergeKLists(lists1);
        ListNode result2 = solution.mergeKLists(lists2);
        ListNode result3 = solution.mergeKLists(lists3);
        ListNode result4 = solution.mergeKLists(lists4);
        ListNode result5 = solution.mergeKLists(lists5);
    }
}
