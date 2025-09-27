package Vanilla.gemini;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Task19 {
    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() >= 5) {
                List<String> chars = Arrays.asList(word.split(""));
                Collections.reverse(chars);
                sb.append(String.join("", chars)).append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors")); // Output: Hey wollef sroirraw
        System.out.println(spinWords("This is a test")); // Output: This is a test
        System.out.println(spinWords("This is another test")); // Output: This is rehtona test
        System.out.println(spinWords("Hello")); // Output: olleH
        System.out.println(spinWords("What's up"));  // Output: What's up

    }
}