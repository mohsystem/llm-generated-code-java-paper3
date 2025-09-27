package CoT.llama31;
public class Task14 {
    public static int findMiddleIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (leftSum == totalSum - leftSum - arr[i]) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testCases[] = {
            {1, 2, 3, 4, 3, 2, 1},
            {1, 100, 50, -51, 1, 1},
            {20, 10, -80, 10, 10, 15, 35},
            {1, -1, 1, -1, 1, -1},
            {10, -10}
        };
        for (int[] testCase : testCases) {
            System.out.println("Array: " + java.util.Arrays.toString(testCase) + ", Index: " + findMiddleIndex(testCase));
        }
    }
}