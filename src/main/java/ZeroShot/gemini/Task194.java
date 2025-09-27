package ZeroShot.gemini;
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
        System.out.println(task194.findSecretWord("acckzz", words1, 10)); // Output: You guessed the secret word correctly.

        List<String> words2 = List.of("hamada", "khaled");
        System.out.println(task194.findSecretWord("hamada", words2, 10)); // Output: You guessed the secret word correctly.

        List<String> words3 = List.of("qwerty", "asdfgh", "zxcvbn");
        System.out.println(task194.findSecretWord("qwerty", words3, 2)); // Output: You guessed the secret word correctly.

        List<String> words4 = List.of("apple", "banana", "orange");
        System.out.println(task194.findSecretWord("grape", words4, 3)); // Output: Either you took too many guesses, or you did not find the secret word.

        List<String> words5 = List.of("abcdef", "ghijkl", "mnopqr", "stuvwx", "yz1234");
        System.out.println(task194.findSecretWord("abcdef", words5, 5)); // Output: You guessed the secret word correctly.



    }
}