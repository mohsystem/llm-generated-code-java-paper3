package CoT.gpt4o;
import java.util.Scanner;

public class Task104 {
    private static final int BUFFER_SIZE = 10;

    public static void main(String[] args) {
        testBuffer();
    }

    public static String bufferInput(String input) {
        if (input.length() > BUFFER_SIZE) {
            return input.substring(0, BUFFER_SIZE);
        }
        return input;
    }

    private static void testBuffer() {
        String[] testCases = {"short", "this is too long", "exactlyten", "1234567890", "overload!!!"};
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase + " => Buffered: " + bufferInput(testCase));
        }
    }
}