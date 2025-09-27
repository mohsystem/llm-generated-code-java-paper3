package ourMethod.claude;

public class Task27 {
    public static int findOutlier(int[] integers) {
        // Count first 3 elements to determine array type
        int evenCount = 0;
        for(int i = 0; i < 3; i++) {
            if(integers[i] % 2 == 0) {
                evenCount++;
            }
        }
        
        // Determine if array is mostly even or odd
        boolean isEvenArray = evenCount >= 2;
        
        // Find outlier based on array type
        for(int num : integers) {
            if(isEvenArray && num % 2 != 0) {
                return num; // Return odd outlier
            } else if(!isEvenArray && num % 2 == 0) {
                return num; // Return even outlier
            }
        }
        
        return 0; // Should never reach here given problem constraints
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36})); // Should return 11
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21})); // Should return 160
        System.out.println(findOutlier(new int[]{3, 7, 9, 5, 2, 13})); // Should return 2
        System.out.println(findOutlier(new int[]{2, 6, 8, 3, 10, 14})); // Should return 3
        System.out.println(findOutlier(new int[]{1, 3, 5, 7, 8, 9, 11})); // Should return 8
    }
}
