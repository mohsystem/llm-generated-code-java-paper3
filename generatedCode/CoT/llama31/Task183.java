package CoT.llama31;
public class Task183 {
    public static void main(String[] args) {
        // Test cases
        System.out.println(largestProduct("63915", 3)); // Expected: 162
        System.out.println(largestProduct("123456", 2)); // Expected: 72
        System.out.println(largestProduct("99999", 4)); // Expected: 729
        System.out.println(largestProduct("123", 2)); // Expected: 6
        System.out.println(largestProduct("1", 1)); // Expected: 1
    }

    public static long largestProduct(String input, int span) {
        if (input.length() < span) {
            throw new IllegalArgumentException("Span is larger than input length");
        }

        long maxProduct = 0;
        for (int i = 0; i <= input.length() - span; i++) {
            long product = 1;
            for (int j = 0; j < span; j++) {
                product *= input.charAt(i + j) - '0';
            }
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }
}