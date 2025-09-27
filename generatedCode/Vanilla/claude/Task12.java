package Vanilla.claude;

public class Task12 {
    public static String highestScoringWord(String str) {
        String[] words = str.split(" ");
        int maxScore = 0;
        String maxWord = "";
        
        for(String word : words) {
            int score = 0;
            for(char c : word.toCharArray()) {
                score += (c - 'a' + 1);
            }
            if(score > maxScore) {
                maxScore = score;
                maxWord = word;
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(highestScoringWord("man i need a taxi up to ubud")); // taxi
        System.out.println(highestScoringWord("what time are we climbing up to the volcano")); // volcano
        System.out.println(highestScoringWord("take me to semynak")); // semynak
        System.out.println(highestScoringWord("aa b")); // aa
        System.out.println(highestScoringWord("b aa")); // b
    }
}
