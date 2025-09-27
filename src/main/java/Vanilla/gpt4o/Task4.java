package Vanilla.gpt4o;
import java.util.HashSet;

public class Task4 {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        HashSet<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                return false;
            }
            charSet.add(c);
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