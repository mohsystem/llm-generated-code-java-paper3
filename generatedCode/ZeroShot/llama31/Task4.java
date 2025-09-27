package ZeroShot.llama31;
public class Task4 {
    // Function to check if a string is an isogram or not
    public static boolean isIsogram(String s) {
        int[] freq = new int[26];
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
        System.out.println(isIsogram("")); // true
        System.out.println(isIsogram("abcde")); // true
    }
}