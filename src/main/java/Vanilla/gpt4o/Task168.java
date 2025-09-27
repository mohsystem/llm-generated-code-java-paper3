package Vanilla.gpt4o;
public class Task168 {
    public static String tweakLetters(String word, int[] tweaks) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char tweakedChar = (char) (word.charAt(i) + tweaks[i]);
            result.append(tweakedChar);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(tweakLetters("apple", new int[]{0, 1, -1, 0, -1})); // "aqold"
        System.out.println(tweakLetters("many", new int[]{0, 0, 0, -1})); // "manx"
        System.out.println(tweakLetters("rhino", new int[]{1, 1, 1, 1, 1})); // "sijop"
        System.out.println(tweakLetters("hello", new int[]{1, -1, 0, 0, 1})); // "hfllp"
        System.out.println(tweakLetters("world", new int[]{-1, 0, 1, -1, 0})); // "vorld"
    }
}