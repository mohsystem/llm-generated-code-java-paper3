package ourMethod.gemini;
import java.util.HashSet;
import java.util.Set;

public class Task4 {

    public static boolean isIsogram(String str) {
        if (str.isEmpty()) {
            return true;
        }

        String lowerCaseStr = str.toLowerCase();
        Set<Character> seenChars = new HashSet<>();

        for (char c : lowerCaseStr.toCharArray()) {
            if (seenChars.contains(c)) {
                return false;
            }
            seenChars.add(c);
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {"Dermatoglyphics", "aba", "moOse", "", "isogram"};
        boolean[] expectedResults = {true, false, false, true, true};

        for (int i = 0; i < testCases.length; i++) {
            boolean actualResult = isIsogram(testCases[i]);
            System.out.println("Input: \"" + testCases[i] + "\" --> Output: " + actualResult + ", Expected: " + expectedResults[i]);
            assert actualResult == expectedResults[i];
        }

    }
}