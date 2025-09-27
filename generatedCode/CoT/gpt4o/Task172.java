package CoT.gpt4o;
public class Task172 {
    public static int countDistinctConcatenatedSubstrings(String text) {
        int n = text.length();
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = text.substring(i, j);
                if (sub.length() % 2 == 0) {
                    int len = sub.length() / 2;
                    if (sub.substring(0, len).equals(sub.substring(len))) {
                        seen.add(sub);
                    }
                }
            }
        }
        
        return seen.size();
    }

    public static void main(String[] args) {
        System.out.println(countDistinctConcatenatedSubstrings("abcabcabc")); // Output: 3
        System.out.println(countDistinctConcatenatedSubstrings("leetcodeleetcode")); // Output: 2
        System.out.println(countDistinctConcatenatedSubstrings("aabbccdd")); // Output: 0
        System.out.println(countDistinctConcatenatedSubstrings("ababab")); // Output: 2
        System.out.println(countDistinctConcatenatedSubstrings("aa")); // Output: 1
    }
}