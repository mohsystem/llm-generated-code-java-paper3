package CoT.llama31;
public class Task8 {
    public static char findMissingLetter(char[] chars) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int startIndex = alphabet.indexOf(chars[0]);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != alphabet.charAt(startIndex + i)) {
                return alphabet.charAt(startIndex + i);
            }
        }
        return ' '; // This line should not be reached
    }

    public static void main(String[] args) {
        char[] test1 = {'a', 'b', 'c', 'd', 'f'};
        char[] test2 = {'O', 'Q', 'R', 'S'};
        char[] test3 = {'a', 'b', 'c', 'e'};
        char[] test4 = {'A', 'B', 'C', 'E'};
        char[] test5 = {'x', 'y', 'z', 'a'};

        System.out.println(findMissingLetter(test1)); // e
        System.out.println(findMissingLetter(test2)); // P
        System.out.println(findMissingLetter(test3)); // d
        System.out.println(findMissingLetter(test4)); // D
        System.out.println(findMissingLetter(test5)); // This case is invalid as per problem statement, but it will return 'b'
    }
}