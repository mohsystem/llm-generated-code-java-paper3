package Vanilla.claude;

public class Task183 {
    public static long largestSeriesProduct(String input, int span) {
        if (span > input.length() || span < 0) return -1;
        if (span == 0) return 1;
        
        long maxProduct = 0;
        
        for (int i = 0; i <= input.length() - span; i++) {
            long product = 1;
            for (int j = 0; j < span; j++) {
                char c = input.charAt(i + j);
                if (!Character.isDigit(c)) return -1;
                product *= Character.getNumericValue(c);
            }
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(largestSeriesProduct("63915", 3));  // 162
        System.out.println(largestSeriesProduct("1027839564", 3));  // 270
        System.out.println(largestSeriesProduct("0123456789", 2));  // 72
        System.out.println(largestSeriesProduct("12345", 6));  // -1
        System.out.println(largestSeriesProduct("54321", 0));  // 1
    }
}
