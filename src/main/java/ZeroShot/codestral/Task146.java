package ZeroShot.codestral;
public class Task146 {
    public static int findMissingNumber(int[] numbers) {
        int n = numbers.length + 1;
        int sum = n * (n + 1) / 2;
        int arraySum = 0;
        for (int num : numbers) {
            arraySum += num;
        }
        return sum - arraySum;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 4, 5};
        System.out.println(findMissingNumber(test1)); // Output: 3

        int[] test2 = {3, 4, 5, 6, 7, 8, 10};
        System.out.println(findMissingNumber(test2)); // Output: 9
    }
}