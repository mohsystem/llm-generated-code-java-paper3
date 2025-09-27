package Vanilla.claude;

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
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));  // 11
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21}));  // 160
        System.out.println(findOutlier(new int[]{1, 2, 3}));  // 2
        System.out.println(findOutlier(new int[]{2, 6, 8, 10, 3}));  // 3
        System.out.println(findOutlier(new int[]{1, 1, 0, 1, 1}));  // 0
    }
}
