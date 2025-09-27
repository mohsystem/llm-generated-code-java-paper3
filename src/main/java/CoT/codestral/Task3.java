package CoT.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task3 {
    public static boolean isPangram(String input) {
        Set<Character> alphabet = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }

        input = input.toLowerCase();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                alphabet.remove(c);
            }
        }

        return alphabet.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(isPangram("Hello, World!")); // false
        System.out.println(isPangram("ABCDEFGHIJKLMNOPQRSTUVWXYZ")); // true
        System.out.println(isPangram("1234567890")); // false
        System.out.println(isPangram("The5 quick brown fox jumps over the lazy dog")); // true
    }
}