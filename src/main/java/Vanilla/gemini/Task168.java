package Vanilla.gemini;
import java.util.Arrays;

class Task168 {
    public String tweakLetters(String str, int[] arr) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < arr.length && i < chars.length; i++) {
            chars[i] = (char) (chars[i] + arr[i]);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Task168 task168 = new Task168();
        System.out.println(task168.tweakLetters("apple", new int[]{0, 1, -1, 0, -1})); // Output: aqold
        System.out.println(task168.tweakLetters("many", new int[]{0, 0, 0, -1})); // Output: manx
        System.out.println(task168.tweakLetters("rhino", new int[]{1, 1, 1, 1, 1})); // Output: sijop
        System.out.println(task168.tweakLetters("xyz", new int[]{1, 1, 1})); // Output: yza
        System.out.println(task168.tweakLetters("abc", new int[]{-1, -1, -1})); // Output: zab

    }
}