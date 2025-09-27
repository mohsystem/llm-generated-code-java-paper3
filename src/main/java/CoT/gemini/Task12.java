package CoT.gemini;
import java.util.Arrays;

public class Task12 {

    public static String highestScoringWord(String s) {
        String[] words = s.split(" ");
        String highestWord = "";
        int highestScore = 0;

        for (String word : words) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }

            if (score > highestScore) {
                highestScore = score;
                highestWord = word;
            }
        }

        return highestWord;
    }

    public static void main(String[] args) {
        String test1 = "man i need a taxi up to ubud";
        String test2 = "what time are we climbing up the volcano";
        String test3 = "take me to semynak";
        String test4 = "aa b";
        String test5 = "a aa";

        System.out.println("Test 1: " + highestScoringWord(test1)); // Expected: taxi
        System.out.println("Test 2: " + highestScoringWord(test2)); // Expected: volcano
        System.out.println("Test 3: " + highestScoringWord(test3)); // Expected: semynak
        System.out.println("Test 4: " + highestScoringWord(test4)); // Expected: b
        System.out.println("Test 5: " + highestScoringWord(test5)); // Expected: a

    }
}