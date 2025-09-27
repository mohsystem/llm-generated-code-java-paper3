package Vanilla.gpt4o;
import java.util.*;

public class Task173 {

    public static String longestDupSubstring(String s) {
        int n = s.length();
        int[] sa = new int[n];
        int[] rank = new int[n];
        int[] height = new int[n];
        
        for (int i = 0; i < n; i++) {
            sa[i] = i;
            rank[i] = s.charAt(i);
        }

        for (int len = 1; ; len <<= 1) {
            final int l = len;
            //todo no suitable method found for sort(int[],(a,b)->ran[...]: -1))
            //method Arrays.<T#1>sort(T#1[],Comparator<? super T#1>) is not applicable
            //(inference variable T#1 has incompatible bounds
            //equality constraints: int
            //lower bounds: Object)
            //method Arrays.<T#2>sort(T#2[],int,int,Comparator<? super T#2>) is not applicable
            //(cannot infer type-variable(s) T#2
            //(actual and formal argument lists differ in length))
            //where T#1,T#2 are type-variables:
            //T#1 extends Object declared in method <T#1>sort(T#1[],Comparator<? super T#1>)
            //T#2 extends Object declared in method <T#2>sort(T#2[],int,int,Comparator<? super T#2>)
//            Arrays.sort(sa, (a, b) -> rank[a] != rank[b] ? rank[a] - rank[b] : (a + l < n ? rank[a + l] : -1) - (b + l < n ? rank[b + l] : -1));
            int[] temp = new int[n];
            for (int i = 1; i < n; i++) {
                temp[sa[i]] = temp[sa[i - 1]] + (rank[sa[i]] != rank[sa[i - 1]] || (sa[i] + l < n ? rank[sa[i] + l] : -1) != (sa[i - 1] + l < n ? rank[sa[i - 1] + l] : -1) ? 1 : 0);
            }
            rank = temp;
            if (rank[sa[n - 1]] == n - 1) break;
        }

        for (int i = 0, h = 0; i < n; i++) {
            if (rank[i] > 0) {
                for (int j = sa[rank[i] - 1]; s.charAt(i + h) == s.charAt(j + h); ++h);
                height[rank[i]] = h;
                if (h > 0) --h;
            }
        }

        int maxLen = 0, start = 0;
        for (int i = 1; i < n; i++) {
            if (height[i] > maxLen) {
                maxLen = height[i];
                start = sa[i];
            }
        }
        
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana")); // "ana"
        System.out.println(longestDupSubstring("abcd"));   // ""
        System.out.println(longestDupSubstring("abcabc")); // "abc"
        System.out.println(longestDupSubstring("aabcaabc")); // "aabc"
        System.out.println(longestDupSubstring("abcdabcde")); // "abcd"
    }
}