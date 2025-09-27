package Vanilla.gemini;
import java.util.*;

class Task12 {
    public String highestScoringWord(String s) {
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
        Task12 task = new Task12();
        System.out.println(task.highestScoringWord("man i need a taxi up to ubud")); // taxi
        System.out.println(task.highestScoringWord("what time are we climbing up the volcano")); // volcano
        System.out.println(task.highestScoringWord("take me to semynak")); // semynak
        System.out.println(task.highestScoringWord("aa b")); // aa
        System.out.println(task.highestScoringWord("a b c d")); // d

    }
}