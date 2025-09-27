package CoT.codestral;
public class Task20 {
    public static int digPow(int n, int p) {
        int sum = 0;
        int temp = n;
        int digits = (int) Math.log10(n) + 1;

        for (int i = 0; i < digits; i++) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, p + i);
            temp /= 10;
        }

        if (sum % n == 0) {
            return sum / n;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(digPow(89, 1)); // Output: 1
        System.out.println(digPow(92, 1)); // Output: -1
        System.out.println(digPow(695, 2)); // Output: 2
        System.out.println(digPow(46288, 3)); // Output: 51
    }
}