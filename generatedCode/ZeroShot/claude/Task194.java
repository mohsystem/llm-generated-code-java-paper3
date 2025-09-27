package ZeroShot.claude;

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
        
        if (word.length() != secret.length()) return -1;
        
        int matches = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == secret.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}

class Task194 {
    public String findSecretWord(String[] words, Master master) {
        for (int i = 0; i < 10 && words.length > 0; i++) {
            String guess = words[0];
            int matches = master.guess(guess);
            
            if (matches == 6) return guess;
            
            List<String> candidates = new ArrayList<>();
            for (String w : words) {
                if (getMatches(guess, w) == matches) {
                    candidates.add(w);
                }
            }
            words = candidates.toArray(new String[0]);
        }
        return "";
    }
    
    private int getMatches(String word1, String word2) {
        int matches = 0;
        for (int i = 0; i < word1.length(); i++) {
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
        String[] words3 = {"abcdef", "ghijkl", "abcdef"};
        Master master3 = new Master("abcdef", 10);
        System.out.println(solution.findSecretWord(words3, master3));
        
        // Test case 4
        String[] words4 = {"aaaaaa", "bbbbbb", "cccccc"};
        Master master4 = new Master("aaaaaa", 10);
        System.out.println(solution.findSecretWord(words4, master4));
        
        // Test case 5
        String[] words5 = {"abcdef"};
        Master master5 = new Master("abcdef", 10);
        System.out.println(solution.findSecretWord(words5, master5));
    }
}
