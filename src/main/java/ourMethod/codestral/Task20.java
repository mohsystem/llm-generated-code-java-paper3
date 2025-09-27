package ourMethod.codestral;
public class Task20 {
    public static int digPow(int n, int p) {
        int originalN = n;
        int sum = 0;
        int length = String.valueOf(n).length();

        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, p);
            n /= 10;
            p++;
        }

        for (int k = 1; k * originalN <= sum; k++) {
            if (k * originalN == sum) {
                return k;
            }
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