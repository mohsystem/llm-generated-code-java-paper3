package ZeroShot.claude;

public class Task9 {
    public static String oddOrEven(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "even";
        }
        
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(oddOrEven(new int[]{0}));  // even
        System.out.println(oddOrEven(new int[]{0, 1, 4}));  // odd
        System.out.println(oddOrEven(new int[]{0, -1, -5}));  // even
        System.out.println(oddOrEven(new int[]{}));  // even
        System.out.println(oddOrEven(new int[]{1, 2, 3, 4}));  // even
    }
}
