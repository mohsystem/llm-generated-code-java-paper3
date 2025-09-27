package ourMethod.gemini;
import java.util.HashSet;
import java.util.Set;

class Task3 {
    public boolean isPangram(String sentence) {
        Set<Character> alphabet = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }

        String lowerCaseSentence = sentence.toLowerCase();
        for (int i = 0; i < lowerCaseSentence.length(); i++) {
            char c = lowerCaseSentence.charAt(i);
            if (Character.isLetter(c)) {
                alphabet.remove(c);
            }
        }

        return alphabet.isEmpty();
    }

    public static void main(String[] args) {
        Task3 task3 = new Task3();
        String[] testCases = {
                "The quick brown fox jumps over the lazy dog",
                "This is not a pangram",
                "abcdefghijklmnopqrstuvwxyz",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()",
                "The five boxing wizards jump quickly."
        };
        boolean[] expectedResults = {true, false, true, true, true};

        for (int i = 0; i < testCases.length; i++) {
            boolean result = task3.isPangram(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": \"" + testCases[i] + "\"");
            System.out.println("Expected: " + expectedResults[i] + ", Actual: " + result);
            System.out.println(result == expectedResults[i] ? "Pass" : "Fail");
            System.out.println();
        }

    }

}