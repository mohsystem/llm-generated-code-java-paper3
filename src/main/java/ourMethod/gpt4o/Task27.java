package ourMethod.gpt4o;
public class Task27 {
    public static int findOutlier(int[] integers) {
        int countEven = 0;
        int countOdd = 0;
        int lastEven = 0;
        int lastOdd = 0;

        for (int num : integers) {
            if (num % 2 == 0) {
                countEven++;
                lastEven = num;
            } else {
                countOdd++;
                lastOdd = num;
            }
            if (countEven > 1 && countOdd > 0) {
                return lastOdd;
            }
            if (countOdd > 1 && countEven > 0) {
                return lastEven;
            }
        }
        return countEven > countOdd ? lastOdd : lastEven;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {2, 4, 0, 100, 4, 11, 2602, 36},
            {160, 3, 1719, 19, 11, 13, -21},
            {2, 6, 8, 10, 3},
            {1, 1, 1, 1, 2},
            {-102, -200, -301, -400},
        };
        
        for (int[] testCase : testCases) {
            System.out.println(findOutlier(testCase));
        }
    }
}