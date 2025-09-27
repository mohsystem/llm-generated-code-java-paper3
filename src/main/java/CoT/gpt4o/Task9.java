package CoT.gpt4o;
public class Task9 {
    public static String oddOrEven(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        System.out.println(oddOrEven(new int[]{0}));        // even
        System.out.println(oddOrEven(new int[]{0, 1, 4}));  // odd
        System.out.println(oddOrEven(new int[]{0, -1, -5})); // even
        System.out.println(oddOrEven(new int[]{2, 2, 2}));  // even
        System.out.println(oddOrEven(new int[]{1, 1, 1}));  // odd
    }
}