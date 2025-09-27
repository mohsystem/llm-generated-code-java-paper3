package Vanilla.codestral;
public class Task168 {
    public static String tweakLetters(String word, int[] tweaks) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = (char) (word.charAt(i) + tweaks[i]);
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(tweakLetters("apple", new int[]{0, 1, -1, 0, -1}));
        System.out.println(tweakLetters("many", new int[]{0, 0, 0, -1}));
        System.out.println(tweakLetters("rhino", new int[]{1, 1, 1, 1, 1}));
    }
}