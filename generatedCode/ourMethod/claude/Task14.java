package ourMethod.claude;

public class Task14 {
    public static int findEvenIndex(int[] arr) {
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
        System.out.println(findEvenIndex(new int[]{1,2,3,4,3,2,1}));  // Should print 3
        System.out.println(findEvenIndex(new int[]{1,100,50,-51,1,1}));  // Should print 1
        System.out.println(findEvenIndex(new int[]{20,10,-80,10,10,15,35}));  // Should print 0
        System.out.println(findEvenIndex(new int[]{1,2,3,4,5}));  // Should print -1
        System.out.println(findEvenIndex(new int[]{2,2,2,2}));  // Should print 2
    }
}
