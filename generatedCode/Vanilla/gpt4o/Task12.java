package Vanilla.openai;
public class Task12 {

    public static String highestScoringWord(String sentence) {
        String[] words = sentence.split(" ");
        int highestScore = 0;
        String highestScoringWord = "";

        for (String word : words) {
            int currentScore = 0;
            for (char c : word.toCharArray()) {
                currentScore += c - 'a' + 1;
            }
            if (currentScore > highestScore) {
                highestScore = currentScore;
                highestScoringWord = word;
            }
        }

        return highestScoringWord;
    }

    public static void main(String[] args) {
        System.out.println(highestScoringWord("abad zoo")); // Expected: "zoo"
        System.out.println(highestScoringWord("a b c")); // Expected: "c"
        System.out.println(highestScoringWord("hello world")); // Expected: "world"
        System.out.println(highestScoringWord("abc abc")); // Expected: "abc"
        System.out.println(highestScoringWord("quiet mood")); // Expected: "quiet"
    }
}