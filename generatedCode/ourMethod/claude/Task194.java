package ourMethod.claude;

import java.util.*;

class Master {
    private String secret;
    private int guessCount = 0;
    private int allowedGuesses;
    private Set<String> wordSet;

    public Master(String secret, String[] words, int allowedGuesses) {
        this.secret = secret;
        this.allowedGuesses = allowedGuesses;
        this.wordSet = new HashSet<>(Arrays.asList(words));
    }

    public int guess(String word) {
        if (++guessCount > allowedGuesses) {
            throw new RuntimeException("Too many guesses");
        }
        if (!wordSet.contains(word)) return -1;
        
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (word.charAt(i) == secret.charAt(i)) matches++;
        }
        return matches;
    }
}

public class Task194 {
    public String findSecretWord(String secret, String[] words, int allowedGuesses) {
        Master master = new Master(secret, words, allowedGuesses);
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        
        while (!wordList.isEmpty()) {
            String guess = wordList.get(0);
            int matches = master.guess(guess);
            
            if (matches == 6) {
                return "You guessed the secret word correctly.";
            }
            
            List<String> newCandidates = new ArrayList<>();
            for (String word : wordList) {
                if (getMatches(guess, word) == matches) {
                    newCandidates.add(word);
                }
            }
            wordList = newCandidates;
        }
        
        return "Either you took too many guesses, or you did not find the secret word.";
    }
    
    private int getMatches(String word1, String word2) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) matches++;
        }
        return matches;
    }

    public static void main(String[] args) {
        Task194 solution = new Task194();
        
        // Test case 1
        String[] words1 = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        System.out.println(solution.findSecretWord("acckzz", words1, 10));
        
        // Test case 2
        String[] words2 = {"hamada", "khaled"};
        System.out.println(solution.findSecretWord("hamada", words2, 10));
        
        // Test case 3
        String[] words3 = {"abcdef", "ghijkl", "mnopqr"};
        System.out.println(solution.findSecretWord("abcdef", words3, 10));
        
        // Test case 4
        String[] words4 = {"aaaaaa", "bbbbbb"};
        System.out.println(solution.findSecretWord("aaaaaa", words4, 10));
        
        // Test case 5
        String[] words5 = {"xxxxxx"};
        System.out.println(solution.findSecretWord("xxxxxx", words5, 10));
    }
}
