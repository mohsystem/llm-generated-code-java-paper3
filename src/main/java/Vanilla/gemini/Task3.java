package Vanilla.gemini;
import java.util.HashSet;
import java.util.Set;

class Task3 {
    public boolean checkPangram(String sentence) {
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
        System.out.println(task3.checkPangram("The quick brown fox jumps over the lazy dog")); // True
        System.out.println(task3.checkPangram("This is not a pangram.")); // False
        System.out.println(task3.checkPangram("Waltz, bad nymph, for quick jigs vex.")); // True
        System.out.println(task3.checkPangram("Glib jocks quiz nymph to vex dwarf.")); // True
        System.out.println(task3.checkPangram("Sphinx of black quartz, judge my vow.")); // True
    }
}