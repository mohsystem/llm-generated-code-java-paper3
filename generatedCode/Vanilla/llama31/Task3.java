package Vanilla.llama31;
public class Task3 {
    public static boolean checkPangram(String s) {
        boolean[] is_true = new boolean[26];
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                is_true[s.charAt(i) - 'a'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (!is_true[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "The quick brown fox jumps over the lazy dog",
            "Abcdefghijklmnopqrstuvwxyz",
            "Pack my box with five dozen liquor jugs",
            "Hello, World!",
            "abcdefghijklmnopqrstuvwxyz"
        };
        for (String testCase : testCases) {
            System.out.println(checkPangram(testCase));
        }
    }
}