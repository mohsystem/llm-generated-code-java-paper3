package ourMethod.gemini;
import java.util.Arrays;

class Task8 {
    public static char findMissingLetter(char[] arr) {
        char expected = arr[0];
        for (int i = 1; i < arr.length; i++) {
            expected++;
            if (arr[i] != expected) {
                return expected;
            }
        }
        return ' '; // Should never reach here since exactly one letter is missing
    }

    public static void main(String[] args) {
        char[] test1 = {'a', 'b', 'c', 'd', 'f'};
        char[] test2 = {'O', 'Q', 'R', 'S'};
        char[] test3 = {'w', 'x', 'y', 'z'};
        char[] test4 = {'A', 'B', 'D', 'E'};
        char[] test5 = {'p', 'q', 'r','s'};
        
        System.out.println(findMissingLetter(test1)); // Output: e
        System.out.println(findMissingLetter(test2)); // Output: P
         System.out.println(findMissingLetter(test3));
          System.out.println(findMissingLetter(test4));
           System.out.println(findMissingLetter(test5));
    }
}