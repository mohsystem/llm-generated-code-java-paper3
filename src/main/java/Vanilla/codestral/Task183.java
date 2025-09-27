package Vanilla.codestral;
public class Task183 {
    public static int maxProduct(String num, int k) {
        int n = num.length();
        if (n < k) {
            return -1;
        }
        int maxProd = 0;
        for (int i = 0; i <= n - k; i++) {
            int prod = 1;
            for (int j = i; j < i + k; j++) {
                prod *= num.charAt(j) - '0';
            }
            maxProd = Math.max(maxProd, prod);
        }
        return maxProd;
    }
    public static void main(String[] args) {
        System.out.println(maxProduct("63915", 3)); // Output: 162
    }
}