package CoT.gpt4o;
import java.util.Arrays;
import java.util.List;

class Task194 {
    interface Master {
        int guess(String word);
    }

    static class TestMaster implements Master {
        private String secret;
        private List<String> words;

        public TestMaster(String secret, List<String> words) {
            this.secret = secret;
            this.words = words;
        }

        @Override
        public int guess(String word) {
            if (!words.contains(word)) return -1;
            int matches = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == secret.charAt(i)) {
                    matches++;
                }
            }
            return matches;
        }
    }

    public static String findSecretWord(List<String> words, Master master, int allowedGuesses) {
        int guessCount = 0;
        for (String word : words) {
            int result = master.guess(word);
            guessCount++;
            if (result == 6) {
                return "You guessed the secret word correctly.";
            }
            if (guessCount > allowedGuesses) {
                return "Either you took too many guesses, or you did not find the secret word.";
            }
        }
        return "Either you took too many guesses, or you did not find the secret word.";
    }

    public static void main(String[] args) {
        List<String> words1 = Arrays.asList("acckzz", "ccbazz", "eiowzz", "abcczz");
        TestMaster master1 = new TestMaster("acckzz", words1);
        System.out.println(findSecretWord(words1, master1, 10));

        List<String> words2 = Arrays.asList("hamada", "khaled");
        TestMaster master2 = new TestMaster("hamada", words2);
        System.out.println(findSecretWord(words2, master2, 10));

        List<String> words3 = Arrays.asList("abcdef", "ghijkl", "mnopqr", "stuvwx");
        TestMaster master3 = new TestMaster("mnopqr", words3);
        System.out.println(findSecretWord(words3, master3, 10));

        List<String> words4 = Arrays.asList("aaaaaa", "bbbbbb", "cccccc", "dddddd");
        TestMaster master4 = new TestMaster("dddddd", words4);
        System.out.println(findSecretWord(words4, master4, 10));

        List<String> words5 = Arrays.asList("zzzzzz", "yyyyyy", "xxxxxx");
        TestMaster master5 = new TestMaster("xxxxxx", words5);
        System.out.println(findSecretWord(words5, master5, 10));
    }
}