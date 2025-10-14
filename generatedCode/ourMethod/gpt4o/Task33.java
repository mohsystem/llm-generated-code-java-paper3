package ourMethod.openai;
public class Task33 {
    public static int queueTime(int[] customers, int n) {
        if (customers == null || customers.length == 0 || n <= 0) {
            return 0;
        }
        int[] tills = new int[n];
        for (int time : customers) {
            int minIndex = 0;
            for (int i = 1; i < n; i++) {
                if (tills[i] < tills[minIndex]) {
                    minIndex = i;
                }
            }
            tills[minIndex] += time;
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
        System.out.println(queueTime(new int[]{}, 1)); // 0
        System.out.println(queueTime(new int[]{1, 2, 3, 4, 5}, 100)); // 5
    }
}