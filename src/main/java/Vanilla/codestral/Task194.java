package Vanilla.codestral;


import java.util.ArrayList;
import java.util.List;

class Master {
    private String secret;
    int guesses;
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

public class Task194 {
    public static String findSecretWord(String[] words, Master master) {
        for (int i = 0, j = 0; i < master.guesses; i++) {
            j = master.guess(words[i]);
            List<String> candidates = new ArrayList<>();
            for (String word : words) {
                if (match(words[i], word, j)) {
                    candidates.add(word);
                }
            }
            words = candidates.toArray(new String[0]);
        }
        //todo compile error
        return master.guesses +"";
//        return master.result();
    }

    public static boolean match(String a, String b, int k) {
        int matches = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                matches++;
            }
        }
        //todo incompatible types: int cannot be converted to boolean
//        return matches;
        return matches>0;
    }

//    public static void main(String[] args) {
//        // Test cases
//        Master master = new Master();
//        System.out.println(findSecretWord(new String[]{"acckzz","ccbazz","eiowzz","abcczz"}, master));
//        master = new Master();
//        System.out.println(findSecretWord(new String[]{"hamada","khaled"}, master));
//    }
}