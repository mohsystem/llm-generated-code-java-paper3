package ZeroShot.gpt4o;
public class Task27 {
    public static int findOutlier(int[] array) {
        int countEven = 0, countOdd = 0, lastEven = 0, lastOdd = 0;
        
        for (int num : array) {
            if (num % 2 == 0) {
                countEven++;
                lastEven = num;
            } else {
                countOdd++;
                lastOdd = num;
            }
            
            if (countEven > 1 && countOdd == 1) return lastOdd;
            if (countOdd > 1 && countEven == 1) return lastEven;
        }
        
        return 0; // Should never reach here if input is correct
    }

    public static void main(String[] args) {
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36})); // 11
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21})); // 160
        System.out.println(findOutlier(new int[]{1, 2, 3})); // 2
        System.out.println(findOutlier(new int[]{4, 1, 3, 5, 7})); // 4
        System.out.println(findOutlier(new int[]{2, 6, 8, -10, 3})); // 3
    }
}