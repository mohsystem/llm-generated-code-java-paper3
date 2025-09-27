package CoT.codestral;
public class Task183 {
    public static int largestProduct(String input, int span) {
        int maxProduct = 0;
        for (int i = 0; i <= input.length() - span; i++) {
            int product = 1;
            for (int j = i; j < i + span; j++) {
                product *= Character.getNumericValue(input.charAt(j));
            }
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(largestProduct("63915", 3)); // Output: 162
    }
}