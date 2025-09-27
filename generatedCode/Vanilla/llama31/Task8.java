package Vanilla.llama31;
public class Task8 {
    public static char findMissingLetter(char[] letters) {
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i + 1] - letters[i] > 1) {
                return (char) (letters[i] + 1);
            }
        }
        return ' '; // This line should not be reached if input is valid
    }

    public static void main(String[] args) {
        char[] test1 = {'a', 'b', 'c', 'd', 'f'};
        char[] test2 = {'O', 'Q', 'R', 'S'};
        char[] test3 = {'a', 'b', 'c', 'e'};
        char[] test4 = {'x', 'y', 'z', 'a'};
        char[] test5 = {'A', 'B', 'C', 'E'};

        System.out.println(findMissingLetter(test1)); // e
        System.out.println(findMissingLetter(test2)); // P
        System.out.println(findMissingLetter(test3)); // d
        System.out.println(findMissingLetter(test4)); // This case is invalid as 'a' is not consecutive with 'z'
        System.out.println(findMissingLetter(test5)); // D
    }
}