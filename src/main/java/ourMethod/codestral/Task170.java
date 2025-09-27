package ourMethod.codestral;
public class Task170 {
    public int numSubarrayBoundedMax(int[] nums, int lower, int upper) {
        int result = 0;
        int j = 0, k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= lower && nums[i] <= upper) {
                k = i + 1;
            } else if (nums[i] > upper) {
                j = k = i + 1;
            }
            result += k - j;
        }
        return result;
    }

    public static void main(String[] args) {
        Task170 task = new Task170();
        System.out.println(task.numSubarrayBoundedMax(new int[]{-2,5,-1}, -2, 2)); // Output: 3
        System.out.println(task.numSubarrayBoundedMax(new int[]{0}, 0, 0)); // Output: 1
    }
}