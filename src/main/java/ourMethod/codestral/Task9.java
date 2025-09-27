package ourMethod.codestral;
public class Task9 {
    public static String oddOrEven(int[] arr) {
        if (arr == null) {
            return "even";
        }
        int sum = 0;
        for (int num : arr) {
            // Prevent Integer Overflow or Wraparound
            if (Integer.MAX_VALUE - sum < num) {
                throw new IllegalArgumentException("Sum is too large");
            }
            sum += num;
        }
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        System.out.println(oddOrEven(new int[] {0})); // even
        System.out.println(oddOrEven(new int[] {0, 1, 4})); // odd
        System.out.println(oddOrEven(new int[] {0, -1, -5})); // even
    }
}