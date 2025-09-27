package Vanilla.gpt4o;
public class Task8 {
    public static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] != array[i] + 1) {
                return (char) (array[i] + 1);
            }
        }
        return ' '; // This should never be reached with valid input
    }
    
    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[] {'a', 'b', 'c', 'd', 'f'})); // e
        System.out.println(findMissingLetter(new char[] {'O', 'Q', 'R', 'S'}));      // P
        System.out.println(findMissingLetter(new char[] {'m', 'n', 'p', 'q'}));      // o
        System.out.println(findMissingLetter(new char[] {'E', 'F', 'H'}));           // G
        System.out.println(findMissingLetter(new char[] {'x', 'y', 'z'}));           // (shouldn't reach here with valid input)
    }
}