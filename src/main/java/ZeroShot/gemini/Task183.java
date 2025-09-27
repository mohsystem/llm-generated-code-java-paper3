package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.List;

class Task183 {
    public static long largestProduct(String digits, int span) {
        if (span < 1 || span > digits.length()) {
            return -1; // Or throw an exception
        }

        long maxProduct = 0;
        for (int i = 0; i <= digits.length() - span; i++) {
            long currentProduct = 1;
            String series = digits.substring(i, i + span);
            for (char digitChar : series.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);
                if (digit < 0 || digit > 9) {
                    return -1; // Invalid input - non-digit character
                }
                currentProduct *= digit;
            }
            maxProduct = Math.max(maxProduct, currentProduct);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(largestProduct("63915", 3)); // Expected: 162
        System.out.println(largestProduct("1027839564", 5)); // Expected: 2520
        System.out.println(largestProduct("11111", 3)); // Expected 1
        System.out.println(largestProduct("99999", 3)); // Expected 729
        System.out.println(largestProduct("00000", 3)); // Expected 0

    }
}