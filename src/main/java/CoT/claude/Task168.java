package CoT.claude;

public class Task168 {
    public static String tweakLetters(String str, int[] arr) {
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int shift = arr[i];
            
            // Handle forward shift
            if(shift > 0) {
                if(c == 'z') {
                    c = 'a';
                } else {
                    c = (char)(c + shift);
                }
            }
            // Handle backward shift
            else if(shift < 0) {
                if(c == 'a') {
                    c = 'z'; 
                } else {
                    c = (char)(c + shift);
                }
            }
            result.append(c);
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
