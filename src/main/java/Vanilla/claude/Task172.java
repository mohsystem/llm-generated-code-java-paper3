package Vanilla.claude;

class Task172 {
    public static int distinctSubstrings(String text) {
        int n = text.length();
        int count = 0;
        
        for(int len = 2; len <= n; len += 2) {
            for(int i = 0; i <= n - len; i++) {
                String sub = text.substring(i, i + len);
                if(isConcat(sub)) count++;
            }
        }
        return count;
    }
    
    private static boolean isConcat(String str) {
        int n = str.length();
        if(n % 2 != 0) return false;
        
        String first = str.substring(0, n/2);
        String second = str.substring(n/2);
        return first.equals(second);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(distinctSubstrings("abcabcabc")); // 3
        System.out.println(distinctSubstrings("leetcodeleetcode")); // 2
        System.out.println(distinctSubstrings("aa")); // 1
        System.out.println(distinctSubstrings("abcd")); // 0
        System.out.println(distinctSubstrings("aabaabaa")); // 4
    }
}
