package ZeroShot.claude;

public class Task27 {
    public static int findOutlier(int[] integers) {
        int evenCount = 0;
        int lastEven = 0;
        int lastOdd = 0;
        
        for(int i = 0; i < 3; i++) {
            if(integers[i] % 2 == 0) {
                evenCount++;
                lastEven = integers[i];
            } else {
                lastOdd = integers[i];
            }
        }
        
        boolean isEvenArray = evenCount >= 2;
        
        if(isEvenArray) {
            for(int num : integers) {
                if(num % 2 != 0) return num;
            }
        } else {
            for(int num : integers) {
                if(num % 2 == 0) return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));  // Should return 11
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21}));  // Should return 160
        System.out.println(findOutlier(new int[]{1, 3, 5, 7, 9, 10, 11}));  // Should return 10
        System.out.println(findOutlier(new int[]{2, 4, 6, 8, 10, 11, 12}));  // Should return 11
        System.out.println(findOutlier(new int[]{-3, -5, -7, -99, 0, -11}));  // Should return 0
    }
}
