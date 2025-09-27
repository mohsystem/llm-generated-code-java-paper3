package ourMethod.llama31;
public class Task8 {
    public static void main(String[] args) {
        String[] testCases = {"a", "b", "c", "d", "f"},
                       {"O", "Q", "R", "S"},
                       {"a", "b", "d", "e"},
                       {"A", "B", "D", "E"},
                       {"p", "r", "s", "t"};

        for (String[] testCase : testCases) {
            System.out.println("Missing letter in the array: " + findMissingLetter(testCase));
        }
    }

    public static String findMissingLetter(String[] str_arra) {
        for (int i = 0; i < str_arra.length - 1; i++) {
            if (str_arra[i + 1].charAt(0) - str_arra[i].charAt(0) > 1) {
                return String.valueOf((char)(str_arra[i].charAt(0) + 1));
            }
        }
        return "";
    }
}