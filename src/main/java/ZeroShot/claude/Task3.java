package ZeroShot.claude;

public class Task3 {
    public static boolean isPangram(String str) {
        str = str.toLowerCase();
        boolean[] mark = new boolean[26];
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                mark[ch - 'a'] = true;
            }
        }
        
        for (boolean b : mark) {
            if (!b) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String[] testCases = {
            "The quick brown fox jumps over the lazy dog",
            "Pack my box with five dozen liquor jugs",
            "This is not a pangram",
            "abcdefghijklmnopqrstuvwxyz",
            "The five boxing wizards jump quickly"
        };
        
        for (String test : testCases) {
            System.out.println("Input: " + test);
            System.out.println("Is Pangram: " + isPangram(test));
        }
    }
}
