package ourMethodv2.gpt4o;
public class Task12 {
    public static String highestScoringWord(String input) {
        String[] words = input.split(" ");
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
        System.out.println(highestScoringWord("abad abc abcd")); // abcd
        System.out.println(highestScoringWord("hello world")); // world
        System.out.println(highestScoringWord("java is fun")); // java
        System.out.println(highestScoringWord("coding is great")); // coding
        System.out.println(highestScoringWord("a bb ccc")); // ccc
    }
}