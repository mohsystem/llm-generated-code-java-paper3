package CoT.gemini;
import java.util.Arrays;

public class Task8 {

    public static char findMissingLetter(char[] array) {
        char expected = array[0];
        for (int i = 1; i < array.length; i++) {
            expected++;
            if (array[i] != expected) {
                return expected;
            }
        }
        return ' '; // Should never reach here as per problem statement
    }

    public static void main(String[] args) {
        char[] test1 = {'a', 'b', 'c', 'd', 'f'};
        char[] test2 = {'O', 'Q', 'R', 'S'};
        char[] test3 = {'w', 'x', 'y', 'z'};
        char[] test4 = {'A', 'B', 'D'};
        char[] test5 = {'p', 'q', 'r', 's', 't', 'v'};

        System.out.println("Test 1: " + findMissingLetter(test1)); // Expected: e
        System.out.println("Test 2: " + findMissingLetter(test2)); // Expected: P
        System.out.println("Test 3: " + findMissingLetter(test3)); // Expected:  (no missing letter but should not happen)
        System.out.println("Test 4: " + findMissingLetter(test4)); // Expected: C
        System.out.println("Test 5: " + findMissingLetter(test5)); // Expected: u

    }
}