package ZeroShot.gpt4o;
public class Task168 {
    public static String tweakLetters(String str, int[] tweaks) {
        if (str == null || tweaks == null || str.length() != tweaks.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char tweakedChar = (char) (str.charAt(i) + tweaks[i]);
            result.append(tweakedChar);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(tweakLetters("apple", new int[]{0, 1, -1, 0, -1})); // "aqold"
        System.out.println(tweakLetters("many", new int[]{0, 0, 0, -1})); // "manx"
        System.out.println(tweakLetters("rhino", new int[]{1, 1, 1, 1, 1})); // "sijop"
        System.out.println(tweakLetters("code", new int[]{-1, 0, 1, 1})); // "bnff"
        System.out.println(tweakLetters("java", new int[]{1, -1, 1, -1})); // "kbwb"
    }
}