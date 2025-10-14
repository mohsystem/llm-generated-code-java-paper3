package ourMethodv2.gpt4o;
public class Task172 {
    public static int countDistinctDoubleSubstrings(String text) {
        int n = text.length();
        Set<String> distinctSubstrings = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int len = 2; i + len <= n; len += 2) {
                String sub = text.substring(i, i + len);
                int mid = len / 2;
                if (sub.substring(0, mid).equals(sub.substring(mid))) {
                    distinctSubstrings.add(sub);
                }
            }
        }
        return distinctSubstrings.size();
    }

    public static void main(String[] args) {
        System.out.println(countDistinctDoubleSubstrings("abcabcabc")); // Output: 3
        System.out.println(countDistinctDoubleSubstrings("leetcodeleetcode")); // Output: 2
        System.out.println(countDistinctDoubleSubstrings("aaaaaa")); // Output: 3
        System.out.println(countDistinctDoubleSubstrings("ababab")); // Output: 1
        System.out.println(countDistinctDoubleSubstrings("abcd")); // Output: 0
    }
}