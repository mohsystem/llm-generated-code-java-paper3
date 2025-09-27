package Vanilla.codestral;
public class Task45 {
    public static int processInput(int input) {
        return input * 2;
    }

    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 4, 5};
        for (int testCase : testCases) {
            try {
                int result = processInput(testCase);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}