package Vanilla.llama31;
class Task194 {
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
        Master master = new Master(); // Assume Master class is implemented

        // Test case 1
        String[] words1 = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        task.findSecretWord(words1, master, 10);

        // Test case 2
        String[] words2 = {"hamada", "khaled"};
        task.findSecretWord(words2, master, 10);
    }
}