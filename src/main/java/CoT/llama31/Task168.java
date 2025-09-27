package CoT.llama31;
public class Task168 {
    public static void main(String[] args) {
        System.out.println(tweakLetters("apple", new int[] {0, 1, -1, 0, -1})); // "aqold"
        System.out.println(tweakLetters("many", new int[] {0, 0, 0, -1})); // "manx"
        System.out.println(tweakLetters("rhino", new int[] {1, 1, 1, 1, 1})); // "sijop"
        System.out.println(tweakLetters("test", new int[] {0, 0, 0, 0})); // "test"
        System.out.println(tweakLetters("hello", new int[] {-1, -1, -1, -1, -1})); // "gdkkk"
    }

    public static String tweakLetters(String str, int[] arr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            c = (char) (c + arr[i]);
            result.append(c);
        }
        return result.toString();
    }
}