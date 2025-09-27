package ourMethod.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Task186 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

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

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

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
            tail = node;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }

    private ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;

    }

    private int[] listToArray(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {

        Task186 task = new Task186();

        int[][][] testCases = {
                {{1, 4, 5}, {1, 3, 4}, {2, 6}},
                {},
                {{}},
                {{1}, {2}},
                {{-2, -1, -1}, {0}}
        };
        for (int[][] testCase : testCases) {

            ListNode[] lists = new ListNode[testCase.length];
            for (int i = 0; i < testCase.length; i++) {
                lists[i] = task.createList(testCase[i]);
            }

            ListNode mergedList = task.mergeKLists(lists);
            int[] result = task.listToArray(mergedList);

            System.out.println(Arrays.toString(result));

        }
    }
}