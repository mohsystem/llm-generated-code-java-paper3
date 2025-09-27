package CoT.gemini;
import java.util.ArrayList;
import java.util.List;

public class Task183 {

    public static long largestProduct(String digits, int span) {
        if (span < 1 || span > digits.length()) {
            return -1; // Invalid span
        }

        long maxProduct = 0;
        for (int i = 0; i <= digits.length() - span; i++) {
            long currentProduct = 1;
            String series = digits.substring(i, i + span);
            for (char digit : series.toCharArray()) {
                if (!Character.isDigit(digit)) {
                    return -1; // Invalid input: non-digit character
                }
                currentProduct *= Character.getNumericValue(digit);

            }
            maxProduct = Math.max(maxProduct, currentProduct);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        List<String[]> testCases = new ArrayList<>();
        testCases.add(new String[]{"63915", "3", "162"});
        testCases.add(new String[]{"12345", "2", "20"});
        testCases.add(new String[]{"99999", "3", "729"});
        testCases.add(new String[]{"01234", "2", "6"});
        testCases.add(new String[]{"10203", "3", "0"});


        for (String[] testCase : testCases) {
            String digits = testCase[0];
            int span = Integer.parseInt(testCase[1]);
            long expected = Long.parseLong(testCase[2]);
            long result = largestProduct(digits, span);
            System.out.println("Input: \"" + digits + "\", Span: " + span +
                    ", Expected: " + expected + ", Result: " + result +
                    ", Match: " + (result == expected));
        }

    }
}