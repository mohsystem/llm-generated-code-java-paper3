package ZeroShot.llama31;
public class Task8 {
    public static char findMissingLetter(char[] letters) {
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i + 1] - letters[i] > 1) {
                return (char) (letters[i] + 1);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[] {'a', 'b', 'c', 'd', 'f'})); // 'e'
        System.out.println(findMissingLetter(new char[] {'O', 'Q', 'R', 'S'})); // 'P'
        System.out.println(findMissingLetter(new char[] {'a', 'b', 'c', 'e', 'f'})); // 'd'
        System.out.println(findMissingLetter(new char[] {'A', 'B', 'C', 'E', 'F'})); // 'D'
        System.out.println(findMissingLetter(new char[] {'x', 'y', 'z', 'a', 'b'})); // This case is invalid as per problem constraints
    }
}