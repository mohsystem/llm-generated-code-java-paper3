package ZeroShot.claude;

public class Task8 {
    public static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] > 1) {
                return (char) (array[i] + 1);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findMissingLetter(new char[] {'a','b','c','d','f'}));  // e
        System.out.println(findMissingLetter(new char[] {'O','Q','R','S'}));      // P
        System.out.println(findMissingLetter(new char[] {'a','b','d'}));          // c
        System.out.println(findMissingLetter(new char[] {'m','o'}));              // n
        System.out.println(findMissingLetter(new char[] {'A','B','D'}));          // C
    }
}
