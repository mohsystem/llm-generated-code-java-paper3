package Vanilla.codestral;
public class Task12 {
    public static String high(String s) {
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
        System.out.println(high("man i need a taxi up to ubud"));
        System.out.println(high("what time are we climbing up the volcano"));
        System.out.println(high("take me to semynak"));
        System.out.println(high("massage yes massage yes massage"));
        System.out.println(high("take two bintang and a dance please"));
    }
}