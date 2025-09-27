package Vanilla.codestral;
public class Task14 {
    public static int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{1,2,3,4,3,2,1})); // Output: 3
        System.out.println(findMiddleIndex(new int[]{1,100,50,-51,1,1})); // Output: 1
        System.out.println(findMiddleIndex(new int[]{20,10,-80,10,10,15,35})); // Output: 0
        System.out.println(findMiddleIndex(new int[]{1,2,3})); // Output: -1
        System.out.println(findMiddleIndex(new int[]{2,1,-1})); // Output: 0
    }
}