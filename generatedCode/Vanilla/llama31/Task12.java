package Vanilla.llama31;
public class Task12 {
    public static String highestScoringWord(String input) {
        String[] words = input.split(" ");
        String maxScoreWord = words[0];
        int maxScore = 0;

        for (String word : words) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }
            if (score > maxScore) {
                maxScore = score;
                maxScoreWord = word;
            }
        }
        return maxScoreWord;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "man i need a taxi up to ubud",
            "what time are we climbing up the volcano",
            "take me to semynak",
            "aa b",
            "a b c"
        };

        for (String testCase : testCases) {
            System.out.println("Highest scoring word: " + highestScoringWord(testCase));
        }
    }
}