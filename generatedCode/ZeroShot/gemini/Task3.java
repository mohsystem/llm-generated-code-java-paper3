package ZeroShot.gemini;
import java.util.HashSet;
import java.util.Set;

class Task3 {
    public boolean isPangram(String sentence) {
        Set<Character> alphabet = new HashSet<>();
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                alphabet.add(c);
            }
        }
        return alphabet.size() == 26;
    }

    public static void main(String[] args) {
        Task3 task3 = new Task3();
        System.out.println(task3.isPangram("The quick brown fox jumps over the lazy dog")); // True
        System.out.println(task3.isPangram("This is not a pangram.")); // False
        System.out.println(task3.isPangram("Pack my box with five dozen liquor jugs.")); // True
        System.out.println(task3.isPangram("How quickly daft jumping zebras vex.")); // True
        System.out.println(task3.isPangram("Waltz, bad nymph, for quick jigs vex.")); // True

    }
}