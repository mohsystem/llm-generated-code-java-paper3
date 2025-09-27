package CoT.gemini;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task19 {

    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() >= 5) {
                List<String> letters = Arrays.asList(word.split(""));
                Collections.reverse(letters);
                sb.append(String.join("", letters)).append(" ");
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
        System.out.println(spinWords("Welcome")); // Output: emocleW
        System.out.println(spinWords("to")); // Output: to
    }
}