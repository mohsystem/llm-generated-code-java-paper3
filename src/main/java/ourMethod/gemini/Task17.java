package ourMethod.gemini;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task17 {

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }

        StringBuilder jadenCase = new StringBuilder();
        String[] words = phrase.split("\\s+"); // Split string by whitespace

        for (String word : words) {
            jadenCase.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }

        return jadenCase.toString().trim();
    }


    public static void main(String[] args) {
        List<String> testPhrases = Arrays.asList(
                "How can mirrors be real if our eyes aren't real",
                "most trees are blue",
                "All The Rules In This World Were Made By Someone No Smarter Than You. So Make Your Own.",
                "",
                null
        );
        List<String> expected = Arrays.asList(
                "How Can Mirrors Be Real If Our Eyes Aren't Real",
                "Most Trees Are Blue",
                "All The Rules In This World Were Made By Someone No Smarter Than You. So Make Your Own.",
                null,
                null);

        for (int i = 0; i < testPhrases.size(); i++) {
            String result = toJadenCase(testPhrases.get(i));
            System.out.println("Test case " + (i + 1) + ": " + (result == null ? "null" : result));
            System.out.println("Expected: " + (expected.get(i) == null ? "null" : expected.get(i)) );
            System.out.println(result.equals(expected.get(i)));

        }
    }
}