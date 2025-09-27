package ourMethod.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task3 {
    public static boolean isPangram(String str) {
        str = str.toLowerCase();
        Set<Character> alphabet = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
        for (char c : str.toCharArray()) {
            alphabet.remove(c);
        }
        return alphabet.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // True
        System.out.println(isPangram("This is not a pangram")); // False
        System.out.println(isPangram("1234567890")); // False
        System.out.println(isPangram("")); // False
        System.out.println(isPangram("The five boxing wizards jump quickly")); // True
    }
}