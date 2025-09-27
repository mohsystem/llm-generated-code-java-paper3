package ZeroShot.gemini;
import java.util.*;

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
        System.out.println(highestScoringWord("man i need a taxi up to ubud")); // taxi
        System.out.println(highestScoringWord("what time are we climbing up the volcano")); // volcano
        System.out.println(highestScoringWord("take me to semynak")); // semynak
        System.out.println(highestScoringWord("aa b")); // aa
        System.out.println(highestScoringWord("hello world")); // world
    }
}