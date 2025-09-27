package ZeroShot.gpt4o;
import java.util.PriorityQueue;

public class Task33 {
    public static int queueTime(int[] customers, int n) {
        PriorityQueue<Integer> tills = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            tills.add(0);
        }
        for (int time : customers) {
            int current = tills.poll();
            tills.add(current + time);
        }
        int maxTime = 0;
        for (int tillTime : tills) {
            if (tillTime > maxTime) {
                maxTime = tillTime;
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        System.out.println(queueTime(new int[]{5, 3, 4}, 1)); // 12
        System.out.println(queueTime(new int[]{10, 2, 3, 3}, 2)); // 10
        System.out.println(queueTime(new int[]{2, 3, 10}, 2)); // 12
        System.out.println(queueTime(new int[]{1, 2, 3, 4, 5}, 1)); // 15
        System.out.println(queueTime(new int[]{}, 1)); // 0
    }
}