package ourMethod.claude;

public class Task30 {
    public static String longest(String s1, String s2) {
        // Combine strings and convert to char array
        String combined = s1 + s2;
        boolean[] seen = new boolean[26]; 
        
        // Mark each character as seen
        for (char c : combined.toCharArray()) {
            seen[c - 'a'] = true;
        }
        
        // Build result string with unique chars
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (seen[i]) {
                result.append((char)(i + 'a'));
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz" 
        System.out.println(longest("aretheyhere", "yestheyarehere")); // "aehrsty"
        System.out.println(longest("loopingisfunbutdangerous", "lessdangerousthancoding")); // "abcdefghilnoprstu"
        System.out.println(longest("inmanylanguages", "theresapairoffunctions")); // "acefghilmnoprstuy"
    }
}
