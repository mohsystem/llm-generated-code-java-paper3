package Vanilla.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Task186 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            tail.next = current;
            tail = tail.next;

            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        Task186 task = new Task186();

        ListNode[] lists1 = new ListNode[]{createList(new int[]{1, 4, 5}), createList(new int[]{1, 3, 4}), createList(new int[]{2, 6})};
        ListNode result1 = task.mergeKLists(lists1);
        printList(result1); // Output: 1 1 2 3 4 4 5 6

        ListNode[] lists2 = new ListNode[]{};
        ListNode result2 = task.mergeKLists(lists2);
        printList(result2); // Output:

        ListNode[] lists3 = new ListNode[]{null};
        ListNode result3 = task.mergeKLists(lists3);
        printList(result3); // Output:

        ListNode[] lists4 = new ListNode[]{createList(new int[]{1}), createList(new int[]{})};
        ListNode result4 = task.mergeKLists(lists4);
        printList(result4);

        ListNode[] lists5 = new ListNode[]{createList(new int[]{-2,-1,-1,-1}), createList(new int[]{-2,-1,0})};
        ListNode result5 = task.mergeKLists(lists5);
        printList(result5);
    }


    public static ListNode createList(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}