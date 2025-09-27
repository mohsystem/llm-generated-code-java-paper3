package CoT.gemini;
import java.util.Arrays;

public class Task168 {
    public static String tweakLetters(String str, int[] arr) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < Math.min(str.length(), arr.length); i++) {
            chars[i] = (char) (chars[i] + arr[i]);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(tweakLetters("apple", new int[]{0, 1, -1, 0, -1})); // aqold
        System.out.println(tweakLetters("many", new int[]{0, 0, 0, -1})); // manx
        System.out.println(tweakLetters("rhino", new int[]{1, 1, 1, 1, 1})); // sijop
        System.out.println(tweakLetters("xyz", new int[]{1, 1, 1})); // yza
        System.out.println(tweakLetters("abc", new int[]{-1, -1, -1})); // zab

    }
}