package CoT.openai;
public class Task12 {

    public static String highestScoringWord(String input) {
        String[] words = input.split(" ");
        String highestWord = "";
        int highestScore = 0;
        
        for (String word : words) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += (c - 'a' + 1);
            }
            if (score > highestScore) {
                highestScore = score;
                highestWord = word;
            }
        }
        return highestWord;
    }

    public static void main(String[] args) {
        System.out.println(highestScoringWord("abad zxy")); // Output: abad
        System.out.println(highestScoringWord("hello world")); // Output: world
        System.out.println(highestScoringWord("java python csharp")); // Output: python
        System.out.println(highestScoringWord("a aa aaa aaaa")); // Output: aaaa
        System.out.println(highestScoringWord("abc xyz abc")); // Output: abc
    }
}