package Vanilla.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task4 {
    public static boolean isIsogram(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        Set<Character> set = new HashSet<>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (!set.add(c)) {
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
        System.out.println(isIsogram(null)); // true
    }
}