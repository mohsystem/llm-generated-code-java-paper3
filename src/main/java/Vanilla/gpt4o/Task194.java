package Vanilla.gpt4o;
import java.util.*;

public class Task194 {
    static class Master {
        private String secret;
        private Set<String> wordSet;
        private int allowedGuesses;
        private int guessCount = 0;

        public Master(String secret, String[] words, int allowedGuesses) {
            this.secret = secret;
            this.wordSet = new HashSet<>(Arrays.asList(words));
            this.allowedGuesses = allowedGuesses;
        }

        public int guess(String word) {
            guessCount++;
            if (guessCount > allowedGuesses) {
                System.out.println("Either you took too many guesses, or you did not find the secret word.");
                return -1;
            }
            if (!wordSet.contains(word)) {
                return -1;
            }
            int matchCount = 0;
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == word.charAt(i)) {
                    matchCount++;
                }
            }
            if (matchCount == secret.length()) {
                System.out.println("You guessed the secret word correctly.");
            }
            return matchCount;
        }
    }

    public static void findSecretWord(String[] words, Master master) {
        int matches;
        for (String word : words) {
            matches = master.guess(word);
            if (matches == words[0].length()) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        String[] words1 = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        Master master1 = new Master("acckzz", words1, 10);
        findSecretWord(words1, master1);

        String[] words2 = {"hamada", "khaled"};
        Master master2 = new Master("hamada", words2, 10);
        findSecretWord(words2, master2);

        String[] words3 = {"orange", "banana", "grapee", "apples"};
        Master master3 = new Master("banana", words3, 10);
        findSecretWord(words3, master3);

        String[] words4 = {"abcdef", "ghijkl", "mnopqr", "stuvwx"};
        Master master4 = new Master("mnopqr", words4, 10);
        findSecretWord(words4, master4);

        String[] words5 = {"aaaaaa", "bbbbbb", "cccccc", "dddddd"};
        Master master5 = new Master("cccccc", words5, 10);
        findSecretWord(words5, master5);
    }
}