package ZeroShot.llama31;
public class Task3 {
    public static boolean checkPangram(String s) {
        boolean[] present = new boolean[26];
        for (char c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                present[c - 'a'] = true;
            }
        }
        for (boolean b : present) {
            if (!b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "The quick brown fox jumps over the lazy dog",
            "Hello, World!",
            "Pack my box with five dozen liquor jugs.",
            "How vexingly quick witted zebras jump!",
            "The five boxing wizards jump quickly."
        };
        for (String testCase : testCases) {
            System.out.println(checkPangram(testCase));
        }
    }
}