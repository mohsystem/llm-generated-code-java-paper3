package ourMethod.codestral;
public class Task26 {
    public static int findOdd(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {7},
                {0},
                {1, 1, 2},
                {0, 1, 0, 1, 0},
                {1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}
        };

        for (int[] testCase : testCases) {
            System.out.println("Array: " + Arrays.toString(testCase) + ", Result: " + findOdd(testCase));
        }
    }
}