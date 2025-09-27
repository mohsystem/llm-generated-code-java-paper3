package Vanilla.gemini;
import java.util.Arrays;

class Task8 {
    public static char findMissingLetter(char[] array) {
        char expected = array[0];
        for (char actual : array) {
            if (actual != expected) {
                return expected;
            }
            expected++;
        }
        return ' '; // Should never reach here based on problem constraints
    }

    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'})); // e
        System.out.println(findMissingLetter(new char[]{'O', 'Q', 'R', 'S'})); // P
        System.out.println(findMissingLetter(new char[]{'w', 'x', 'y', 'z'})); // Should never reach here based on problem constraints
        System.out.println(findMissingLetter(new char[]{'A', 'B', 'D'})); // C
        System.out.println(findMissingLetter(new char[]{'p', 'q', 's'})); // r

    }
}