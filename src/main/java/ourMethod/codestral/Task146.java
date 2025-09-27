package ourMethod.codestral;
public class Task146 {
    public static int findMissingNumber(int[] nums) {
        int n = nums.length + 1;
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6};
        System.out.println(findMissingNumber(nums));
    }
}