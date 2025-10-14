package ourMethodv2.gpt4o;
import java.util.HashSet;

public class Task3 {

    public static boolean isPangram(String sentence) {
        if (sentence == null) {
            return false;
        }
        
        HashSet<Character> letters = new HashSet<>();
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letters.add(c);
            }
        }
        return letters.size() == 26;
    }

    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(isPangram("Hello World")); // false
        System.out.println(isPangram("Pack my box with five dozen liquor jugs.")); // true
        System.out.println(isPangram("1234567890")); // false
        System.out.println(isPangram("Sphinx of black quartz, judge my vow")); // true
    }
}