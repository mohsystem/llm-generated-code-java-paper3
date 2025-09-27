package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;

class Task183 {
    public static long largestProduct(String digits, int span) {
        if (span < 0 || span > digits.length()) {
            throw new IllegalArgumentException("Span must be between 0 and the length of the digits string.");
        }
        if (digits.isEmpty() || span == 0)
            return 0;


        long largestProd = 0;
        for (int i = 0; i <= digits.length() - span; i++) {
            long currentProd = 1;
            String series = digits.substring(i, i + span);
            for (char digitChar : series.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);
                if (digit < 0 || digit > 9) {
                    throw new IllegalArgumentException("Input string must contain only digits.");
                }
                currentProd *= digit;


            }
            largestProd = Math.max(largestProd, currentProd);
        }

        return largestProd;
    }


    public static void main(String[] args) {
        List<String> testDigits = new ArrayList<>(List.of("12345", "63915", "99999", "10203", "00000"));
        List<Integer> testSpans = new ArrayList<>(List.of(3, 3, 2, 1, 3));

        for (int i = 0; i < testDigits.size(); i++) {
            System.out.println("Input: \"" + testDigits.get(i) + "\", span: " + testSpans.get(i) +
                    ", Largest Product: " + largestProduct(testDigits.get(i), testSpans.get(i)));
        }
    }
}