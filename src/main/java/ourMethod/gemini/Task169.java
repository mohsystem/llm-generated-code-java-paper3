package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;

class Task169 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            counts.add(count);
        }
        return counts;
    }

    public static void main(String[] args) {
        Task169 task169 = new Task169();

        int[] nums1 = {5, 2, 6, 1};
        System.out.println(task169.countSmaller(nums1)); // Output: [2, 1, 1, 0]

        int[] nums2 = {-1};
        System.out.println(task169.countSmaller(nums2)); // Output: [0]

        int[] nums3 = {-1, -1};
        System.out.println(task169.countSmaller(nums3)); // Output: [0, 0]

        int[] nums4 = {1, 2, 3, 4};
        System.out.println(task169.countSmaller(nums4)); // Output: [0, 0, 0, 0]

        int[] nums5 = {4, 3, 2, 1};
        System.out.println(task169.countSmaller(nums5)); // Output: [3, 2, 1, 0]
    }
}