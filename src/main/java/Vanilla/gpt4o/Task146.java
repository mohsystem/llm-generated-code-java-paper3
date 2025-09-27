package Vanilla.gpt4o;
public class Task146 {
    public static int findMissingNumber(int[] numbers, int n) {
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;
        for (int num : numbers) {
            arraySum += num;
        }
        return totalSum - arraySum;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{1, 2, 4, 5, 6}, 6)); // Output: 3
        System.out.println(findMissingNumber(new int[]{2, 3, 4, 5, 6}, 6)); // Output: 1
        System.out.println(findMissingNumber(new int[]{1, 3, 4, 5, 6}, 6)); // Output: 2
        System.out.println(findMissingNumber(new int[]{1, 2, 3, 5, 6}, 6)); // Output: 4
        System.out.println(findMissingNumber(new int[]{1, 2, 3, 4, 6}, 6)); // Output: 5
    }
}