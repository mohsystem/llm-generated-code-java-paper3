package ZeroShot.codestral;
public class Task183 {
    public static int maxProduct(String input, int span) {
        int maxProduct = 0;
        for (int i = 0; i <= input.length() - span; i++) {
            int product = 1;
            for (int j = i; j < i + span; j++) {
                product *= input.charAt(j) - '0';
            }
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct("63915", 3)); // 162
        System.out.println(maxProduct("123456789", 4)); // 5040
        System.out.println(maxProduct("987654321", 2)); // 72
        System.out.println(maxProduct("111111111", 3)); // 1
        System.out.println(maxProduct("999999999", 5)); // 139975393
    }
}