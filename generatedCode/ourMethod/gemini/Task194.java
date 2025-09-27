package ourMethod.gemini;
import java.util.List;

class Master {
    public int guess(String word) {
        return -1; // Replace with actual implementation if needed
    }
}

public class Task194 {
    public void findSecretWord(String secret, List<String> wordlist, Master master) {
        int guesses = 0;
        for (String word : wordlist) {
            if (guesses >= wordlist.size()) break; // Avoid exceeding guesses by checking within loop
            int matches = master.guess(word);
            guesses++;
            if (matches == 6) {
                System.out.println("You guessed the secret word correctly.");
                return;
            }

        }
         System.out.println("Either you took too many guesses, or you did not find the secret word.");
    }


    public static void main(String[] args) {
        Task194 task = new Task194();
        Master master = new Master(); // Replace with mock/actual implementation

        // Test cases
        List<String> words1 = List.of("acckzz", "ccbazz", "eiowzz", "abcczz");
        task.findSecretWord("acckzz", words1, master);

        List<String> words2 = List.of("hamada", "khaled");
        task.findSecretWord("hamada", words2, master);


        List<String> words3 = List.of("hamada", "khaled","mohamed","ali");
        task.findSecretWord("mohamed", words3, master);

        List<String> words4 = List.of("hamada", "khaled","mohamed","ali","anas");
        task.findSecretWord("anas", words4, master);


        List<String> words5 = List.of("hamada", "khaled","mohamed","ali","anas","youssef");
        task.findSecretWord("youssef", words5, master);
    }
}