package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task169 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Task169 task169 = new Task169();
        int[] nums1 = {5, 2, 6, 1};
        List<Integer> output1 = task169.countSmaller(nums1);
        System.out.println(output1); // Output: [2, 1, 1, 0]

        int[] nums2 = {-1};
        List<Integer> output2 = task169.countSmaller(nums2);
        System.out.println(output2); // Output: [0]

        int[] nums3 = {-1, -1};
        List<Integer> output3 = task169.countSmaller(nums3);
        System.out.println(output3); // Output: [0, 0]

        int[] nums4 = {1, 2, 3, 4};
        List<Integer> output4 = task169.countSmaller(nums4);
        System.out.println(output4); // Output: [0, 0, 0, 0]

        int[] nums5 = {4, 3, 2, 1};
        List<Integer> output5 = task169.countSmaller(nums5);
        System.out.println(output5); // Output: [3, 2, 1, 0]
    }
}