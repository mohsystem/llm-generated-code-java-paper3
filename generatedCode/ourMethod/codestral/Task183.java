package ourMethod.codestral;
public class Task183 {
    public static int largestProduct(String num, int span) {
        if (num == null || num.length() < span || span <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxProduct = 0;
        for (int i = 0; i <= num.length() - span; i++) {
            int product = 1;
            for (int j = i; j < i + span; j++) {
                product *= num.charAt(j) - '0';
            }
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(largestProduct("63915", 3)); // 162
        System.out.println(largestProduct("123456789", 4)); // 2520
        System.out.println(largestProduct("999999", 2)); // 81
        System.out.println(largestProduct("000000", 2)); // 0
        System.out.println(largestProduct("987654321", 5)); // 362880
    }
}