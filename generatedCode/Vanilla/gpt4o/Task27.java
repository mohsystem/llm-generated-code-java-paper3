package Vanilla.openai;
public class Task27 {
    public static int findOutlier(int[] numbers) {
        int evenCount = 0, oddCount = 0, lastEven = 0, lastOdd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
                lastEven = number;
            } else {
                oddCount++;
                lastOdd = number;
            }
            if (evenCount > 1 && oddCount > 0) return lastOdd;
            if (oddCount > 1 && evenCount > 0) return lastEven;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21}));
        System.out.println(findOutlier(new int[]{1, 3, 5, 7, 2}));
        System.out.println(findOutlier(new int[]{6, 8, 10, 12, 3}));
        System.out.println(findOutlier(new int[]{-2, -4, -6, -8, -11}));
    }
}