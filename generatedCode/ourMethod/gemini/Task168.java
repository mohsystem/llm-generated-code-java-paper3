package ourMethod.gemini;
import java.util.Arrays;

class Task168 {
    public String tweakLetters(String str, int[] arr) {
        if (str == null || arr == null || str.length() != arr.length) {
            return null; // Or throw an exception
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + arr[i]);
        }
        return new String(chars);

    }

    public static void main(String[] args) {
        Task168 task168 = new Task168();

        String test1 = task168.tweakLetters("apple", new int[]{0, 1, -1, 0, -1});
        System.out.println("Test 1: " + test1); // Output: aqold


        String test2 = task168.tweakLetters("many", new int[]{0, 0, 0, -1});
        System.out.println("Test 2: " + test2); // Output: manx

        String test3 = task168.tweakLetters("rhino", new int[]{1, 1, 1, 1, 1});
        System.out.println("Test 3: " + test3); // Output: sijop

         String test4 = task168.tweakLetters("hello", new int[]{0, 1, 0, -1, 0});
        System.out.println("Test 4: " + test4); // Output: hfmkp

        String test5 = task168.tweakLetters("world", new int[]{-1, 0, 1, 0, -1});
        System.out.println("Test 5: " + test5); // Output: vnqsc
    }
}