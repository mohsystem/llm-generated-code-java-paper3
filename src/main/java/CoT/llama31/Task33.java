package CoT.llama31;
public class Task33 {
    public static int queueTime(int[] customers, int n) {
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
        for (int time : tills) {
            if (time > maxTime) {
                maxTime = time;
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        System.out.println(queueTime(new int[] {5, 3, 4}, 1)); // should return 12
        System.out.println(queueTime(new int[] {10, 2, 3, 3}, 2)); // should return 10
        System.out.println(queueTime(new int[] {2, 3, 10}, 2)); // should return 12
        System.out.println(queueTime(new int[] {1, 2, 3, 4, 5}, 3)); // should return 6
        System.out.println(queueTime(new int[] {1, 1, 1, 1, 1}, 5)); // should return 1
    }
}