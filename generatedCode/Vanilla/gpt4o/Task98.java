package Vanilla.openai;
import java.util.Scanner;

public class Task98 {
    public static Integer convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] testCases = {"123", "456", "abc", "789", "0"};
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase + " Output: " + convertToInt(testCase));
        }
    }
}