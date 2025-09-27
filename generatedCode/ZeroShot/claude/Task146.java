package ZeroShot.claude;

public class Task146 {
    public static int findMissing(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        int n = nums.length + 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] test1 = {1, 2, 4, 5}; // missing 3
        int[] test2 = {1, 3, 4}; // missing 2
        int[] test3 = {2, 3, 4, 5}; // missing 1
        int[] test4 = {1, 2, 3, 5, 6}; // missing 4
        int[] test5 = {1, 2, 3, 4, 6, 7}; // missing 5
        
        System.out.println("Missing number: " + findMissing(test1)); // 3
        System.out.println("Missing number: " + findMissing(test2)); // 2
        System.out.println("Missing number: " + findMissing(test3)); // 1
        System.out.println("Missing number: " + findMissing(test4)); // 4
        System.out.println("Missing number: " + findMissing(test5)); // 5
    }
}
