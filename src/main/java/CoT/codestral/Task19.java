package CoT.codestral;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task19 {
    public static String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(word -> word.length() >= 5 ? new StringBuilder(word).reverse().toString() : word)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors")); // "Hey wollef sroirraw"
        System.out.println(spinWords("This is a test")); // "This is a test"
        System.out.println(spinWords("This is another test")); // "This is rehtona test"
    }
}