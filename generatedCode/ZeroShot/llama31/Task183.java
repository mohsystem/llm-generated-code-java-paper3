package ZeroShot.llama31;
public class Task183 {
    public static long largestProduct(String sequence, int span) {
        if (sequence.length() < span) {
            throw new IllegalArgumentException("Span is larger than the sequence length");
        }
        long maxProduct = 0;
        for (int i = 0; i <= sequence.length() - span; i++) {
            long product = 1;
            for (int j = i; j < i + span; j++) {
                product *= sequence.charAt(j) - '0';
            }
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(largestProduct("63915", 3)); // Expected: 162
        System.out.println(largestProduct("12345", 2)); // Expected: 12
        System.out.println(largestProduct("98765", 4)); // Expected: 945
        System.out.println(largestProduct("11111", 3)); // Expected: 1
        System.out.println(largestProduct("54321", 1)); // Expected: 5
    }
}