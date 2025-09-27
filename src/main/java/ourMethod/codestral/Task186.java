package ourMethod.codestral;
// Define the ListNode class for linked list nodes
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Define the Solution1 class
  class Solution1 {
    // Define the mergeKLists method
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: if the lists array is null or empty, return null
        if (lists == null || lists.length == 0) return null;

        // Start merging the lists from the first list
        ListNode result = lists[0];

        // Iterate through the rest of the lists
        for (int i = 1; i < lists.length; i++) {
            // Merge the current list with the result list
            result = mergeTwoLists(result, lists[i]);
        }

        // Return the merged list
        return result;
    }

    // Define the mergeTwoLists method to merge two sorted linked lists
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to serve as the head of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Iterate through both lists
        while (l1 != null && l2 != null) {
            // If the value of l1 is less than or equal to the value of l2, append l1 to the merged list
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            // Otherwise, append l2 to the merged list
            else {
                current.next = l2;
                l2 = l2.next;
            }
            // Move to the next node in the merged list
            current = current.next;
        }

        // If there are remaining nodes in l1, append them to the merged list
        if (l1 != null) current.next = l1;
        // If there are remaining nodes in l2, append them to the merged list
        else current.next = l2;

        // Return the head of the merged list
        return dummy.next;
    }
}

// Define the main class for testing
public class Task186 {
    public static void main(String[] args) {
        // Test case 1
        ListNode[] lists1 = {
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6))
        };
        Solution1 solution = new Solution1();
        ListNode result1 = solution.mergeKLists(lists1);
        // Print the merged list
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
        System.out.println();

        // Test case 2
        ListNode[] lists2 = {};
        ListNode result2 = solution.mergeKLists(lists2);
        // Print the merged list
        if (result2 == null) System.out.println("[]");

        // Test case 3
        ListNode[] lists3 = {null};
        ListNode result3 = solution.mergeKLists(lists3);
        // Print the merged list
        if (result3 == null) System.out.println("[]");
    }
}