package ourMethod.claude;

import java.util.*;

public class Task169 {
    public static int[] countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n];
        ArrayList<Integer> sorted = new ArrayList<>();
        
        // Start from right to left
        for (int i = n - 1; i >= 0; i--) {
            int index = findInsertPosition(sorted, nums[i]);
            result[i] = index;
            sorted.add(index, nums[i]);
        }
        
        return result;
    }
    
    private static int findInsertPosition(ArrayList<Integer> sorted, int target) {
        if (sorted.isEmpty()) {
            return 0;
        }
        
        int left = 0;
        int right = sorted.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sorted.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {5, 2, 6, 1},
            {-1},
            {-1, -1},
            {1, 2, 3, 4},
            {4, 3, 2, 1}
        };
        
        for (int[] test : testCases) {
            System.out.print("Input: ");
            System.out.println(Arrays.toString(test));
            System.out.print("Output: ");
            System.out.println(Arrays.toString(countSmaller(test)));
            System.out.println();
        }
    }
}
