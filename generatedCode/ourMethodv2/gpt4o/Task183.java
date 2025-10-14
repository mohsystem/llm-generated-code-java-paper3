package ourMethodv2.gpt4o;
public class Task183 {
    public static int largestProduct(String input, int span) {
        if (span <= 0 || span > input.length()) {
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
        System.out.println(largestProduct("63915", 3)); // 162
        System.out.println(largestProduct("123456789", 2)); // 72
        System.out.println(largestProduct("102345", 3)); // 30
        System.out.println(largestProduct("99999", 5)); // 59049
        System.out.println(largestProduct("87654321", 4)); // 1680
    }
}