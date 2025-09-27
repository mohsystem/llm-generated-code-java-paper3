package CoT.gpt4o;
public class Task3 {
    public static boolean isPangram(String sentence) {
        boolean[] letters = new boolean[26];
        int index = 0;
        for (char ch : sentence.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                index = ch - 'a';
                letters[index] = true;
            }
        }
        for (boolean b : letters) {
            if (!b) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // True
        System.out.println(isPangram("Hello World!")); // False
        System.out.println(isPangram("Pack my box with five dozen liquor jugs.")); // True
        System.out.println(isPangram("Sphinx of black quartz, judge my vow.")); // True
        System.out.println(isPangram("Not a pangram sentence.")); // False
    }
}