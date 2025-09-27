package CoT.llama31;
public class Task27 {
    public static int findOutlier(int[] arr) {
        int evenCount = 0;
        int oddCount = 0;
        int evenNum = 0;
        int oddNum = 0;

        for (int i = 0; i < 3; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
                evenNum = arr[i];
            } else {
                oddCount++;
                oddNum = arr[i];
            }
        }

        if (evenCount > oddCount) {
            return oddNum;
        } else {
            return evenNum;
        }
    }

    public static void main(String[] args) {
        int[] test1 = {2, 4, 0, 100, 4, 11, 2602, 36};
        int[] test2 = {160, 3, 1719, 19, 11, 13, -21};
        int[] test3 = {1, 3, 5, 7, 9, 10};
        int[] test4 = {2, 4, 6, 8, 10, 11};
        int[] test5 = {100, 200, 300, 400, 500, 501};

        System.out.println(findOutlier(test1)); // 11
        System.out.println(findOutlier(test2)); // 160
        System.out.println(findOutlier(test3)); // 10
        System.out.println(findOutlier(test4)); // 11
        System.out.println(findOutlier(test5)); // 501
    }
}