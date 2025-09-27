package CoT.claude;

public class Task3 {
    public static boolean isPangram(String str) {
        // Convert to lowercase and remove non-alphabetic characters
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        
        // Create boolean array to mark presence of each letter
        boolean[] letters = new boolean[26];
        
        // Mark each letter found in string
        for(char c : str.toCharArray()) {
            letters[c - 'a'] = true;
        }
        
        // Check if all letters are present
        for(boolean present : letters) {
            if(!present) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "The quick brown fox jumps over the lazy dog",
            "Pack my box with five dozen liquor jugs",
            "This is not a pangram",
            "abcdefghijklmnopqrstuvwxyz",
            "The Five boxing wizards jump quickly"
        };
        
        for(String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Is Pangram: " + isPangram(test));
        }
    }
}
