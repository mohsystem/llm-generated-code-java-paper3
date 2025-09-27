package Vanilla.gemini;
import java.util.HashSet;
import java.util.Set;

class Task4 {
    public static boolean isIsogram(String str) {
        if (str.isEmpty()) {
            return true;
        }
        Set<Character> seen = new HashSet<>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (seen.contains(c)) {
                return false;
            }
            seen.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
        System.out.println(isIsogram("")); // true
        System.out.println(isIsogram("isogram")); // true
    }
}