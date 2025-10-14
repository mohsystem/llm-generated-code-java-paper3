package ZeroShot.openai;
import java.util.*;

class Task194 {
    interface Master {
        int guess(String word);
    }

    public static String findSecretWord(String[] words, Master master, int allowedGuesses) {
        for (int i = 0; i < allowedGuesses; i++) {
            String guessWord = words[i % words.length];
            int match = master.guess(guessWord);
            if (match == 6) {
                return "You guessed the secret word correctly.";
            }
        }
        return "Either you took too many guesses, or you did not find the secret word.";
    }

    public static void main(String[] args) {
        class TestMaster implements Master {
            private final String secret;
            private int calls = 0;
            private final Set<String> wordSet;

            TestMaster(String secret, String[] words) {
                this.secret = secret;
                wordSet = new HashSet<>(Arrays.asList(words));
            }

            @Override
            public int guess(String word) {
                calls++;
                if (!wordSet.contains(word)) return -1;
                int matches = 0;
                for (int i = 0; i < 6; i++) {
                    if (secret.charAt(i) == word.charAt(i)) matches++;
                }
                return matches;
            }

            public int getCalls() {
                return calls;
            }
        }

        String[][] wordSets = {
                {"acckzz", "ccbazz", "eiowzz", "abcczz"},
                {"hamada", "khaled"},
                {"orange", "banana", "grapes", "peachy"},
                {"monday", "tuesday", "wednes"},
                {"github", "gitlab", "bitbuc"}
        };
        String[] secrets = {"acckzz", "hamada", "banana", "tuesday", "bitbuc"};
        int[] allowedGuessesList = {10, 10, 10, 10, 10};

        for (int i = 0; i < 5; i++) {
            TestMaster master = new TestMaster(secrets[i], wordSets[i]);
            String result = findSecretWord(wordSets[i], master, allowedGuessesList[i]);
            System.out.println("Test Case " + (i + 1) + ": " + result);
            System.out.println("Guesses Used: " + master.getCalls());
        }
    }
}