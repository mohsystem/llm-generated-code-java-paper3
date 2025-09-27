package ourMethod.claude;

public class Task3 {
    public static boolean isPangram(String str) {
        // Convert to lowercase and remove non-alphabetic characters
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        
        // Create array to track letter occurrences
        boolean[] letters = new boolean[26];
        
        // Mark letters found
        for(char c : str.toCharArray()) {
            letters[c - 'a'] = true;
        }
        
        // Check if all letters were found
        for(boolean found : letters) {
            if(!found) return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(isPangram("This is not a pangram")); // false
        System.out.println(isPangram("Pack my box with five dozen liquor jugs.")); // true 
        System.out.println(isPangram("abcdefghijklmnopqrstuvwxyz")); // true
        System.out.println(isPangram("A pangram IS a sentence using every letter of the ALPHABET.")); // true
    }
}
