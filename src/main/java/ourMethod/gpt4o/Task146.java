package ourMethod.gpt4o;
public class Task146 {

    public static int findMissingNumber(int[] numbers, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{1, 2, 4, 5, 6}, 6)); // Output: 3
        System.out.println(findMissingNumber(new int[]{1, 3}, 3)); // Output: 2
        System.out.println(findMissingNumber(new int[]{2, 3, 4, 5}, 5)); // Output: 1
        System.out.println(findMissingNumber(new int[]{1, 2, 3, 5}, 5)); // Output: 4
        System.out.println(findMissingNumber(new int[]{1}, 2)); // Output: 2
    }
}