package ourMethod.claude;

class Task186 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    
    private static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        // Test case 1: [[1,4,5],[1,3,4],[2,6]]
        ListNode[] test1 = new ListNode[3];
        test1[0] = new ListNode(1);
        test1[0].next = new ListNode(4);
        test1[0].next.next = new ListNode(5);
        
        test1[1] = new ListNode(1);
        test1[1].next = new ListNode(3);
        test1[1].next.next = new ListNode(4);
        
        test1[2] = new ListNode(2);
        test1[2].next = new ListNode(6);
        
        // Test case 2: []
        ListNode[] test2 = new ListNode[0];
        
        // Test case 3: [[]]
        ListNode[] test3 = new ListNode[1];
        test3[0] = null;
        
        // Test case 4: [[1]]
        ListNode[] test4 = new ListNode[1];
        test4[0] = new ListNode(1);
        
        // Test case 5: [[1,2],[3,4]]
        ListNode[] test5 = new ListNode[2];
        test5[0] = new ListNode(1);
        test5[0].next = new ListNode(2);
        test5[1] = new ListNode(3);
        test5[1].next = new ListNode(4);
        
        // Print results
        printList(mergeKLists(test1));
        printList(mergeKLists(test2));
        printList(mergeKLists(test3));
        printList(mergeKLists(test4));
        printList(mergeKLists(test5));
    }
    
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
