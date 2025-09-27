package ourMethod.claude;

public class Task168 {
    public static String tweakLetters(String word, int[] arr) {
        if (word == null || arr == null || word.length() != arr.length) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int shift = arr[i];
            
            // Calculate new character position
            int newPos = ((c - 'a' + shift) % 26);
            // Handle negative shifts
            if (newPos < 0) {
                newPos += 26;
            }
            // Convert back to character
            char newChar = (char)('a' + newPos);
            result.append(newChar);
        }
        
        return result.toString();
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
