package Vanilla.claude;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Master {
    private String secret;
    private int guessCount;
    private int allowedGuesses;
    
    public Master(String secret, int allowedGuesses) {
        this.secret = secret;
        this.allowedGuesses = allowedGuesses;
        this.guessCount = 0;
    }
    
    public int guess(String word) {
        if (++guessCount > allowedGuesses) {
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

class Task194 {
    public String findSecretWord(String[] words, Master master) {
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        
        while (!wordList.isEmpty()) {
            String guess = wordList.get(0);
            int matches = master.guess(guess);
            
            if (matches == 6) {
                return "You guessed the secret word correctly.";
            }
            
            List<String> newWordList = new ArrayList<>();
            for (String word : wordList) {
                if (getMatches(guess, word) == matches) {
                    newWordList.add(word);
                }
            }
            wordList = newWordList;
        }
        return "Either you took too many guesses, or you did not find the secret word.";
    }
    
    private int getMatches(String word1, String word2) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
    
    public static void main(String[] args) {
        Task194 solution = new Task194();
        
        // Test case 1
        String[] words1 = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        Master master1 = new Master("acckzz", 10);
        System.out.println(solution.findSecretWord(words1, master1));
        
        // Test case 2
        String[] words2 = {"hamada", "khaled"};
        Master master2 = new Master("hamada", 10);
        System.out.println(solution.findSecretWord(words2, master2));
        
        // Test case 3
        String[] words3 = {"abcdef", "ghijkl"};
        Master master3 = new Master("abcdef", 10);
        System.out.println(solution.findSecretWord(words3, master3));
        
        // Test case 4
        String[] words4 = {"aaaaaa", "bbbbbb", "cccccc"};
        Master master4 = new Master("aaaaaa", 10);
        System.out.println(solution.findSecretWord(words4, master4));
        
        // Test case 5
        String[] words5 = {"xxxxxx"};
        Master master5 = new Master("xxxxxx", 10);
        System.out.println(solution.findSecretWord(words5, master5));
    }
}
