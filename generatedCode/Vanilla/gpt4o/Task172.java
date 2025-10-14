package Vanilla.openai;
public class Task172 {

    public static int countDistinctConcatSubstrings(String text) {
        int count = 0;
        int n = text.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j += 2) {
                int mid = (i + j + 1) / 2;
                if (text.substring(i, mid).equals(text.substring(mid, j + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDistinctConcatSubstrings("abcabcabc")); // 3
        System.out.println(countDistinctConcatSubstrings("leetcodeleetcode")); // 2
        System.out.println(countDistinctConcatSubstrings("aaaa")); // 3
        System.out.println(countDistinctConcatSubstrings("ababab")); // 3
        System.out.println(countDistinctConcatSubstrings("aabb")); // 0
    }
}