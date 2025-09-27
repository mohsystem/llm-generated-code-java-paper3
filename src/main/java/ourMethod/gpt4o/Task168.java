package ourMethod.gpt4o;
public class Task168 {
    public static String tweakLetters(String word, int[] tweaks) {
        StringBuilder tweakedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char tweakedChar = (char) (word.charAt(i) + tweaks[i]);
            tweakedWord.append(tweakedChar);
        }
        return tweakedWord.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(tweakLetters("apple", new int[]{0, 1, -1, 0, -1})); // "aqold"
        System.out.println(tweakLetters("many", new int[]{0, 0, 0, -1})); // "manx"
        System.out.println(tweakLetters("rhino", new int[]{1, 1, 1, 1, 1})); // "sijop"
        System.out.println(tweakLetters("hello", new int[]{0, 0, 1, -1, 0})); // "hempo"
        System.out.println(tweakLetters("world", new int[]{-1, 1, 0, 0, -1})); // "vprke"
    }
}