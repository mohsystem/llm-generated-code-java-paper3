package ZeroShot.claude;

public class Task163 {
    public static int longestRun(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return 1;
        
        int maxRun = 1;
        int currentRun = 1;
        boolean isIncreasing = true;
        
        for (int i = 1; i < arr.length; i++) {
            if (i == 1) {
                isIncreasing = arr[1] > arr[0];
            }
            
            if ((isIncreasing && arr[i] == arr[i-1] + 1) || 
                (!isIncreasing && arr[i] == arr[i-1] - 1)) {
                currentRun++;
                maxRun = Math.max(maxRun, currentRun);
            } else {
                if (i < arr.length - 1) {
                    isIncreasing = arr[i+1] > arr[i];
                }
                currentRun = 1;
            }
        }
        
        return maxRun;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9}));  // 5
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15}));     // 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1}));              // 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15}));         // 1
        System.out.println(longestRun(new int[]{1, 2, 3, 4, 5}));           // 5
    }
}
