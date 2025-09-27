package ourMethod.gemini;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Task141 {
    public String reverseString(String input) {
        List<Character> charList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            charList.add(c);
        }
        Collections.reverse(charList);
        StringBuilder reversedString = new StringBuilder();
        for (char c : charList) {
            reversedString.append(c);
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        Task141 task = new Task141();

        String[] testCases = {
                "hello",
                "world",
                "12345",
                "racecar",
                ""
        };

        for (String testCase : testCases) {
            String reversed = task.reverseString(testCase);
            System.out.println("Input: " + testCase + ", Reversed: " + reversed);
        }
    }
}