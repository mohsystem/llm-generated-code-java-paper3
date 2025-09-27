package CoT.claude;

class Master {
    private String secret;
    private int guesses;
    private int allowedGuesses;
    
    public Master(String secret, int allowedGuesses) {
        this.secret = secret;
        this.allowedGuesses = allowedGuesses;
        this.guesses = 0;
    }
    
    public int guess(String word) {
        guesses++;
        if (guesses > allowedGuesses) {
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
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int matches = master.guess(words[i]);
            if (matches == 6) {
                return "You guessed the secret word correctly.";
            }
        }
        return "Either you took too many guesses, or you did not find the secret word.";
    }
    
    public static void main(String[] args) {
        Task194 task = new Task194();
        
        // Test case 1
        String[] words1 = {"acckzz","ccbazz","eiowzz","abcczz"};
        Master master1 = new Master("acckzz", 10);
        System.out.println(task.findSecretWord(words1, master1));
        
        // Test case 2  
        String[] words2 = {"hamada","khaled"};
        Master master2 = new Master("hamada", 10);
        System.out.println(task.findSecretWord(words2, master2));
        
        // Test case 3
        String[] words3 = {"aaaaaa", "bbbbbb", "cccccc"};
        Master master3 = new Master("bbbbbb", 10);
        System.out.println(task.findSecretWord(words3, master3));
        
        // Test case 4
        String[] words4 = {"abcdef", "ghijkl"};
        Master master4 = new Master("ghijkl", 10);
        System.out.println(task.findSecretWord(words4, master4));
        
        // Test case 5
        String[] words5 = {"zzzzzz"};
        Master master5 = new Master("zzzzzz", 10);
        System.out.println(task.findSecretWord(words5, master5));
    }
}
