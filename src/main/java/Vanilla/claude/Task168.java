package Vanilla.claude;

public class Task168 {
    public static String tweakLetters(String word, int[] arr) {
        char[] chars = word.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            chars[i] = (char)((((chars[i] - 'a' + arr[i]) % 26 + 26) % 26) + 'a');
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
