package ZeroShot.gpt4o;
import java.util.HashSet;
import java.util.Set;

public class Task3 {
    public static boolean isPangram(String sentence) {
        Set<Character> alphabetSet = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetSet.add(c);
        }
        
        for (char c : sentence.toLowerCase().toCharArray()) {
            alphabetSet.remove(c);
            if (alphabetSet.isEmpty()) {
                return true;
            }
        }
        return alphabetSet.isEmpty();
    }
    
    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(isPangram("Hello World")); // false
        System.out.println(isPangram("Pack my box with five dozen liquor jugs.")); // true
        System.out.println(isPangram("Sphinx of black quartz, judge my vow.")); // true
        System.out.println(isPangram("A quick movement of the enemy will jeopardize five gunboats.")); // false
    }
}