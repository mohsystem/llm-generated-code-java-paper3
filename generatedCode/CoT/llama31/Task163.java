package CoT.llama31;
public class Task163 {
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 5, 6, 7, 8, 9},
            {1, 2, 3, 10, 11, 15},
            {5, 4, 2, 1},
            {3, 5, 7, 10, 15},
            {1, 3, 5, 7, 9}
        };

        for (int[] testCase : testCases) {
            System.out.println("longestRun(" + arrayToString(testCase) + ") ➞ " + longestRun(testCase));
        }
    }

    public static int longestRun(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return 1;

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        return Math.max(maxLength, currentLength);
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}