package ourMethodv2.gpt4o;
public class Task9 {

    public static String oddOrEven(int[] array) {
        if (array == null || array.length == 0) {
            return "even";
        }
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(oddOrEven(new int[]{0})); // even
        System.out.println(oddOrEven(new int[]{0, 1, 4})); // odd
        System.out.println(oddOrEven(new int[]{0, -1, -5})); // even
        System.out.println(oddOrEven(new int[]{3, 5, 7})); // odd
        System.out.println(oddOrEven(new int[]{})); // even
    }
}