package ourMethod.gpt4o;
import java.util.*;

class Task194 {
    public interface Master {
        int guess(String word);
    }

    public static String findSecretWord(String[] words, Master master, int allowedGuesses) {
        for (int i = 0; i < allowedGuesses && words.length > 0; i++) {
            String candidate = words[new Random().nextInt(words.length)];
            int matches = master.guess(candidate);
            if (matches == 6) {
                return "You guessed the secret word correctly.";
            }
            List<String> nextWords = new ArrayList<>();
            for (String word : words) {
                if (matchCount(candidate, word) == matches) {
                    nextWords.add(word);
                }
            }
            words = nextWords.toArray(new String[0]);
        }
        return "Either you took too many guesses, or you did not find the secret word.";
    }

    private static int matchCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Master master1 = word -> {
            if ("acckzz".equals(word)) return 6;
            if ("ccbazz".equals(word)) return 3;
            if ("eiowzz".equals(word)) return 2;
            if ("abcczz".equals(word)) return 4;
            return -1;
        };

        String[] words1 = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        System.out.println(findSecretWord(words1, master1, 10)); // You guessed the secret word correctly.

        Master master2 = word -> {
            if ("hamada".equals(word)) return 6;
            if ("khaled".equals(word)) return 3;
            return -1;
        };

        String[] words2 = {"hamada", "khaled"};
        System.out.println(findSecretWord(words2, master2, 10)); // You guessed the secret word correctly.
    }
}