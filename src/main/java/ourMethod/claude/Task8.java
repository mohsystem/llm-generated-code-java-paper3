package ourMethod.claude;

public class Task8 {
    public static char findMissingLetter(char[] array) {
        // Check valid input
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Invalid input array");
        }
        
        // Convert first letter to get case
        boolean isUpperCase = Character.isUpperCase(array[0]);
        
        // Check consecutive letters
        for (int i = 0; i < array.length - 1; i++) {
            char current = array[i];
            char next = array[i + 1];
            
            // If gap is more than 1, missing letter found
            if (next - current > 1) {
                return (char)(current + 1);
            }
        }
        
        return ' '; // Should not reach here with valid input
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findMissingLetter(new char[] {'a','b','c','d','f'}));  // e
        System.out.println(findMissingLetter(new char[] {'O','Q','R','S'}));      // P
        System.out.println(findMissingLetter(new char[] {'a','c','d'}));          // b
        System.out.println(findMissingLetter(new char[] {'X','Z'}));              // Y
        System.out.println(findMissingLetter(new char[] {'m','n','p','q'}));      // o
    }
}
