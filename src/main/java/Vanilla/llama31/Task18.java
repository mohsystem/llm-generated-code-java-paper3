package Vanilla.llama31;
public class Task18 {
    public static void main(String[] args) {
        int[][] testCases = {
            {0, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 1}
        };

        for (int[] testCase : testCases) {
            System.out.println("Testing: " + arrayToString(testCase) + " ==> " + binaryArrayToInt(testCase));
        }
    }

    public static int binaryArrayToInt(int[] binaryArray) {
        int result = 0;
        for (int bit : binaryArray) {
            result = (result << 1) | bit;
        }
        return result;
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i);
        }
        return sb.toString();
    }
}