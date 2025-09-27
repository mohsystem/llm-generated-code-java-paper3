package Vanilla.gemini;
import java.util.*;

public class Task173 {
    public String longestDupSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return "";
        }

        int[] suffixArray = buildSuffixArray(s);
        int[] lcp = buildLCP(s, suffixArray);

        int maxLen = 0;
        int startIndex = -1;

        for (int i = 1; i < n; i++) {
            if (lcp[i] > maxLen) {
                maxLen = lcp[i];
                startIndex = suffixArray[i];
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + maxLen);
    }

    private int[] buildSuffixArray(String s) {
        int n = s.length();
        int[] suffixArray = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArray[i] = i;
        }
        Arrays.sort(suffixArray, (a, b) -> s.substring(a).compareTo(s.substring(b)));
        return suffixArray;
    }

    private int[] buildLCP(String s, int[] suffixArray) {
        int n = s.length();
        int[] lcp = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[suffixArray[i]] = i;
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] == n - 1) {
                k = 0;
                continue;
            }
            int j = suffixArray[rank[i] + 1];
            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            lcp[rank[i] + 1] = k;
            if (k > 0) {
                k--;
            }
        }
        return lcp;
    }

    public static void main(String[] args) {
        Task173 task173 = new Task173();
        System.out.println(task173.longestDupSubstring("banana")); // Output: ana
        System.out.println(task173.longestDupSubstring("abcd"));   // Output: ""
        System.out.println(task173.longestDupSubstring("aa"));    // Output: a
        System.out.println(task173.longestDupSubstring("aabcaabdaab")); // Output: aab
        System.out.println(task173.longestDupSubstring("bananaana")); // Output: ana
    }
}