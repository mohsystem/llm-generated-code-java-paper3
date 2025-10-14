package ZeroShot.openai;
public class Task183 {
    public static int largestProduct(String input, int span) {
        if (span > input.length() || span <= 0) {
            throw new IllegalArgumentException("Span must be a positive integer less than or equal to the length of the input.");
        }
        int maxProduct = 0;
        for (int i = 0; i <= input.length() - span; i++) {
            int product = 1;
            for (int j = 0; j < span; j++) {
                product *= Character.getNumericValue(input.charAt(i + j));
            }
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(largestProduct("63915", 3)); // 162
        System.out.println(largestProduct("123456789", 2)); // 72
        System.out.println(largestProduct("987654321", 3)); // 504
        System.out.println(largestProduct("11111", 4)); // 1
        System.out.println(largestProduct("12345", 5)); // 120
    }
}