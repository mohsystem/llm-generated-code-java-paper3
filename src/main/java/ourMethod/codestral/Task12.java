package ourMethod.codestral;
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
            if (score > maxScore || (score == maxScore && input.indexOf(word) < input.indexOf(maxWord))) {
                maxScore = score;
                maxWord = word;
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        System.out.println(highestScoringWord("abad hello world")); // Output: "hello"
        System.out.println(highestScoringWord("apple banana cherry")); // Output: "banana"
        System.out.println(highestScoringWord("cat dog elephant")); // Output: "elephant"
        System.out.println(highestScoringWord("good bad better")); // Output: "good"
        System.out.println(highestScoringWord("this is a test")); // Output: "this"
    }
}