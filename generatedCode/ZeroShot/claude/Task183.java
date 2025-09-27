package ZeroShot.claude;

public class Task183 {
    public static long findLargestProduct(String input, int span) {
        if (input == null || input.length() < span || span <= 0) {
            return -1;
        }
        
        long maxProduct = 0;
        for (int i = 0; i <= input.length() - span; i++) {
            long currentProduct = 1;
            boolean validSeries = true;
            
            for (int j = 0; j < span; j++) {
                char digit = input.charAt(i + j);
                if (!Character.isDigit(digit)) {
                    validSeries = false;
                    break;
                }
                currentProduct *= Character.getNumericValue(digit);
            }
            
            if (validSeries && currentProduct > maxProduct) {
                maxProduct = currentProduct;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findLargestProduct("63915", 3));  // Expected: 162
        System.out.println(findLargestProduct("12345", 2));  // Expected: 20
        System.out.println(findLargestProduct("987654", 4)); // Expected: 3024
        System.out.println(findLargestProduct("11111", 1));  // Expected: 1
        System.out.println(findLargestProduct("54321", 5));  // Expected: 120
    }
}
