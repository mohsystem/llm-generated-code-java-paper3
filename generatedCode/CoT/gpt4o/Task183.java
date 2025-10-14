package CoT.openai;
public class Task183 {
    public static int largestProduct(String input, int span) {
        if (span > input.length() || span < 0) return 0;
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
        System.out.println(largestProduct("98765", 1)); // 9
        System.out.println(largestProduct("00000", 3)); // 0
        System.out.println(largestProduct("1234", 0)); // 0
    }
}