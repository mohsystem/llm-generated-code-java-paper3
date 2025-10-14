package ourMethod.openai;
public class Task3 {
    public static boolean isPangram(String input) {
        input = input.toLowerCase();
        boolean[] alphabet = new boolean[26];
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            if ('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
                index = input.charAt(i) - 'a';
                alphabet[index] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (!alphabet[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // True
        System.out.println(isPangram("Hello World!")); // False
        System.out.println(isPangram("Pack my box with five dozen liquor jugs")); // True
        System.out.println(isPangram("Sphinx of black quartz, judge my vow")); // True
        System.out.println(isPangram("Not a pangram")); // False
    }
}