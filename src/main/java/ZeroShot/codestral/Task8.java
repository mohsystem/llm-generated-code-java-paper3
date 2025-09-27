package ZeroShot.codestral;
public class Task8 {
    public static char findMissingLetter(char[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] != 1) {
                return (char) (array[i - 1] + 1);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'})); // 'e'
        System.out.println(findMissingLetter(new char[]{'O', 'Q', 'R', 'S'})); // 'P'
    }
}