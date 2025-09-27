package CoT.llama31;
public class Task146 {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCase1 = {1, 2, 3, 5};
        int[] testCase2 = {1, 2, 4, 5};
        int[] testCase3 = {1, 3, 4, 5};
        int[] testCase4 = {2, 3, 4, 5};
        int[] testCase5 = {1, 2, 3, 4};

        System.out.println("Missing number in testCase1: " + findMissingNumber(testCase1));
        System.out.println("Missing number in testCase2: " + findMissingNumber(testCase2));
        System.out.println("Missing number in testCase3: " + findMissingNumber(testCase3));
        System.out.println("Missing number in testCase4: " + findMissingNumber(testCase4));
        System.out.println("Missing number in testCase5: " + findMissingNumber(testCase5));
    }
}