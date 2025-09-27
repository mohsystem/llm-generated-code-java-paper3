package Vanilla.codestral;
public class Task143 {
    public static void main(String[] args) {
        int[] testCase1 = {5, 3, 8, 1, 2};
        sortArray(testCase1);
        for (int num : testCase1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] testCase2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortArray(testCase2);
        for (int num : testCase2) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] testCase3 = {1, 2, 3, 4, 5};
        sortArray(testCase3);
        for (int num : testCase3) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] testCase4 = {5, 5, 5, 5, 5};
        sortArray(testCase4);
        for (int num : testCase4) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] testCase5 = {};
        sortArray(testCase5);
        for (int num : testCase5) {
            System.out.print(num + " ");
        }
    }

    public static void sortArray(int[] arr) {
        java.util.Arrays.sort(arr);
    }
}