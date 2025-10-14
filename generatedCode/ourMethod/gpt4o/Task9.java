package ourMethod.openai;
public class Task9 {
    public static String sumOddOrEven(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "even";
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        System.out.println(sumOddOrEven(new int[]{0})); // "even"
        System.out.println(sumOddOrEven(new int[]{0, 1, 4})); // "odd"
        System.out.println(sumOddOrEven(new int[]{0, -1, -5})); // "even"
        System.out.println(sumOddOrEven(new int[]{2, 3, 5})); // "even"
        System.out.println(sumOddOrEven(new int[]{1, 1, 1, 1})); // "even"
    }
}