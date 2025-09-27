package ourMethod.llama31;
public class Task168 {
    public static void main(String[] args) {
        System.out.println(tweakLetters("apple", new int[]{0, 1, -1, 0, -1})); // "aqold"
        System.out.println(tweakLetters("many", new int[]{0, 0, 0, -1})); // "manx"
        System.out.println(tweakLetters("rhino", new int[]{1, 1, 1, 1, 1})); // "sijop"
    }

    public static String tweakLetters(String word, int[] tweaks) {
        if (word.length() != tweaks.length) {
            throw new IllegalArgumentException("Word and tweaks array must be of the same length");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int offset = tweaks[i];
            char newChar = (char) (c + offset);
            // Ensure the new character remains within the alphabet range
            if (newChar < 'a') {
                newChar = 'a';
            } else if (newChar > 'z') {
                newChar = 'z';
            }
            result.append(newChar);
        }
        return result.toString();
    }
}