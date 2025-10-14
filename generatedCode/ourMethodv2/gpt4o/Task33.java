package ourMethodv2.gpt4o;
import java.util.Arrays;

public class Task33 {
    public static int queueTime(int[] customers, int n) {
        int[] tills = new int[n];
        for (int time : customers) {
            tills[0] += time;
            Arrays.sort(tills);
        }
        return tills[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(queueTime(new int[]{5, 3, 4}, 1)); // 12
        System.out.println(queueTime(new int[]{10, 2, 3, 3}, 2)); // 10
        System.out.println(queueTime(new int[]{2, 3, 10}, 2)); // 12
        System.out.println(queueTime(new int[]{1, 2, 3, 4, 5}, 100)); // 5
        System.out.println(queueTime(new int[]{}, 1)); // 0
    }
}