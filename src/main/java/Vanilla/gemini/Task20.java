package Vanilla.gemini;
import java.util.ArrayList;
import java.util.List;

class Task20 {
    public static long digPow(int n, int p) {
        List<Integer> digits = new ArrayList<>();
        int temp = n;
        while (temp > 0) {
            digits.add(0, temp % 10);
            temp /= 10;
        }

        long sum = 0;
        for (int i = 0; i < digits.size(); i++) {
            sum += Math.pow(digits.get(i), p + i);
        }

        if (sum % n == 0) {
            return sum / n;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(digPow(89, 1)); // 1
        System.out.println(digPow(92, 1)); // -1
        System.out.println(digPow(695, 2)); // 2
        System.out.println(digPow(46288, 3)); // 51
        System.out.println(digPow(46288, 5)); // -1

    }
}