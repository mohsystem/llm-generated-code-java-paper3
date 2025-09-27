package ZeroShot.codestral;
public class Task12 {
    public static String high(String s) {
        String[] words = s.split(" ");
        String result = "";
        int maxScore = 0;

        for (String word : words) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }
            if (score > maxScore) {
                maxScore = score;
                result = word;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(high("man i need a taxi up to ubud")); // "taxi"
        System.out.println(high("what time are we climbing up the volcano")); // "volcano"
        System.out.println(high("take me to semynak")); // "semynak"
        System.out.println(high("massage yes massage yes massage")); // "massage"
        System.out.println(high("take two bintang and a dance please")); // "bintang" or "please"
    }
}