package CoT.gemini;

public class Task12 {

    /**
     * Calculates the score of a word based on alphabet positions.
     * a=1, b=2, etc.
     * @param word The word to score.
     * @return The integer score of the word.
     */
    private static int getScore(String word) {
        int score = 0;
        for (char c : word.toCharArray()) {
            score += c - 'a' + 1;
        }
        return score;
    }

    /**
     * Finds the highest scoring word in a string.
     * If scores are tied, the word appearing earliest is returned.
     * @param s The input string of words.
     * @return The highest scoring word.
     */
    public static String highestScoringWord(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] words = s.split(" ");
        String highestWord = "";
        int maxScore = -1;

        for (String word : words) {
            int currentScore = getScore(word);
            if (currentScore > maxScore) {
                maxScore = currentScore;
                highestWord = word;
            }
        }
        return highestWord;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "man i need a taxi up to ubud",
            "what time are we climbing up the volcano",
            "take me to semynak",
            "aa b",
            "b aa"
        };

        String[] expectedResults = {
            "taxi",
            "volcano",
            "semynak",
            "aa",
            "b"
        };
        
        for (int i = 0; i < testCases.length; i++) {
            String result = highestScoringWord(testCases[i]);
            System.out.println("Input: \"" + testCases[i] + "\"");
            System.out.println("Output: " + result);
            System.out.println("Expected: " + expectedResults[i]);
            System.out.println("--------------------");
        }
    }
}