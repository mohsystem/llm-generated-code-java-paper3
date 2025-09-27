package Vanilla.llama31;
public class Task168 {
    public static void main(String[] args) {
        System.out.println(tweakLetters("apple", new int[]{0, 1, -1, 0, -1})); // "aqold"
        System.out.println(tweakLetters("many", new int[]{0, 0, 0, -1})); // "manx"
        System.out.println(tweakLetters("rhino", new int[]{1, 1, 1, 1, 1})); // "sijop"
        System.out.println(tweakLetters("hello", new int[]{0, 0, 0, 0, 0})); // "hello"
        System.out.println(tweakLetters("world", new int[]{-1, -1, -1, -1, -1})); // "vnmkc"
    }

    public static String tweakLetters(String str, int[] tweaks) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + tweaks[i]);
        }
        return new String(chars);
    }
}