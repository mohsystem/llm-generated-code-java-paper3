package CoT.gpt4o;
public class Task146 {
    public static int findMissingNumber(int[] nums, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{1, 2, 4, 5, 6}, 6)); // 3
        System.out.println(findMissingNumber(new int[]{1, 3, 4, 5}, 5));    // 2
        System.out.println(findMissingNumber(new int[]{2, 3, 4, 5}, 5));    // 1
        System.out.println(findMissingNumber(new int[]{1, 2, 3, 5}, 5));    // 4
        System.out.println(findMissingNumber(new int[]{1, 2, 3, 4}, 5));    // 5
    }
}