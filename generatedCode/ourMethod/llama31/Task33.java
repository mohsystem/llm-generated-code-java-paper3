package ourMethod.llama31;
public class Task33 {
    public static int queueTime(int[] customers, int n) {
        if (n >= customers.length) {
            return customers[0] == 0 ? 0 : findMax(customers);
        }
        int[] tills = new int[n];
        for (int i = 0; i < customers.length; i++) {
            int minIndex = findMinIndex(tills);
            tills[minIndex] += customers[i];
        }
        return findMax(tills);
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int findMinIndex(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(queueTime(new int[] {5, 3, 4}, 1)); // Should return 12
        System.out.println(queueTime(new int[] {10, 2, 3, 3}, 2)); // Should return 10
        System.out.println(queueTime(new int[] {2, 3, 10}, 2)); // Should return 12
    }
}