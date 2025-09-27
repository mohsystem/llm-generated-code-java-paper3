package CoT.llama31;
public class Task194 {

    static  class Master {
        private String secret;
        private int guesses;
        private int allowedGuesses;

        public Master() {

        }
        public Master(String secret, int allowedGuesses) {
            this.secret = secret;
            this.allowedGuesses = allowedGuesses;
            this.guesses = 0;
        }

        public int guess(String word) {
            guesses++;
            if (guesses > allowedGuesses) {
                throw new RuntimeException("Too many guesses");
            }

            int matches = 0;
            for (int i = 0; i < 6; i++) {
                if (word.charAt(i) == secret.charAt(i)) {
                    matches++;
                }
            }
            return matches;
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
            // Filter words based on the number of matches
            String[] newWordlist = new String[wordlist.length];
            int count = 0;
            for (String word : wordlist) {
                if (matchWord(guess, word) == match) {
                    newWordlist[count++] = word;
                }
            }
            String[] temp = new String[count];
            System.arraycopy(newWordlist, 0, temp, 0, count);
            wordlist = temp;
        }
        System.out.println("Either you took too many guesses, or you did not find the secret word.");
    }

    public int matchWord(String word1, String word2) {
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
        Master master = new Master(); // Assume Master class is defined elsewhere
        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        int allowedGuesses = 10;
        task.findSecretWord(words, master, allowedGuesses);

        words = new String[] {"hamada", "khaled"};
        allowedGuesses = 10;
        task.findSecretWord(words, master, allowedGuesses);
    }
}