package CoT.claude;

public class Task30 {
    public static String longest(String s1, String s2) {
        boolean[] letters = new boolean[26];
        
        // Mark all present characters
        for(char c : s1.toCharArray()) {
            letters[c - 'a'] = true;
        }
        for(char c : s2.toCharArray()) {
            letters[c - 'a'] = true;
        }
        
        // Build result string
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(letters[i]) {
                result.append((char)(i + 'a'));
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Test case 1
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
        
        // Test case 2 
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
        
        // Test case 3
        System.out.println(longest("abc", "def"));
        
        // Test case 4
        System.out.println(longest("aaaa", "bbbb"));
        
        // Test case 5
        System.out.println(longest("", "xyz"));
    }
}
