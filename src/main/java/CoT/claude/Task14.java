package CoT.claude;

public class Task14 {
    public static int findEqualIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        
        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        long leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            long rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test cases
        int[] test1 = {1,2,3,4,3,2,1};
        int[] test2 = {1,100,50,-51,1,1};
        int[] test3 = {20,10,-80,10,10,15,35};
        int[] test4 = {1,2,3,4,5};
        int[] test5 = {-1,-2,-3,0,3,2,1};
        
        System.out.println(findEqualIndex(test1)); // Expected: 3
        System.out.println(findEqualIndex(test2)); // Expected: 1
        System.out.println(findEqualIndex(test3)); // Expected: 0
        System.out.println(findEqualIndex(test4)); // Expected: -1
        System.out.println(findEqualIndex(test5)); // Expected: 3
    }
}
