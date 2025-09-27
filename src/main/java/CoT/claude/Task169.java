package CoT.claude;

import java.util.*;

public class Task169 {
    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = i+1; j < n; j++) {
                if(nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {5,2,6,1};
        System.out.println(Arrays.toString(countSmaller(nums1))); // [2,1,1,0]
        
        // Test case 2 
        int[] nums2 = {-1};
        System.out.println(Arrays.toString(countSmaller(nums2))); // [0]
        
        // Test case 3
        int[] nums3 = {-1,-1};
        System.out.println(Arrays.toString(countSmaller(nums3))); // [0,0]
        
        // Test case 4
        int[] nums4 = {1,2,3,4};
        System.out.println(Arrays.toString(countSmaller(nums4))); // [0,0,0,0]
        
        // Test case 5
        int[] nums5 = {4,3,2,1};
        System.out.println(Arrays.toString(countSmaller(nums5))); // [3,2,1,0]
    }
}
