package Vanilla.claude;

public class Task163 {
    public static int longestRun(int[] arr) {
        if (arr.length <= 1) return arr.length;
        
        int maxLen = 1;
        int currLen = 1;
        boolean isIncreasing = true;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1] + 1) {
                if (isIncreasing || currLen == 1) {
                    isIncreasing = true;
                    currLen++;
                } else {
                    currLen = 2;
                }
            }
            else if (arr[i] == arr[i-1] - 1) {
                if (!isIncreasing || currLen == 1) {
                    isIncreasing = false;
                    currLen++;
                } else {
                    currLen = 2;
                }
            }
            else {
                currLen = 1;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        // Test case 1
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        
        // Test case 2
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        
        // Test case 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); // 2
        
        // Test case 4
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15})); // 1
        
        // Test case 5
        System.out.println(longestRun(new int[]{1})); // 1
    }
}
