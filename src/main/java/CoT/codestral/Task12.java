package CoT.codestral;
public class Task12 {
    public static String highestScoringWord(String s) {
        String[] words = s.split(" ");
        int maxScore = 0;
        String maxWord = "";
        for (String word : words) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }
            if (score > maxScore) {
                maxScore = score;
                maxWord = word;
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        System.out.println(highestScoringWord("abc def ghi")); // Output: "ghi"
        System.out.println(highestScoringWord("abc zyx def")); // Output: "zyx"
        System.out.println(highestScoringWord("abc abd def")); // Output: "abc"
        System.out.println(highestScoringWord("aa b")); // Output: "aa"
        System.out.println(highestScoringWord("bb ddd zzzz")); // Output: "bb"
    }
}