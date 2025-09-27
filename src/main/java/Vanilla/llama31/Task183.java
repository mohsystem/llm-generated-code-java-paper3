package Vanilla.llama31;
public class Task183 {
    public static void main(String[] args) {
        System.out.println(largestProduct("63915", 3)); // Expected: 162
        System.out.println(largestProduct("12233445566778899", 4)); // Expected: 504
        System.out.println(largestProduct("123456789", 3)); // Expected: 216
        System.out.println(largestProduct("999999999", 3)); // Expected: 729
        System.out.println(largestProduct("10001", 3)); // Expected: 0
    }

    public static long largestProduct(String digits, int span) {
        if (digits.length() < span) {
            return 0;
        }
        long maxProduct = 0;
        for (int i = 0; i <= digits.length() - span; i++) {
            long product = 1;
            for (int j = i; j < i + span; j++) {
                product *= digits.charAt(j) - '0';
            }
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }
}