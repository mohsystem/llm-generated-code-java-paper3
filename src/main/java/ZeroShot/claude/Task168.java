package ZeroShot.claude;

public class Task168 {
    public static String tweakLetters(String str, int[] arr) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int newPos = ((chars[i] - 'a' + arr[i]) % 26 + 26) % 26;
            chars[i] = (char) ('a' + newPos);
        }
        return new String(chars);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(tweakLetters("apple", new int[]{0, 1, -1, 0, -1})); // "aqold"
        System.out.println(tweakLetters("many", new int[]{0, 0, 0, -1})); // "manx"
        System.out.println(tweakLetters("rhino", new int[]{1, 1, 1, 1, 1})); // "sijop"
        System.out.println(tweakLetters("xyz", new int[]{1, 1, 1})); // "yza"
        System.out.println(tweakLetters("abc", new int[]{-1, -1, -1})); // "zab"
    }
}
