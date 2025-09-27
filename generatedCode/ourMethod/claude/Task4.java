package ourMethod.claude;

public class Task4 {
    public static boolean isIsogram(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        
        // Convert to lowercase to ignore case
        str = str.toLowerCase();
        
        // Create boolean array to track seen characters
        boolean[] seen = new boolean[26];
        
        // Check each character
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            // Skip non-letter characters
            if (!Character.isLetter(c)) {
                continue;
            }
            
            // Get array index for character
            int index = c - 'a';
            
            // If character already seen, not an isogram
            if (seen[index]) {
                return false;
            }
            
            // Mark character as seen
            seen[index] = true;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false 
        System.out.println(isIsogram("moOse")); // false
        System.out.println(isIsogram("")); // true
        System.out.println(isIsogram("isogram")); // true
    }
}
