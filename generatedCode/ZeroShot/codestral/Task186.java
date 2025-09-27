package ZeroShot.codestral;
public class Task186 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (ListNode node: lists) {
            if (node != null)
                queue.add(node);
        }
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null)
                queue.add(curr.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Task186 task = new Task186();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        ListNode result = task.mergeKLists(lists);
        // print or process result
    }
}