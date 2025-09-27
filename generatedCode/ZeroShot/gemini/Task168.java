package ZeroShot.gemini;
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
        Task168 task = new Task168();
        System.out.println(task.tweakLetters("apple", new int[]{0, 1, -1, 0, -1})); // aqold
        System.out.println(task.tweakLetters("many", new int[]{0, 0, 0, -1})); // manx
        System.out.println(task.tweakLetters("rhino", new int[]{1, 1, 1, 1, 1})); // sijop
        System.out.println(task.tweakLetters("xyz", new int[]{1, 1, 1})); // yza
        System.out.println(task.tweakLetters("abc", new int[]{-1, -1, -1})); // zab

    }
}