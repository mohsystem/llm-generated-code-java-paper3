package ZeroShot.openai;
public class Task12 {
    public static String high(String s) {
        String[] words = s.split(" ");
        int maxScore = 0;
        String maxScoreWord = "";
        
        for (String word : words) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }
            if (score > maxScore) {
                maxScore = score;
                maxScoreWord = word;
            }
        }
        
        return maxScoreWord;
    }

    public static void main(String[] args) {
        System.out.println(high("abad bcad aced")); // Output: bcad
        System.out.println(high("hello world")); // Output: world
        System.out.println(high("this is a test")); // Output: this
        System.out.println(high("a bb ccc dddd")); // Output: dddd
        System.out.println(high("alpha beta gamma")); // Output: gamma
    }
}