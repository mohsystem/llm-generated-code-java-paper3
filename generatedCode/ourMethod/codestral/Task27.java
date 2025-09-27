package ourMethod.codestral;
public class Task27 {
    public static int findOutlier(int[] numbers) {
        int oddCount = 0;
        int evenCount = 0;
        int lastOdd = 0;
        int lastEven = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
                lastEven = number;
            } else {
                oddCount++;
                lastOdd = number;
            }

            if (oddCount > 1 && evenCount == 1) {
                return lastEven;
            } else if (evenCount > 1 && oddCount == 1) {
                return lastOdd;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));  // Output: 11
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21})); // Output: 160
    }
}