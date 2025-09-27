package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;

class Task20 {
    public static int digPow(int n, int p) {
        List<Integer> digits = new ArrayList<>();
        int tempN = n;
        while (tempN > 0) {
            digits.add(0, tempN % 10);
            tempN /= 10;
        }

        long sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, p);
            p++;
        }

        if (sum % n == 0) {
            return (int) (sum / n);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(digPow(89, 1)); // Expected 1
        System.out.println(digPow(92, 1)); // Expected -1
        System.out.println(digPow(695, 2)); // Expected 2
        System.out.println(digPow(46288, 3)); // Expected 51
        System.out.println(digPow(92, 1)); // Expected -1

    }
}