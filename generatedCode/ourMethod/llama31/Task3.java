package ourMethod.llama31;
public class Task3 {
    public static boolean isPangram(String input) {
        boolean[] alphabet = new boolean[26];
        input = input.toLowerCase();
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                alphabet[c - 'a'] = true;
            }
        }
        for (boolean b : alphabet) {
            if (!b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "The quick brown fox jumps over the lazy dog",
            "Hello, World!",
            "Pack my box with five dozen liquor jugs.",
            "How vexingly quick daft zebras jump!",
            "The five boxing wizards jump quickly."
        };

        for (String testCase : testCases) {
            System.out.println(testCase + ": " + isPangram(testCase));
        }
    }
}