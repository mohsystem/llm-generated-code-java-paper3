package Vanilla.llama31;
public class Task4 {
    public static boolean isIsogram(String s) {
        s = s.toLowerCase();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
        System.out.println(isIsogram("")); // true
        System.out.println(isIsogram("a")); // true
    }
}