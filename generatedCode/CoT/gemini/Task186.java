package CoT.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Task186 {
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
            tail = tail.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        Task186 solution = new Task186();

        // Test cases
        ListNode[] lists1 = createLists(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}});
        ListNode merged1 = solution.mergeKLists(lists1);
        print(merged1); // Expected: [1,1,2,3,4,4,5,6]

        ListNode[] lists2 = new ListNode[0];
        ListNode merged2 = solution.mergeKLists(lists2);
        print(merged2); // Expected: []

        ListNode[] lists3 = new ListNode[1];
        lists3[0] = null;
        ListNode merged3 = solution.mergeKLists(lists3);
        print(merged3); // Expected: []

        ListNode[] lists4 = createLists(new int[][]{{}});
        ListNode merged4 = solution.mergeKLists(lists4);
        print(merged4); // Expected: []

        ListNode[] lists5 = createLists(new int[][]{{-2, -1, -1, -1}, {-2}, {-1, 0, 1}});
        ListNode merged5 = solution.mergeKLists(lists5);
        print(merged5); // Expected: [-2,-2,-1,-1,-1,-1,0,1]

    }


    private static ListNode[] createLists(int[][] lists) {
        ListNode[] result = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            for (int num : lists[i]) {
                tail.next = new ListNode(num);
                tail = tail.next;
            }
            result[i] = dummy.next;
        }
        return result;
    }

    private static void print(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println(list);
    }
}