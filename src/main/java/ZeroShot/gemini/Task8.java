package ZeroShot.gemini;
import java.util.Arrays;

class Task8 {
    public char findMissingLetter(char[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] != 1) {
                return (char) (array[i - 1] + 1);
            }
        }
        return ' '; // Should never reach here according to problem statement
    }

    public static void main(String[] args) {
        Task8 task8 = new Task8();
        System.out.println(task8.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'})); // e
        System.out.println(task8.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'})); // P
        System.out.println(task8.findMissingLetter(new char[]{'A', 'B', 'D'})); // C
        System.out.println(task8.findMissingLetter(new char[]{'w', 'x', 'y', 'z', 'A'})); // Invalid Input according to problem statement but still handles it safely.
        System.out.println(task8.findMissingLetter(new char[]{'p', 'q', 'r', 's'})); // Should print nothing.
    }
}