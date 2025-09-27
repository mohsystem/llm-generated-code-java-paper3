package Vanilla.gemini;
import java.util.List;

class Master {
    private String secret;

    public Master(String secret) {
        this.secret = secret;
    }

    public int guess(String word) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (word.charAt(i) == secret.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}


public class Task194 {
    public String findSecretWord(String secret, List<String> words, int allowedGuesses) {
        Master master = new Master(secret);
        int guesses = 0;
        for (String word : words) {
            if (guesses >= allowedGuesses) {
                return "Either you took too many guesses, or you did not find the secret word.";
            }
            int matches = master.guess(word);
            guesses++;
            if (matches == 6) {
                return "You guessed the secret word correctly.";
            }
        }
        return "Either you took too many guesses, or you did not find the secret word.";

    }

    public static void main(String[] args) {
        Task194 task194 = new Task194();

        // Test cases
        List<String> words1 = List.of("acckzz", "ccbazz", "eiowzz", "abcczz");
        System.out.println(task194.findSecretWord("acckzz", words1, 10));

        List<String> words2 = List.of("hamada", "khaled");
        System.out.println(task194.findSecretWord("hamada", words2, 10));

        List<String> words3 = List.of("abcdef");
        System.out.println(task194.findSecretWord("abcdef", words3, 10));

        List<String> words4 = List.of("leetcode", "leetcod");
        System.out.println(task194.findSecretWord("leetcode", words4, 2));
        
        List<String> words5 = List.of("banana", "orange", "apple", "grape");
        System.out.println(task194.findSecretWord("orange", words5, 5));

    }
}