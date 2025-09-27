package ourMethod.codestral;
import java.util.List;

class Master {
    // Implementation of Master.guess is not provided
    public int guess(String word) {
        // To be implemented
        return 0;
    }
}

public class Task194 {
    public String findSecretWord(String[] words, Master master) {
        for (int i = 0; i < 10; i++) {
            int guess = master.guess(words[i]);
            if (guess == 6) {
                return "You guessed the secret word correctly.";
            }
        }
        return "Either you took too many guesses, or you did not find the secret word.";
    }

    public static void main(String[] args) {
        Task194 task = new Task194();
        Master master = new Master();

        String[] words1 = {"acckzz","ccbazz","eiowzz","abcczz"};
        String secret1 = "acckzz";
        int allowedGuesses1 = 10;
        System.out.println(task.findSecretWord(words1, master));

        String[] words2 = {"hamada","khaled"};
        String secret2 = "hamada";
        int allowedGuesses2 = 10;
        System.out.println(task.findSecretWord(words2, master));
    }
}