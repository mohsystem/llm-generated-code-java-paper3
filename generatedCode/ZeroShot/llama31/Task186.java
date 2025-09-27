package ZeroShot.llama31;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Task186 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private static ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case 1
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

        ListNode[] arr1 = {lists1[0], lists1[3], lists1[6]};
        ListNode result1 = mergeKLists(arr1);
        System.out.println("Test Case 1:");
        printList(result1);

        // Test case 2
        ListNode[] lists2 = {};
        ListNode result2 = mergeKLists(lists2);
        System.out.println("Test Case 2:");
        printList(result2);

        // Test case 3
        ListNode[] lists3 = {null};
        ListNode result3 = mergeKLists(lists3);
        System.out.println("Test Case 3:");
        printList(result3);

        // Test case 4
        ListNode[] lists4 = {
            new ListNode(1),
            new ListNode(2),
            new ListNode(3),
            new ListNode(4),
            new ListNode(5),
            new ListNode(6),
            new ListNode(7),
            new ListNode(8)
        };
        lists4[0].next = lists4[1];
        lists4[1].next = lists4[2];
        lists4[3].next = lists4[4];
        lists4[4].next = lists4[5];
        lists4[6].next = lists4[7];

        ListNode[] arr4 = {lists4[0], lists4[3], lists4[6]};
        ListNode result4 = mergeKLists(arr4);
        System.out.println("Test Case 4:");
        printList(result4);

        // Test case 5
        ListNode[] lists5 = {
            new ListNode(-10),
            new ListNode(-9),
            new ListNode(-8),
            new ListNode(-7),
            new ListNode(-6),
            new ListNode(-5),
            new ListNode(-4),
            new ListNode(-3)
        };
        lists5[0].next = lists5[1];
        lists5[1].next = lists5[2];
        lists5[3].next = lists5[4];
        lists5[4].next = lists5[5];
        lists5[6].next = lists5[7];

        ListNode[] arr5 = {lists5[0], lists5[3], lists5[6]};
        ListNode result5 = mergeKLists(arr5);
        System.out.println("Test Case 5:");
        printList(result5);
    }
}