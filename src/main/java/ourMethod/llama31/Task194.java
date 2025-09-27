package ourMethod.llama31;

import java.util.ArrayList;
import java.util.List;

public class Task194 {
    public void findSecretWord(String[] wordlist, Master master, int allowedGuesses) {
        for (int i = 0; i < allowedGuesses; i++) {
            String guess = wordlist[0];
            int match = master.guess(guess);
            if (match == 6) {
                System.out.println("You guessed the secret word correctly.");
                return;
            }
            // Filter words based on the number of matches
            String[] newWordlist = filterWords(wordlist, guess, match);
            wordlist = newWordlist;
        }
        System.out.println("Either you took too many guesses, or you did not find the secret word.");
    }

    private String[] filterWords(String[] wordlist, String guess, int match) {
        List<String> newWordlist = new ArrayList<>();
        for (String word : wordlist) {
            if (match(word, guess) == match) {
                newWordlist.add(word);
            }
        }
        return newWordlist.toArray(new String[0]);
    }

    private int match(String word1, String word2) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        Task194 task = new Task194();
        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        Master master = new Master("acckzz");
        task.findSecretWord(words, master, 10);

        words = new String[] {"hamada", "khaled"};
        master = new Master("hamada");
        task.findSecretWord(words, master, 10);
    }
}

class Master {
    private String secret;

    public Master(String secret) {
        this.secret = secret;
    }

    public int guess(String word) {
        return match(secret, word);
    }

    private int match(String word1, String word2) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}