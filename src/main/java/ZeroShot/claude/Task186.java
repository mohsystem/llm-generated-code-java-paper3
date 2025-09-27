package ZeroShot.claude;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Task186 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start + 1 == end) return mergeTwoLists(lists[start], lists[end]);
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        Task186 solution = new Task186();
        
        // Test case 1: [[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists1 = new ListNode[3];
        lists1[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists1[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists1[2] = new ListNode(2, new ListNode(6));
        printList(solution.mergeKLists(lists1));

        // Test case 2: []
        ListNode[] lists2 = new ListNode[0];
        printList(solution.mergeKLists(lists2));

        // Test case 3: [[]]
        ListNode[] lists3 = new ListNode[1];
        lists3[0] = null;
        printList(solution.mergeKLists(lists3));

        // Test case 4: [[1]]
        ListNode[] lists4 = new ListNode[1];
        lists4[0] = new ListNode(1);
        printList(solution.mergeKLists(lists4));

        // Test case 5: [[1,2,3],[4,5,6],[7,8,9]]
        ListNode[] lists5 = new ListNode[3];
        lists5[0] = new ListNode(1, new ListNode(2, new ListNode(3)));
        lists5[1] = new ListNode(4, new ListNode(5, new ListNode(6)));
        lists5[2] = new ListNode(7, new ListNode(8, new ListNode(9)));
        printList(solution.mergeKLists(lists5));
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
