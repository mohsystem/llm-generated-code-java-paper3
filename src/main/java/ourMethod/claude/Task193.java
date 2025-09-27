package ourMethod.claude;

public class Task193 {
    public boolean xorGame(int[] nums) {
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
        Task193 solution = new Task193();
        
        // Test cases
        System.out.println(solution.xorGame(new int[]{1,1,2}));      // false
        System.out.println(solution.xorGame(new int[]{0,1}));        // true
        System.out.println(solution.xorGame(new int[]{1,2,3}));      // true
        System.out.println(solution.xorGame(new int[]{1,2,3,4}));    // true
        System.out.println(solution.xorGame(new int[]{1,1,1}));      // false
    }
}
