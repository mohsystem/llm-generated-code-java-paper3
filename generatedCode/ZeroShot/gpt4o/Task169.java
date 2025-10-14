package ZeroShot.openai;
public class Task169 {
    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        mergeSort(nums, indices, counts, 0, n);
        return counts;
    }

    private static void mergeSort(int[] nums, int[] indices, int[] counts, int start, int end) {
        if (end - start <= 1) return;
        int mid = (start + end) / 2;
        mergeSort(nums, indices, counts, start, mid);
        mergeSort(nums, indices, counts, mid, end);
        int[] temp = new int[end - start];
        int left = start, right = mid, index = 0;
        while (left < mid || right < end) {
            if (right == end || (left < mid && nums[indices[left]] <= nums[indices[right]])) {
                counts[indices[left]] += right - mid;
                temp[index++] = indices[left++];
            } else {
                temp[index++] = indices[right++];
            }
        }
        System.arraycopy(temp, 0, indices, start, end - start);
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {5, 2, 6, 1},
            {-1},
            {-1, -1},
            {2, 0, 1},
            {7, 6, 5, 4, 3}
        };

        for (int[] testCase : testCases) {
            int[] result = countSmaller(testCase);
            for (int res : result) {
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }
}