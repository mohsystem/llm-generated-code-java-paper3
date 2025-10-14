package Vanilla.openai;
public class Task183 {
    public static int largestProduct(String input, int span) {
        int maxProduct = 0;
        for (int i = 0; i <= input.length() - span; i++) {
            String series = input.substring(i, i + span);
            int product = 1;
            for (char c : series.toCharArray()) {
                product *= Character.getNumericValue(c);
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
        System.out.println(largestProduct("9876543210", 4)); // 3024
        System.out.println(largestProduct("11111", 2)); // 1
        System.out.println(largestProduct("54321", 3)); // 60
    }
}