package ZeroShot.gpt4o;
public class Task9 {
    public static String oddOrEven(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum % 2 == 0 ? "even" : "odd";
    }

    public static void main(String[] args) {
        System.out.println(oddOrEven(new int[]{0}));         // Output: "even"
        System.out.println(oddOrEven(new int[]{0, 1, 4}));   // Output: "odd"
        System.out.println(oddOrEven(new int[]{0, -1, -5})); // Output: "even"
        System.out.println(oddOrEven(new int[]{1, 3, 5}));   // Output: "odd"
        System.out.println(oddOrEven(new int[]{2, 4, 6}));   // Output: "even"
    }
}