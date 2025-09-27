package ZeroShot.codestral;
class Master {
    private String secret;

    public Master(String secret) {
        this.secret = secret;
    }

    public int guess(String word) {
        int matches = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == secret.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}

public class Task194 {
    public static void guessSecretWord(String[] words, int allowedGuesses, String secret) {
        Master master = new Master(secret);
        for (int i = 0; i < allowedGuesses; i++) {
            String guess = words[(int) (Math.random() * words.length)];
            int matches = master.guess(guess);
            if (matches == 6) {
                System.out.println("You guessed the secret word correctly.");
                return;
            }
        }
        System.out.println("Either you took too many guesses, or you did not find the secret word.");
    }

    public static void main(String[] args) {
        guessSecretWord(new String[]{"acckzz","ccbazz","eiowzz","abcczz"}, 10, "acckzz");
        guessSecretWord(new String[]{"hamada","khaled"}, 10, "hamada");
    }
}