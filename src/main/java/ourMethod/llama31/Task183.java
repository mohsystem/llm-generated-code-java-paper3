package ourMethod.llama31;
public class Task183 {
    public static void main(String[] args) {
        String input = "63915";
        int span = 3;
        System.out.println("Largest product: " + largestProduct(input, span));

        // Test cases
        System.out.println("Largest product for '123456' with span 3: " + largestProduct("123456", 3));
        System.out.println("Largest product for '987654' with span 4: " + largestProduct("987654", 4));
        System.out.println("Largest product for '111111' with span 5: " + largestProduct("111111", 5));
        System.out.println("Largest product for '12345' with span 2: " + largestProduct("12345", 2));
        System.out.println("Largest product for '99999' with span 1: " + largestProduct("99999", 1));
    }

    public static long largestProduct(String input, int span) {
        if (input == null || input.length() < span) {
            throw new IllegalArgumentException("Input length must be at least equal to the span");
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