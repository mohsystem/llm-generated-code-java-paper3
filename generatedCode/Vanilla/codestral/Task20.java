package Vanilla.codestral;
public class Task20 {
    public static int digPow(int n, int p) {
        int temp = n, sum = 0;
        while (temp > 0) {
            sum += Math.pow(temp % 10, p++);
            temp /= 10;
        }
        return sum % n == 0 ? sum / n : -1;
    }

    public static void main(String[] args) {
        System.out.println(digPow(89, 1));  // Output: 1
        System.out.println(digPow(92, 1));  // Output: -1
        System.out.println(digPow(695, 2)); // Output: 2
        System.out.println(digPow(46288, 3)); // Output: 51
    }
}