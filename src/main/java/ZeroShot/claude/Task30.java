package ZeroShot.claude;

public class Task30 {
    public static String longest(String s1, String s2) {
        boolean[] seen = new boolean[26];
        StringBuilder result = new StringBuilder();
        
        // Mark all characters present in both strings
        for(char c : (s1 + s2).toCharArray()) {
            seen[c - 'a'] = true;
        }
        
        // Build result string with unique sorted characters
        for(int i = 0; i < 26; i++) {
            if(seen[i]) {
                result.append((char)(i + 'a'));
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
        System.out.println(longest("aretheyhere", "yestheyarehere")); // "aehrsty"
        System.out.println(longest("loopingisfunbutdangerous", "lessdangerousthancoding")); // "abcdefghilnoprstu"
        System.out.println(longest("inmanylanguages", "theresapairoffunctions")); // "acefghilmnoprstuy"
    }
}
