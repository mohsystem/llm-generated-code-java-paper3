package ourMethod.llama31;
public class Task169 {
    public static void main(String[] args) {
        int[][] testCases = {
            {5, 2, 6, 1},
            {-1},
            {-1, -1}
        };

        for (int[] testCase : testCases) {
            int[] counts = countSmallerElements(testCase);
            for (int count : counts) {
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }

    public static int[] countSmallerElements(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(nums, indices, counts, 0, n - 1);
        return counts;
    }

    private static void mergeSort(int[] nums, int[] indices, int[] counts, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, indices, counts, start, mid);
        mergeSort(nums, indices, counts, mid + 1, end);
        merge(nums, indices, counts, start, mid, end);
    }

    private static void merge(int[] nums, int[] indices, int[] counts, int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[start + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                indices[k] = start + i;
                counts[indices[k]] += j;
                i++;
            } else {
                indices[k] = mid + 1 + j;
                j++;
            }
            k++;
        }

        while (i < left.length) {
            indices[k] = start + i;
            counts[indices[k]] += j;
            i++;
            k++;
        }

        while (j < right.length) {
            indices[k] = mid + 1 + j;
            j++;
            k++;
        }

        for (int l = 0; l < left.length; l++) {
            nums[start + l] = left[l];
        }
        for (int l = 0; l < right.length; l++) {
            nums[mid + 1 + l] = right[l];
        }
    }
}