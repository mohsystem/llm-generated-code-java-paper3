package ourMethod.claude;

class Task192 {
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
        // Test cases
        int[][] testCases = {
            {1, 1, 2},
            {0, 1},
            {1, 2, 3},
            {1, 2, 3, 4},
            {0, 0, 0}
        };
        
        for (int i = 0; i < testCases.length; i++) {
            boolean result = xorGame(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }
}
