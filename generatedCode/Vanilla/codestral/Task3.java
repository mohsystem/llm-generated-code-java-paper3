package Vanilla.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task3 {
    public static boolean isPangram(String str) {
        Set<Character> alphabet = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }

        for (char c : str.toLowerCase().toCharArray()) {
            if (alphabet.contains(c)) {
                alphabet.remove(c);
            }
        }

        return alphabet.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(isPangram("This is not a pangram")); // false
        // add more test cases here
    }
}