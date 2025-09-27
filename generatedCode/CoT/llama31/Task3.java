package CoT.llama31;
public class Task3 {
    public static boolean isPangram(String input) {
        boolean[] isTrue = new boolean[26];
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                isTrue[ch - 'a'] = true;
            }
        }
        for (boolean b : isTrue) {
            if (!b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "The quick brown fox jumps over the lazy dog",
            "Hello World",
            "Abcdefghijklmnopqrstuvwxyz",
            "Pack my box with five dozen liquor jugs",
            "How vexingly quick daft zebras jump!"
        };
        for (String testCase : testCases) {
            System.out.println(testCase + ": " + isPangram(testCase));
        }
    }
}