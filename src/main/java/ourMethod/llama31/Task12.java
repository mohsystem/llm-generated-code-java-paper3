package ourMethod.llama31;
public class Task12 {
    public static String highestScoringWord(String input) {
        String[] words = input.split(" ");
        String maxScoreWord = words[0];
        int maxScore = calculateWordScore(maxScoreWord);

        for (int i = 1; i < words.length; i++) {
            int currentScore = calculateWordScore(words[i]);
            if (currentScore > maxScore) {
                maxScoreWord = words[i];
                maxScore = currentScore;
            }
        }

        return maxScoreWord;
    }

    public static int calculateWordScore(String word) {
        int score = 0;
        for (char c : word.toCharArray()) {
            score += c - 'a' + 1;
        }
        return score;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "man i need a taxi up to ubud",
            "what time are we climbing up the volcano",
            "take me to semynak",
            "aa b c d e f g h i j k l m n o p q r s t u v w x y z",
            "abcdefghijklmnopqrstuvwxyz"
        };

        for (String testCase : testCases) {
            System.out.println("Highest scoring word: " + highestScoringWord(testCase));
        }
    }
}