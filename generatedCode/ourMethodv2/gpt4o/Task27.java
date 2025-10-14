package ourMethodv2.gpt4o;
public class Task27 {

    public static int findOutlier(int[] integers) {
        int oddCount = 0;
        int evenCount = 0;
        int lastOdd = 0;
        int lastEven = 0;

        for (int num : integers) {
            if (num % 2 == 0) {
                evenCount++;
                lastEven = num;
            } else {
                oddCount++;
                lastOdd = num;
            }

            if (oddCount > 1 && evenCount > 0) {
                return lastEven;
            } else if (evenCount > 1 && oddCount > 0) {
                return lastOdd;
            }
        }
        return 0; // Should not reach here if input is guaranteed to have an outlier
    }

    public static void main(String[] args) {
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36})); // 11
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21})); // 160
        System.out.println(findOutlier(new int[]{4, 8, 15, 16, 23, 42, 1})); // 1
        System.out.println(findOutlier(new int[]{2, 6, 8, 10, 3})); // 3
        System.out.println(findOutlier(new int[]{3, 5, 7, 9, 11, 12})); // 12
    }
}