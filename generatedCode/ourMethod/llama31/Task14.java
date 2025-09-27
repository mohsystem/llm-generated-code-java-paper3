package ourMethod.llama31;
public class Task14 {
    public static int findMiddleIndex(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int num : arr) {
            rightSum += num;
        }
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
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
            {},
            {1}
        };
        for (int[] testCase : testCases) {
            System.out.println("Array: " + java.util.Arrays.toString(testCase));
            System.out.println("Index: " + findMiddleIndex(testCase));
        }
    }
}