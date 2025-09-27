package CoT.claude;

public class Task192 {
    public static boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) return true;
        
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {1, 1, 2},      // false
            {0, 1},         // true
            {1, 2, 3},      // true
            {1, 2, 3, 4},   // true
            {1, 1, 1, 2}    // false
        };
        
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + (i + 1) + ": " + xorGame(testCases[i]));
        }
    }
}
