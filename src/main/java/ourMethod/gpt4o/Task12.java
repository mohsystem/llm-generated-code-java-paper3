package ourMethod.gpt4o;
public class Task12 {
    public static String highestScoringWord(String sentence) {
        String[] words = sentence.split(" ");
        int highestScore = 0;
        String highestWord = "";

        for (String word : words) {
            int currentScore = 0;
            for (char c : word.toCharArray()) {
                currentScore += c - 'a' + 1;
            }
            if (currentScore > highestScore) {
                highestScore = currentScore;
                highestWord = word;
            }
        }
        return highestWord;
    }

    public static void main(String[] args) {
        System.out.println(highestScoringWord("abad abc abcd"));
        System.out.println(highestScoringWord("a aa aaa"));
        System.out.println(highestScoringWord("hello world"));
        System.out.println(highestScoringWord("test testing tester"));
        System.out.println(highestScoringWord("score scoring scored"));
    }
}