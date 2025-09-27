package CoT.claude;

public class Task8 {
    public static char findMissingLetter(char[] array) {
        // Convert first character to ASCII value
        int start = (int) array[0];
        
        // Loop through array checking for gap in sequence
        for (int i = 0; i < array.length; i++) {
            if ((int) array[i] != start + i) {
                return (char) (start + i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findMissingLetter(new char[] {'a','b','c','d','f'}));  // e
        System.out.println(findMissingLetter(new char[] {'O','Q','R','S'}));      // P
        System.out.println(findMissingLetter(new char[] {'a','c','d'}));          // b
        System.out.println(findMissingLetter(new char[] {'m','o','p','q'}));      // n
        System.out.println(findMissingLetter(new char[] {'F','H','I'}));          // G
    }
}
