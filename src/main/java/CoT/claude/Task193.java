package CoT.claude;

public class Task193 {
    public static boolean xorGame(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        if (nums.length % 2 == 0) {
            return true;
        }
        
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        return xor == 0;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 1, 2};
        System.out.println("Test case 1: " + xorGame(nums1));  // false
        
        // Test case 2
        int[] nums2 = {0, 1};
        System.out.println("Test case 2: " + xorGame(nums2));  // true
        
        // Test case 3
        int[] nums3 = {1, 2, 3};
        System.out.println("Test case 3: " + xorGame(nums3));  // true
        
        // Test case 4
        int[] nums4 = {1, 2, 3, 4};
        System.out.println("Test case 4: " + xorGame(nums4));  // true
        
        // Test case 5
        int[] nums5 = {1, 1, 1};
        System.out.println("Test case 5: " + xorGame(nums5));  // false
    }
}
