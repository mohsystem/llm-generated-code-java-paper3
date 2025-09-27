package ourMethod.claude;

public class Task12 {
    public static String highestScoringWord(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        
        String[] words = str.trim().split("\\\\s+");
        if (words.length == 0) {
            return "";
        }
        
        String maxWord = words[0];
        int maxScore = getWordScore(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            int currentScore = getWordScore(words[i]);
            if (currentScore > maxScore) {
                maxScore = currentScore;
                maxWord = words[i];
            }
        }
        
        return maxWord;
    }
    
    private static int getWordScore(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        
        int score = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                score += (c - 'a' + 1);
            }
        }
        return score;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(highestScoringWord("man i need a taxi up to ubud")); // "taxi"
        System.out.println(highestScoringWord("what time are we climbing up to the volcano")); // "volcano"
        System.out.println(highestScoringWord("take me to semynak")); // "semynak"
        System.out.println(highestScoringWord("aa b")); // "aa"
        System.out.println(highestScoringWord("b aa")); // "b"
    }
}
