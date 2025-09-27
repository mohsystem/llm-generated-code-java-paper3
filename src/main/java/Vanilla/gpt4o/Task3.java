package Vanilla.gpt4o;
import java.util.HashSet;
import java.util.Set;

public class Task3 {
    public static boolean isPangram(String sentence) {
        Set<Character> alphabetSet = new HashSet<>();
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                alphabetSet.add(c);
            }
        }
        return alphabetSet.size() == 26;
    }

    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(isPangram("The quick brown fox jumps over the lazy")); // false
        System.out.println(isPangram("Pack my box with five dozen liquor jugs")); // true
        System.out.println(isPangram("Sphinx of black quartz, judge my vow")); // true
        System.out.println(isPangram("Hello, World!")); // false
    }
}