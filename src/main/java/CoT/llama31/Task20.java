package CoT.llama31;
public class Task20 {
    public static int findK(int n, int p) {
        String strN = String.valueOf(n);
        long sum = 0;
        for (int i = 0; i < strN.length(); i++) {
            sum += (long) Math.pow(Character.getNumericValue(strN.charAt(i)), p + i);
        }
        if (sum % n == 0) {
            return (int) (sum / n);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findK(89, 1));  // Expected output: 1
        System.out.println(findK(92, 1));  // Expected output: -1
        System.out.println(findK(695, 2)); // Expected output: 2
        System.out.println(findK(46288, 3)); // Expected output: 51
        System.out.println(findK(123, 1)); // Expected output: -1
    }
}