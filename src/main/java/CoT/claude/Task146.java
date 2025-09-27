package CoT.claude;

public class Task146 {
    public static int findMissingNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        
        int n = arr.length + 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        
        for (int num : arr) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] test1 = {1, 2, 4, 5};  // missing 3
        int[] test2 = {1, 3, 4, 5};  // missing 2
        int[] test3 = {2, 3, 4, 5};  // missing 1
        int[] test4 = {1, 2, 3, 5};  // missing 4
        int[] test5 = {1, 2, 3, 4};  // missing 5
        
        System.out.println("Missing number in test1: " + findMissingNumber(test1));
        System.out.println("Missing number in test2: " + findMissingNumber(test2));
        System.out.println("Missing number in test3: " + findMissingNumber(test3));
        System.out.println("Missing number in test4: " + findMissingNumber(test4));
        System.out.println("Missing number in test5: " + findMissingNumber(test5));
    }
}
