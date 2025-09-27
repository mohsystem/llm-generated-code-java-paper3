package CoT.claude;

public class Task163 {
    public static int longestRun(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return 1;
        
        int maxLen = 1;
        int currLen = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i-1]) == 1) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 1;
            }
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); // 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15})); // 1
        System.out.println(longestRun(new int[]{1, 2, 3, 4, 5})); // 5
    }
}
