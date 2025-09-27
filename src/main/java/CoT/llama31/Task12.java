package CoT.llama31;
public class Task12 {
    public static String highestScoringWord(String inputString) {
        String[] words = inputString.split(" ");
        int maximumScore = 0;
        String maxScoreWord = "";

        for (String word : words) {
            int currScore = 0;
            for (char character : word.toCharArray()) {
                currScore += character - 'a' + 1;
            }
            if (currScore > maximumScore) {
                maximumScore = currScore;
                maxScoreWord = word;
            }
        }
        return maxScoreWord;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "abad abad abad",
            "abc def ghi",
            "xyz abc def",
            "a b c d e f g h i j k l m n o p q r s t u v w x y z",
            "aa bb cc dd"
        };

        for (String testCase : testCases) {
            System.out.println("Input: " + testCase);
            System.out.println("Highest Scoring Word: " + highestScoringWord(testCase));
            System.out.println();
        }
    }
}