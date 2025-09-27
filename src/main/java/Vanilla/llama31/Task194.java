package Vanilla.llama31;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Task194 {
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

    public void findSecretWord(String[] wordlist, Master master, int allowedGuesses) {
        for (int i = 0; i < allowedGuesses; i++) {
            String guess = wordlist[0];
            int match = master.guess(guess);
            if (match == 6) {
                System.out.println("You guessed the secret word correctly.");
                return;
            }
            String[] newWordlist = new String[wordlist.length];
            int count = 0;
            for (String word : wordlist) {
                if (match(word, guess) == match) {
                    newWordlist[count++] = word;
                }
            }
            wordlist = new String[count];
            System.arraycopy(newWordlist, 0, wordlist, 0, count);
        }
        System.out.println("Either you took too many guesses, or you did not find the secret word.");
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
//        Master master = new Master(); // Assume Master class is implemented

//        // Test case 1
//        String[] words1 = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
//        task.findSecretWord(words1, master, 10);
//
//        // Test case 2
//        String[] words2 = {"hamada", "khaled"};
//        task.findSecretWord(words2, master, 10);
    }
}