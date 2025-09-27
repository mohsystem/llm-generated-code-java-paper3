package ourMethod.gemini;
import java.util.Arrays;

public class Task12 {

    public static String high(String s) {
        String[] words = s.split(" ");
        String highestWord = "";
        int highestScore = 0;

        for (String word : words) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += (c - 'a' + 1);
            }
            if (score > highestScore) {
                highestScore = score;
                highestWord = word;
            }
        }
        return highestWord;
    }

    public static void main(String[] args) {
        System.out.println(high("man i need a taxi up to ubud")); // taxi
        System.out.println(high("what time are we climbing up the volcano")); // volcano
        System.out.println(high("take me to semynak")); // semynak
        System.out.println(high("aa b")); // aa
        System.out.println(high("b aa")); // b
    }
}