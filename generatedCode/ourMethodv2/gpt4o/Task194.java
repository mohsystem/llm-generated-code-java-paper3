package ourMethodv2.gpt4o;
class Task194 {
    static class Master {
        String secret;
        String[] words;

        Master(String secret, String[] words) {
            this.secret = secret;
            this.words = words;
        }

        int guess(String word) {
            if (!java.util.Arrays.asList(words).contains(word)) {
                return -1;
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

    public static String findSecretWord(String[] words, Master master, int allowedGuesses) {
        int attempts = 0;
        for (String word : words) {
            if (attempts >= allowedGuesses) {
                return "Either you took too many guesses, or you did not find the secret word.";
            }
            int matches = master.guess(word);
            attempts++;
            if (matches == 6) {
                return "You guessed the secret word correctly.";
            }
        }
        return "Either you took too many guesses, or you did not find the secret word.";
    }

    public static void main(String[] args) {
        // Test case 1
        String secret1 = "acckzz";
        String[] words1 = {"acckzz","ccbazz","eiowzz","abcczz"};
        int allowedGuesses1 = 10;
        Master master1 = new Master(secret1, words1);
        System.out.println(findSecretWord(words1, master1, allowedGuesses1));

        // Test case 2
        String secret2 = "hamada";
        String[] words2 = {"hamada","khaled"};
        int allowedGuesses2 = 10;
        Master master2 = new Master(secret2, words2);
        System.out.println(findSecretWord(words2, master2, allowedGuesses2));

        // Additional test cases
        String secret3 = "banana";
        String[] words3 = {"banana", "orange", "apple", "grapes", "mango"};
        int allowedGuesses3 = 5;
        Master master3 = new Master(secret3, words3);
        System.out.println(findSecretWord(words3, master3, allowedGuesses3));

        String secret4 = "orange";
        String[] words4 = {"banana", "orange", "apple"};
        int allowedGuesses4 = 3;
        Master master4 = new Master(secret4, words4);
        System.out.println(findSecretWord(words4, master4, allowedGuesses4));

        String secret5 = "abcdef";
        String[] words5 = {"abcdef", "ghijkl", "mnopqr", "stuvwx"};
        int allowedGuesses5 = 4;
        Master master5 = new Master(secret5, words5);
        System.out.println(findSecretWord(words5, master5, allowedGuesses5));
    }
}