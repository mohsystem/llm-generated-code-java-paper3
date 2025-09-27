package ourMethod.gpt4o;
public class Task183 {
    public static int largestProduct(String input, int span) {
        if (span <= 0 || input == null || input.length() < span) {
            return 0;
        }

        int maxProduct = 0;

        for (int i = 0; i <= input.length() - span; i++) {
            int product = 1;
            for (int j = 0; j < span; j++) {
                product *= Character.getNumericValue(input.charAt(i + j));
            }
            if (product > maxProduct) {
                maxProduct = product;
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(largestProduct("63915", 3)); // Expected output: 162
        System.out.println(largestProduct("123456789", 2)); // Expected output: 72
        System.out.println(largestProduct("999", 2)); // Expected output: 81
        System.out.println(largestProduct("98765", 1)); // Expected output: 9
        System.out.println(largestProduct("000", 2)); // Expected output: 0
    }
}