package ZeroShot.codestral;
public class Task20 {
    public static int digPow(int n, int p) {
        int originalNumber = n;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, p);
            n /= 10;
            p++;
        }
        if (sum % originalNumber == 0) {
            return sum / originalNumber;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(digPow(89, 1)); // 1
        System.out.println(digPow(92, 1)); // -1
        System.out.println(digPow(695, 2)); // 2
        System.out.println(digPow(46288, 3)); // 51
    }
}