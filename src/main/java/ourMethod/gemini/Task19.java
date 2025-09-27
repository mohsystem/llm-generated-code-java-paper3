package ourMethod.gemini;
import java.util.Arrays;

class Task19 {
    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                sb.append(new StringBuilder(words[i]).reverse().toString());
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Task19 task19 = new Task19();
        String[] testCases = {
                "Hey fellow warriors",
                "This is a test",
                "This is another test",
                "Hello",
                "What's the story morning glory?"
        };
        String[] expectedOutputs = {
                "Hey wollef sroirraw",
                "This is a test",
                "This is rehtona test",
                "Hello",
                "What's the yrrots gninrom yrolg?"
        };

        for (int i = 0; i < testCases.length; i++) {
            String result = task19.spinWords(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": \"" + testCases[i] + "\"");
            System.out.println("Expected output: \"" + expectedOutputs[i] + "\"");
            System.out.println("Actual output: \"" + result + "\"");
            System.out.println(result.equals(expectedOutputs[i]) ? "PASS" : "FAIL");
            System.out.println();
        }

    }
}