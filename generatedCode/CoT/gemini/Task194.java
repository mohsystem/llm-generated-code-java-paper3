package CoT.gemini;
import java.util.List;

class Master {
    public int guess(String word) {
        return -1; // Implementation not needed for this problem
    }
}

public class Task194 {
    public void findSecretWord(String secret, List<String> wordlist, Master master) {
        int guesses = 0;
        for (String word : wordlist) {
            if (guesses < 10) {
                int matches = master.guess(word);
                guesses++;
                if (matches == 6) {
                    return;
                }
            } else {
                break; // Stop if we exceed allowed guesses
            }
        }
    }

    public static void main(String[] args) {
        Task194 task = new Task194();
        Master master = new Master();

        // Test cases (replace with actual Master implementation for testing)
        List<String> words1 = List.of("acckzz", "ccbazz", "eiowzz", "abcczz");
        task.findSecretWord("acckzz", words1, master);

        List<String> words2 = List.of("hamada", "khaled");
        task.findSecretWord("hamada", words2, master);


        // Add more test cases here
    }
}