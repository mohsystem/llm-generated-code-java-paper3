package Vanilla.codestral;
public class Task194 {
    public static String findSecretWord(String[] words, Master master) {
        for (int i = 0, j = 0; i < master.guesses(); i++) {
            j = master.guess(words[i]);
            List<String> candidates = new ArrayList<>();
            for (String word : words) {
                if (match(words[i], word, j)) {
                    candidates.add(word);
                }
            }
            words = candidates.toArray(new String[0]);
        }
        return master.result();
    }

    public static int match(String a, String b, int k) {
        int matches = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        // Test cases
        Master master = new Master();
        System.out.println(findSecretWord(new String[]{"acckzz","ccbazz","eiowzz","abcczz"}, master));
        master = new Master();
        System.out.println(findSecretWord(new String[]{"hamada","khaled"}, master));
    }
}