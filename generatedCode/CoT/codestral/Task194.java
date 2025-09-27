package CoT.codestral;
// Java solution
import java.util.Arrays;
import java.util.List;

public class Task194 {
    interface Master {
        int guess(String word);
    }

    public String findSecretWord(String[] words, Master master) {
        for (int i = 0, x = 0; i < 10; ++i) {
            x = master.guess(words[i]);
            if (x == 6) return "You guessed the secret word correctly.";
            List<String> temp = new ArrayList<>();
            for (String word : words)
                if (matches(words[i], word) == x) temp.add(word);
            words = temp.toArray(new String[0]);
        }
        return "Either you took too many guesses, or you did not find the secret word.";
    }

    public int matches(String a, String b) {
        int matches = 0;
        for (int i = 0; i < 6; ++i)
            if (a.charAt(i) == b.charAt(i)) matches++;
        return matches;
    }

    public static void main(String[] args) {
        Task194 task = new Task194();
        Master master = word -> {
            // Implementation of Master.guess() depends on the specific context
            // For the purpose of this code, let's assume a simple implementation
            String secret = "acckzz";
            int matches = 0;
            for (int i = 0; i < 6; ++i)
                if (secret.charAt(i) == word.charAt(i)) matches++;
            return matches;
        };
        String[] words = {"acckzz","ccbazz","eiowzz","abcczz"};
        System.out.println(task.findSecretWord(words, master));
    }
}