package ourMethod.openai;
public class Task8 {
    public static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] != array[i] + 1) {
                return (char) (array[i] + 1);
            }
        }
        return ' '; // Default return, should not reach here as per problem constraints
    }

    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'})); // e
        System.out.println(findMissingLetter(new char[]{'O', 'Q', 'R', 'S'})); // P
        System.out.println(findMissingLetter(new char[]{'x', 'y', 'z', 'b'})); // a
        System.out.println(findMissingLetter(new char[]{'K', 'M', 'N', 'O'})); // L
        System.out.println(findMissingLetter(new char[]{'B', 'C', 'D', 'F'})); // E
    }
}