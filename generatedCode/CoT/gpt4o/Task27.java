package CoT.openai;
public class Task27 {
    public static int findOutlier(int[] array) {
        int evenCount = 0;
        int oddCount = 0;
        int lastEven = 0;
        int lastOdd = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                evenCount++;
                lastEven = num;
            } else {
                oddCount++;
                lastOdd = num;
            }
            if (evenCount > 1 && oddCount > 0) {
                return lastOdd;
            }
            if (oddCount > 1 && evenCount > 0) {
                return lastEven;
            }
        }
        return 0; // should never reach here if input is valid
    }

    public static void main(String[] args) {
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36})); // 11
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21})); // 160
        System.out.println(findOutlier(new int[]{2, 6, 8, 10, 3})); // 3
        System.out.println(findOutlier(new int[]{1, 3, 5, 7, 4})); // 4
        System.out.println(findOutlier(new int[]{-2, -4, 5, -8})); // 5
    }
}