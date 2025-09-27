package ourMethod.codestral;
import java.util.Arrays;

public class Task33 {
    public static int queueTime(int[] customers, int n) {
        int[] tills = new int[n];
        for (int i = 0; i < customers.length; i++) {
            int minIndex = findMinIndex(tills);
            tills[minIndex] += customers[i];
        }
        return Arrays.stream(tills).max().getAsInt();
    }

    private static int findMinIndex(int[] array) {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        System.out.println(queueTime(new int[]{5,3,4}, 1)); // Output: 12
        System.out.println(queueTime(new int[]{10,2,3,3}, 2)); // Output: 10
        System.out.println(queueTime(new int[]{2,3,10}, 2)); // Output: 12
    }
}