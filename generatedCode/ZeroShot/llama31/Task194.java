package ZeroShot.llama31;
public class Task194 {
    public void findSecretWord(String[] wordlist, Master master, int allowedGuesses) {
        for (int i = 0; i < allowedGuesses; i++) {
            String guess = wordlist[0];
            int match = master.guess(guess);
            if (match == 6) {
                System.out.println("You guessed the secret word correctly.");
                return;
            }
            // Filter words based on the match
            String[] newWordlist = new String[wordlist.length];
            int count = 0;
            for (String word : wordlist) {
                if (match(word, guess) == match) {
                    newWordlist[count++] = word;
                }
            }
            String[] temp = new String[count];
            System.arraycopy(newWordlist, 0, temp, 0, count);
            wordlist = temp;
        }
        System.out.println("Either you took too many guesses, or you did not find the secret word.");
    }

    private int match(String word1, String word2) {
        int match = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                match++;
            }
        }
        return match;
    }

    public static void main(String[] args) {
        Task194 task = new Task194();
        Master master = new Master(); // Assuming Master class is implemented elsewhere
        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        task.findSecretWord(words, master, 10);

        words = new String[] {"hamada", "khaled"};
        task.findSecretWord(words, master, 10);
    }
}

class Master {
    private String secret;

    public Master(String secret) {
        this.secret = secret;
    }

    public int guess(String word) {
        int match = 0;
        for (int i = 0; i < 6; i++) {
            if (word.charAt(i) == secret.charAt(i)) {
                match++;
            }
        }
        return match;
    }
}