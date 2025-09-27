package ourMethod.llama31;
public class Task20 {
    public static int findK(int n, int p) {
        // Convert n to a string to easily access its digits
        String strN = Integer.toString(n);
        long sum = 0;
        for (int i = 0; i < strN.length(); i++) {
            // Calculate the power and add to the sum
            sum += (long) Math.pow(Character.getNumericValue(strN.charAt(i)), p + i);
        }
        // Check if the sum is a multiple of n
        if (sum % n == 0) {
            return (int) (sum / n);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findK(89, 1));   // Expected: 1
        System.out.println(findK(92, 1));   // Expected: -1
        System.out.println(findK(695, 2));  // Expected: 2
        System.out.println(findK(46288, 3)); // Expected: 51
        System.out.println(findK(123, 2));  // Expected: -1
    }
}