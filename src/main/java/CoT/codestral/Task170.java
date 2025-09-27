package CoT.codestral;
public class Task170 {
    public static int rangeSumCount(int[] nums, int lower, int upper) {
        int count = 0;
        int[] prefixSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(rangeSumCount(new int[]{-2, 5, -1}, -2, 2)); // Output: 3
        System.out.println(rangeSumCount(new int[]{0}, 0, 0)); // Output: 1
    }
}