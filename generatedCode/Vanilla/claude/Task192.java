package Vanilla.claude;

class Task192 {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) return true;
        
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
    
    public static void main(String[] args) {
        Task192 solution = new Task192();
        
        // Test case 1
        System.out.println(solution.xorGame(new int[]{1,1,2}));  // false
        
        // Test case 2
        System.out.println(solution.xorGame(new int[]{0,1}));    // true
        
        // Test case 3
        System.out.println(solution.xorGame(new int[]{1,2,3}));  // true
        
        // Test case 4
        System.out.println(solution.xorGame(new int[]{1,2,3,4})); // true
        
        // Test case 5
        System.out.println(solution.xorGame(new int[]{1,1,1}));   // false
    }
}
