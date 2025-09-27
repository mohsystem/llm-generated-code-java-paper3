package ZeroShot.codestral;
public class Task9 {
    public static String oddOrEven(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        System.out.println(oddOrEven(new int[]{0})); // "even"
        System.out.println(oddOrEven(new int[]{0, 1, 4})); // "odd"
        System.out.println(oddOrEven(new int[]{0, -1, -5})); // "even"
    }
}